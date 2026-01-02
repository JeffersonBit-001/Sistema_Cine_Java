/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controlador;

import com.example.demo.entidades.Asiento;
import com.example.demo.entidades.CategoriaAsiento;
import com.example.demo.entidades.DetalleAsientos;
import com.example.demo.entidades.EstadoAsiento;
import com.example.demo.servicios.ServicioAsientos;
import com.example.demo.servicios.ServicioCliUsu;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author JEFFERSON
 */
@RestController
@RequestMapping("/asientosServer")
public class ControladorAsientos {
    
    @Autowired
    private ServicioAsientos servicioCliUsu;
    
    @GetMapping("/listarJSONAsiento")
    @ResponseBody
    public List<Asiento> listarJSONAsiento() {
        return servicioCliUsu.getListAsientos();
    }
    
    @GetMapping("/listarJSONAestado")
    @ResponseBody
    public List<EstadoAsiento> listarJSONAestado() {
        return servicioCliUsu.getListEstados();
    }
    
    @GetMapping("/listarJSONcategoria")
    @ResponseBody
    public List<CategoriaAsiento> listarJSONcategoria() {
        return servicioCliUsu.getListCategoria();
    }
    
    @GetMapping("/buscarCodigo/{codigo}")
    public ResponseEntity<DetalleAsientos> buscarAsiento(@PathVariable long codigo) {
        try {
            
            DetalleAsientos as = servicioCliUsu.buscarPorCodigo(codigo);
            return ResponseEntity.ok(as);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
    @PutMapping("/modificarAjax/{codigo}")
    public ResponseEntity<?> updateAsiento(@PathVariable Long codigo, @RequestBody DetalleAsientos detalle) {
        JSONObject response = new JSONObject();
        detalle.setId(codigo);
        
        String resp = servicioCliUsu.update(detalle);
        if (!resp.equals("")) {
            response.put("status", "error");
            response.put("message", resp);
            return ResponseEntity.ok(response.toString());
        } else {
            response.put("status", "ok");
            response.put("message", "Asiento eliminado correctamente");
            return ResponseEntity.ok(response.toString());

        }
    }
    @PostMapping("/grabarJSON")
    public ResponseEntity<?> grabarJSON(@RequestBody @Validated DetalleAsientos asiento, BindingResult result) {
        JSONObject response = new JSONObject();

        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage).collect(
                    Collectors.toList());

            response.put("status", "error");
            response.put("message", errors);
            return ResponseEntity.badRequest().body(response.toString());
        }

        String resp = servicioCliUsu.save(asiento);

        if (!resp.equals("")) {
            response.put("status", "error");
            response.put("message", resp);
            return ResponseEntity.ok(response.toString());

        } else {
            response.put("status", "ok");
            response.put("message", "Asiento Guardado");
            return ResponseEntity.ok(response.toString());
        }

    }

    
    
}
