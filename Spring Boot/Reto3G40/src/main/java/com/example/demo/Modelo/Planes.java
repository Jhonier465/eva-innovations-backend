package com.example.demo.Modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Planes {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idPlanes;
	    private String descripcionPlanes;
	    private String categoriaPlanes;
	    private double costosPlanes;
	    
	    @ManyToMany(mappedBy = "planes")
	    private Set<Usuarios> usuarios = new HashSet<>();
	    
		public Planes() {
			
		}
		
		public Planes(Integer idPlanes, String descripcionPlanes, String categoriaPlanes, double costosPlanes) {
			super();
			this.idPlanes = idPlanes;
			this.descripcionPlanes = descripcionPlanes;
			this.categoriaPlanes = categoriaPlanes;
			this.costosPlanes = costosPlanes;
		}



		public Integer getIdPlanes() {
			return idPlanes;
		}

		public void setIdPlanes(Integer idPlanes) {
			this.idPlanes = idPlanes;
		}

		public String getDescripcionPlanes() {
			return descripcionPlanes;
		}

		public void setDescripcionPlanes(String descripcionPlanes) {
			this.descripcionPlanes = descripcionPlanes;
		}

		public String getCategoriaPlanes() {
			return categoriaPlanes;
		}

		public void setCategoriaPlanes(String categoriaPlanes) {
			this.categoriaPlanes = categoriaPlanes;
		}

		public double getCostosPlanes() {
			return costosPlanes;
		}

		public void setCostosPlanes(double costosPlanes) {
			this.costosPlanes = costosPlanes;
		}

		public Set<Usuarios> getUsuarios() {
			return usuarios;
		}
		
		public void setUsuarios(Set<Usuarios> usuarios) {
			this.usuarios = usuarios;
		}	
			    
}
