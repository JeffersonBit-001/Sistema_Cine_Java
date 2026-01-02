/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositorio;
import com.example.demo.entidades.Tb_Pag_Bebidas;
import com.example.demo.entidades.Tb_Pag_Combos;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JEFFERSON
 */
public interface Tb_Pag_BebidasDAO  extends JpaRepository<Tb_Pag_Bebidas, Long>{
    
}
