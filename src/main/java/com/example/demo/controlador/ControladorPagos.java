/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controlador;

import com.example.demo.dto.ClientePagoPeliculasDTO;
import com.example.demo.dto.TB_PagosDetellasDTO;
import com.example.demo.dto.Tb_PagosDTO;
import com.example.demo.entidades.DetalleAsientos;
import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Pelicula;
import com.example.demo.entidades.Tb_Pag_Peliculas;
import com.example.demo.entidades.Tb_Pagos;
import com.example.demo.repositorio.Tb_Pag_PeliculasDAO;
import com.example.demo.servicios.ServicioPagos;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JEFFERSON
 */
@RestController
@RequestMapping("/cliPagos")
public class ControladorPagos {

    @Autowired
    private ServicioPagos servicioPago;

    @GetMapping("/listarJSON")
    @ResponseBody
    public List<Tb_PagosDTO> listarJSON() {
        List<Tb_Pagos> pagos = servicioPago.getList();
        return pagos.stream()
                .map(pago -> new Tb_PagosDTO(pago))
                .collect(Collectors.toList());
    }

    @GetMapping("/listarClientesPagosPeliculas")
    @ResponseBody
    public List<Tb_Pag_Peliculas> listarClientes() {
        return servicioPago.getListTb_Pagos();
    }
    
    
    @GetMapping("/listarJSON2")
    @ResponseBody
    public List<Tb_Pagos> listarClientes2() {
        return servicioPago.getList();
    }
    
    
    @GetMapping("/listarJSONPelicula")
    @ResponseBody
    public List<Pelicula> listarPelicula() {
        return servicioPago.getListPelicula();
    }
    
    @GetMapping("/listarCliente")
    @ResponseBody
    public List<Cliente> listarCliente() {
        return servicioPago.getListCliente();
    }

   @GetMapping("/listarPagosDetallePelicula")
    @ResponseBody
    public List<Map<String, Object>> listarClientesPagosPeliculas() {
        return servicioPago.obtenerClientesConPagosYPeliculas();
    }
    
    @GetMapping("/listarPagosDetalleCombos")
    @ResponseBody
    public List<Map<String, Object>> listarClientesPagosCombos() {
        return servicioPago.obtenerClientesConPagosYCombos();
    }
    
    @GetMapping("/listarPagosDetallBebidas")
    @ResponseBody
    public List<Map<String, Object>> listarClientesPagosBebidas() {
        return servicioPago.obtenerClientesConPagosYBebidas();
    }
    
    @GetMapping("/listarPagosDetalleDulceria")
    @ResponseBody
    public List<Map<String, Object>> listarClientesPagosDulceria() {
        return servicioPago.obtenerClientesConPagosYDulceria();
    }
    
    
    @GetMapping("/listarJSONAsiento")
    @ResponseBody
    public List<DetalleAsientos> listarJSONAsiento() {
        return servicioPago.getListAsientos();
    }

}
