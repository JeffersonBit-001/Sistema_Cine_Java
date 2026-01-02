/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.servicios;

import com.example.demo.entidades.Asiento;
import com.example.demo.entidades.CategoriaAsiento;
import com.example.demo.entidades.DetalleAsientos;
import com.example.demo.entidades.EstadoAsiento;
import com.example.demo.repositorio.AsientoDAO;
import com.example.demo.repositorio.AsientosDAO;
import com.example.demo.repositorio.CategoriaAsientoDAO;
import com.example.demo.repositorio.EstadoAsientoDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEFFERSON
 */
@Service
public class ServicioAsientos {
    @Autowired
    private AsientoDAO asientos;
    @Autowired
    private EstadoAsientoDAO estado;
    @Autowired
    private CategoriaAsientoDAO categoria;
    @Autowired
    private AsientosDAO asiento2;
    
    public List<Asiento> getListAsientos() {
        return asientos.findAll();
    }
    
    public List<EstadoAsiento> getListEstados() {
        return estado.findAll();
    }
    
    public List<CategoriaAsiento> getListCategoria() {
        return categoria.findAll();
    }
    
    public DetalleAsientos buscarPorCodigo(Long codigo) {
        return asiento2.findById(codigo)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
    }
    
    public String update(DetalleAsientos c) {
        String resp = "";

        if (c == null || c.getId()== null) {
            return "El Asiento y su ID no pueden ser nulos.";
        }

        try {

            if (!asiento2.existsById(c.getId())) {
                resp = "Asiento no encontrado para modificar.";
            } else {

                DetalleAsientos existente = asiento2.findById(c.getId()).get();

                existente.setId_asiento(c.getId_asiento());
                existente.setId_categoria(c.getId_categoria());
                existente.setId_estado(c.getId_estado());
                existente.setId_hora(c.getId_hora());
                existente.setId_pelicula(c.getId_pelicula());
                existente.setId_sede(c.getId_sede());
                asiento2.save(existente);
                resp = "Asiento modificado con éxito.";
            }
        } catch (Exception e) {
            resp = "Ocurrió un error al modificar el ASIENTO: " + e.getMessage();
        }

        return resp;
    }
    
    
    public String save(DetalleAsientos c) {
        String resp = "";

        try {
            DetalleAsientos asiento = asiento2.save(c);
            if (asiento == null) {
                resp = "Error al regitrar";
            }
        } catch (Exception e) {
            resp = e.getMessage();
        }

        return resp;
    }
    
}
