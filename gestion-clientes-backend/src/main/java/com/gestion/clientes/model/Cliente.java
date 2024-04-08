package com.gestion.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //indica que es una entidad
@Table(name = "clientes")


public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    
     @Column(name = "nombre")
     private String nombre;
     
     @Column(name = "apellido")
     private String apellido;
     
     @Column(name = "email")
     private String email;
}

//propiedades del cliente