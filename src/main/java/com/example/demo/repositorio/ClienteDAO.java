/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositorio;

import com.example.demo.entidades.Cliente;
import com.example.demo.entidades.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author JEFFERSON
 */
public interface ClienteDAO extends JpaRepository<Cliente, Long>{
    Cliente findByCorreo(String correo);
}
