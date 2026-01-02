/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repositorio;
import com.example.demo.entidades.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author JEFFERSON
 */
public interface UsuariosDAO extends JpaRepository<Usuarios, Long>{
    Usuarios findByCorreo(String correo);
}
