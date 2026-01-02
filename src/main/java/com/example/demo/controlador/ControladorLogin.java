/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controlador;

import com.example.demo.entidades.Cli;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Login;
import com.example.demo.servicios.ServicioCliUsu;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author JEFFERSON
 */
@RestController
@RequestMapping("/cliServer")
public class ControladorLogin {

    @Autowired
    private ServicioCliUsu servicioCliUsu;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String correo, @RequestParam String password,
            @RequestParam String recaptchaResponse) {
        boolean isCaptchaValid = verifyCaptcha(recaptchaResponse);

        if (isCaptchaValid) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Captcha inválido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Map<String, Object> response = servicioCliUsu.verificarCredenciales(correo, password);

        if (response.get("message").equals("Credenciales incorrectas")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Validated Cli clientes, BindingResult result) {
        Map<String, String> response = new HashMap<>();

        if (servicioCliUsu.existeCorreo(clientes.getCorreo())) {
            response.put("message", "Correo ya registrado.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        String isCliente = servicioCliUsu.registrarNuevoUsuario(clientes);

        if (isCliente.equals("")) {
            response.put("message", "Cuenta registrada exitosamente como Cliente.");
            return ResponseEntity.ok(response);
        } else {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String clienteJson = objectMapper.writeValueAsString(clientes);
                response.put("message", "Error al registrar la cuenta. Detalles: " + clienteJson);
            } catch (Exception e) {
                response.put("message", "Error al registrar la cuenta. Detalles: no se pudo convertir el objeto clientes.");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PutMapping("/modificarAjax/{codigo}")
    public ResponseEntity<Map<String, Object>> updateCliente(@PathVariable Long codigo, @RequestBody Cli cliente) {
        Map<String, Object> response = new HashMap<>();
        cliente.setId(codigo);

        String resp = servicioCliUsu.update(cliente);

        if (!resp.equals("")) {
            response.put("status", "error");
            response.put("message", resp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } else {
            response.put("status", "ok");
            response.put("message", "Cliente actualizado correctamente.");
            response.put("cliente", cliente);
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("/eliminarAjax/{id}")
    public ResponseEntity<Map<String, String>> eliminar(@PathVariable("id") long id) {
        Map<String, String> response = new HashMap<>();
        
        String resp = servicioCliUsu.delete(id);

        if (!resp.equals("")) {
            response.put("status", "error");
            response.put("message", resp);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        } else {
            response.put("status", "ok");
            response.put("message", "Cliente eliminado correctamente.");
            return ResponseEntity.ok(response);
        }
    }


    /*@GetMapping("/buscarCodigo/")
    public ResponseEntity<Cliente> buscarCliente(@RequestParam String correo, @RequestParam String password) {
        try {
            Cliente colaborador = servicioCliUsu.buscarPorCodigo(correo,password);
            return ResponseEntity.ok(colaborador);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }*/
    private boolean verifyCaptcha(String recaptchaResponse) {
        if (recaptchaResponse == null || recaptchaResponse.trim().isEmpty()) {
            System.out.println("reCAPTCHA no tiene respuesta.");
            return false;
        }
        String url = "https://www.google.com/recaptcha/api/siteverify";
        String secretKey = "X";
        Map<String, String> params = new HashMap<>();
        params.put("secret", secretKey);
        params.put("response", recaptchaResponse);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String, String>> entity = new HttpEntity<>(params);
        try {
            ResponseEntity<Map> googleResponse = restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);
            Map<String, Object> body = googleResponse.getBody();
            if (body == null) {
                System.out.println("Respuesta de Google reCAPTCHA es nula.");
                return false;
            }
            Boolean success = (Boolean) body.get("success");
            if (success == null) {
                System.out.println("El campo 'success' no está presente en la respuesta de Google.");
                return false;
            }
            if (success) {
                return true;
            } else {
                System.out.println("reCAPTCHA falló. Detalles: " + body);
                if (body.containsKey("error-codes")) {
                    List<String> errorCodes = (List<String>) body.get("error-codes");
                    System.out.println("Códigos de error: " + errorCodes);
                }
                return false;
            }

        } catch (Exception e) {
            System.out.println("Error al verificar el reCAPTCHA: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

}
