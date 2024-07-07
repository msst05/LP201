package com.cibertec.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class tipoConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoConsulta;
    private String descripcion;
}