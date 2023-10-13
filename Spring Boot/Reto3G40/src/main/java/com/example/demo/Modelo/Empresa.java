package com.example.demo.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;
    private String nombreEmpresa;
    private String descripcionEmpresa;
    private String direccionEmpresa;
    private String logoEmpresa;
    private String contenidoEmpresa;
    private String contactoEmpresa;
    private String nitEmpresa;
    
    

}
