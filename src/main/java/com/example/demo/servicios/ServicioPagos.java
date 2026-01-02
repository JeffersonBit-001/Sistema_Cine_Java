/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.servicios;

import com.example.demo.dto.ClientePagoPeliculasDTO;
import com.example.demo.dto.PeliculaDTO;
import com.example.demo.dto.TB_PagosDetellasDTO;
import com.example.demo.dto.Tb_PagosDTO;
import com.example.demo.entidades.DetalleAsientos;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pelicula;
import com.example.demo.entidades.Tb_Pag_Bebidas;
import com.example.demo.entidades.Tb_Pag_Combos;
import com.example.demo.entidades.Tb_Pag_Dulceria;
import com.example.demo.entidades.Tb_Pag_Peliculas;
import com.example.demo.entidades.Tb_Pagos;
import com.example.demo.repositorio.AsientosDAO;
import com.example.demo.repositorio.ClienteDAO;
import com.example.demo.repositorio.PeliculaDAO;
import com.example.demo.repositorio.Tb_Pag_BebidasDAO;
import com.example.demo.repositorio.Tb_Pag_CombosDAO;
import com.example.demo.repositorio.Tb_Pag_DulceriaDAO;
import com.example.demo.repositorio.Tb_Pag_PeliculasDAO;
import com.example.demo.repositorio.Tb_PagosDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEFFERSON
 */
@Service
public class ServicioPagos {

    @Autowired
    private Tb_PagosDAO pagoDAO;
    @Autowired
    private ClienteDAO cliDAO;
    @Autowired
    private Tb_Pag_PeliculasDAO detpeliDAO;
    @Autowired
    private PeliculaDAO pelDao;
    @Autowired
    private Tb_Pag_CombosDAO detComb;
    @Autowired
    private Tb_Pag_BebidasDAO detBeb;
    @Autowired
    private Tb_Pag_DulceriaDAO detDul;
    @Autowired
    private AsientosDAO asientos;

    
    public List<DetalleAsientos> getListAsientos() {
        return asientos.findAll();
    }
    
    public List<Tb_Pagos> getList() {
        return pagoDAO.findAll();
    }

    public List<Tb_Pag_Peliculas> getListTb_Pagos() {
        return detpeliDAO.findAll();
    }

    public List<Pelicula> getListPelicula() {
        return pelDao.findAll();
    }

    public List<Cliente> getListCliente() {
        return cliDAO.findAll();
    }

    public List<Map<String, Object>> obtenerClientesConPagosYPeliculas() {
        
        List<Tb_Pag_Peliculas> pagos = detpeliDAO.findAll().stream()
                .filter(pago -> pago.getPago() != null && pago.getPelicula() != null)
                .collect(Collectors.toList());

        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Tb_Pag_Peliculas detalle : pagos) {
            Map<String, Object> resultado = new HashMap<>();

            resultado.put("pago", detalle.getPago());

            resultado.put("cliente", detalle.getPago().getCliente());

            resultado.put("pelicula", detalle.getPelicula());
            
            resultado.put("detalle_pago_pelicula", detalle.getPelicula().getDetallesPeliculas());

            resultados.add(resultado);
        }

        return resultados;
    }
    
    
    public List<Map<String, Object>> obtenerClientesConPagosYCombos() {
        
        List<Tb_Pag_Combos> pagos = detComb.findAll().stream()
                .filter(pago -> pago.getPago() != null && pago.getCombos() != null)
                .collect(Collectors.toList());

        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Tb_Pag_Combos detalle : pagos) {
            Map<String, Object> resultado = new HashMap<>();

            resultado.put("pago", detalle.getPago());

            resultado.put("cliente", detalle.getPago().getCliente());

            resultado.put("combos", detalle.getCombos());
            
            resultado.put("detalle_pago_combos", detalle.getCombos().getDetalles_combos());

            resultados.add(resultado);
        }

        return resultados;
    }
    
    
    public List<Map<String, Object>> obtenerClientesConPagosYBebidas() {
        
        List<Tb_Pag_Bebidas> pagos = detBeb.findAll().stream()
                .filter(pago -> pago.getPago() != null && pago.getBebidas()!= null)
                .collect(Collectors.toList());

        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Tb_Pag_Bebidas detalle : pagos) {
            Map<String, Object> resultado = new HashMap<>();

            resultado.put("pago", detalle.getPago());

            resultado.put("cliente", detalle.getPago().getCliente());

            resultado.put("bebidas", detalle.getBebidas());
            
            resultado.put("detalle_pago_bebidas", detalle.getBebidas().getDetalles_Bebidas());

            resultados.add(resultado);
        }

        return resultados;
    }
    
    
    public List<Map<String, Object>> obtenerClientesConPagosYDulceria() {
        
        List<Tb_Pag_Dulceria> pagos = detDul.findAll().stream()
                .filter(pago -> pago.getPago() != null && pago.getDulceria() != null)
                .collect(Collectors.toList());

        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Tb_Pag_Dulceria detalle : pagos) {
            Map<String, Object> resultado = new HashMap<>();

            resultado.put("pago", detalle.getPago());

            resultado.put("cliente", detalle.getPago().getCliente());

            resultado.put("dulceria", detalle.getDulceria());
            
            resultado.put("detalle_pago_dulceria", detalle.getDulceria().getDetalles_dulceria());

            resultados.add(resultado);
        }

        return resultados;
    }
    
    
    

}
