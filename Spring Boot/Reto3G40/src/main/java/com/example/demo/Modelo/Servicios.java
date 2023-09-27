package com.example.demo.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "servicios")


public class Servicios {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idServicios;
	    private String descripcionServicios;
	    private String listaSevicios;
	    private String nombreServicios;
	    private String fotoServicios;
	    
	    @ManyToMany
	    private Set<Productos> productos = new HashSet<>();
	    
		public Servicios() {
			
		}
		
		
		public Servicios(Integer idServicios, String descripcionServicios, String listaSevicios, String nombreServicios,
				String fotoServicios) {
		
			this.idServicios = idServicios;
			this.descripcionServicios = descripcionServicios;
			this.listaSevicios = listaSevicios;
			this.nombreServicios = nombreServicios;
			this.fotoServicios = fotoServicios;
		}


		public Integer getIdServicios() {
			return idServicios;
		}
		public void setIdServicios(Integer idServicios) {
			this.idServicios = idServicios;
		}
		public String getDescripcionServicios() {
			return descripcionServicios;
		}
		public void setDescripcionServicios(String descripcionServicios) {
			this.descripcionServicios = descripcionServicios;
		}
		public String getListaSevicios() {
			return listaSevicios;
		}
		public void setListaSevicios(String listaSevicios) {
			this.listaSevicios = listaSevicios;
		}
		public String getNombreServicios() {
			return nombreServicios;
		}
		public void setNombreServicios(String nombreServicios) {
			this.nombreServicios = nombreServicios;
		}
		public String getFotoServicios() {
			return fotoServicios;
		}
		public void setFotoServicios(String fotoServicios) {
			this.fotoServicios = fotoServicios;
		}


		public Set<Productos> getProductos() {
			return productos;
		}


		public void setProductos(Set<Productos> productos) {
			this.productos = productos;
		}


		    
	    
}
