/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositorio;

import com.example.demo.entidades.CategoriaAsiento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JEFFERSON
 */
public interface CategoriaAsientoDAO  extends JpaRepository<CategoriaAsiento, Long>{
    
}
