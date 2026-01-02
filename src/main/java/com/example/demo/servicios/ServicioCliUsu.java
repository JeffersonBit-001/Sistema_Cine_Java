/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.servicios;

import com.example.demo.entidades.Cli;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Login;
import com.example.demo.entidades.Usuarios;
import com.example.demo.repositorio.CliDAO;
import com.example.demo.repositorio.ClienteDAO;
import com.example.demo.repositorio.UsuariosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositorio.LoginDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author JEFFERSON
 */
@Service
public class ServicioCliUsu {
    @Autowired
    private LoginDAO clienteRepository;
    @Autowired
    private UsuariosDAO administradorRepository;
    @Autowired
    private ClienteDAO cliRepository;
    @Autowired
    private CliDAO cliRepository2;

    public Map<String, Object> verificarCredenciales(String correo, String password) {
        Map<String, Object> response = new HashMap<>();

        Cli cliente = cliRepository2.findByCorreo(correo);
        if (cliente != null && correo.equals(cliente.getCorreo()) && password.equals(cliente.getPass())) {
            response.put("message", "Cliente");
            response.put("user", cliente);
            return response;
        }
        Usuarios administrador = administradorRepository.findByCorreo(correo);
        if (administrador != null && correo.equals(administrador.getCorreo()) && password.equals(administrador.getPass())) {
            response.put("message", "Administrador");
            response.put("user", administrador);
            return response;
        }

        response.put("message", "Credenciales incorrectas");
        return response;
    }

    public boolean existeCorreo(String correo) {
        return clienteRepository.findByCorreo(correo) != null || administradorRepository.findByCorreo(correo) != null;
    }

    public String registrarNuevoUsuario(Cli cl) {
        String resp = "";

        try {
            Cli cli = cliRepository2.save(cl);
            if (cli == null) {
                resp = "Error al regitrar";
            }
        } catch (Exception e) {
            resp = e.getMessage();
        }

        return resp;

    }

    public Cli buscarPorCodigo(Long id) {
        return cliRepository2.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
    
    
    public String update(Cli c) {
        String resp = "";
        if (c == null || c.getId()== null) {
            return "El Cliente y su ID no pueden ser nulos.";
        }
        try {
            if (!cliRepository2.existsById(c.getId())) {
                resp = "Cliente no encontrado para modificar.";
            } else {
                Cli cliExistente = cliRepository2.findById(c.getId()).get();
                cliExistente.setNombres(c.getNombres());
                cliExistente.setApellidos(c.getApellidos());
                cliExistente.setDni(c.getDni());
                cliExistente.setGenero(c.getGenero());
                cliExistente.setNacimiento(c.getNacimiento());
                cliExistente.setDomicilio(c.getDomicilio());
                cliExistente.setCorreo(c.getCorreo());
                cliExistente.setCorreo_confirm(c.getCorreo_confirm());
                cliExistente.setPass(c.getPass());
                cliExistente.setPass_confirm(c.getPass_confirm());
                cliExistente.setCel(c.getCel());
                cliRepository2.save(cliExistente);
                resp = "";
            }
        } catch (Exception e) {
            resp = "Ocurrió un error al modificar el Cliente: " + e.getMessage();
        }
        return resp;
    }
    
    
    public String delete(long id) {
        String resp = "";
        try {
            Optional<Cli> colaboradorOptional = cliRepository2.findById(id);
            if (colaboradorOptional.isPresent()) {
                cliRepository2.deleteById(id);
                resp = "";
            } else {
                resp = "El CLIENTE con ID " + id + " no existe";
            }
        } catch (Exception e) {
            resp = "Error al eliminar el Cliente: " + e.getMessage();
        }

        return resp;
    }
    
    
    
}
