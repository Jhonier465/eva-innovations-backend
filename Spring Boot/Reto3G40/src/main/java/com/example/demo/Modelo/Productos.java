package com.example.demo.Modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idProducto;
	    private String nombreProducto;
	    private String descripcionProducto;
	    private String categoriaProducto;
	    private double preciosProducto;
	    private String fotoProducto;
	    
	    @ManyToMany(mappedBy = "productos")
	    private Set<Servicios> servicios= new HashSet<>();
	    
		public Productos() {
			
		}
		
		public Productos(Integer idProducto, String nombreProducto, String descripcionProducto,
				String categoriaProducto, double preciosProducto, String fotoProducto) {
			
			this.idProducto = idProducto;
			this.nombreProducto = nombreProducto;
			this.descripcionProducto = descripcionProducto;
			this.categoriaProducto = categoriaProducto;
			this.preciosProducto = preciosProducto;
			this.fotoProducto = fotoProducto;
		}
		public Integer getIdProducto() {
			return idProducto;
		}
		public void setIdProducto(Integer idProducto) {
			this.idProducto = idProducto;
		}
		public String getNombreProducto() {
			return nombreProducto;
		}
		public void setNombreProducto(String nombreProducto) {
			this.nombreProducto = nombreProducto;
		}
		public String getDescripcionProducto() {
			return descripcionProducto;
		}
		public void setDescripcionProducto(String descripcionProducto) {
			this.descripcionProducto = descripcionProducto;
		}
		public String getCategoriaProducto() {
			return categoriaProducto;
		}
		public void setCategoriaProducto(String categoriaProducto) {
			this.categoriaProducto = categoriaProducto;
		}
		public double getPreciosProducto() {
			return preciosProducto;
		}
		public void setPreciosProducto(double preciosProducto) {
			this.preciosProducto = preciosProducto;
		}
		public String getFotoProducto() {
			return fotoProducto;
		}
		public void setFotoProducto(String fotoProducto) {
			this.fotoProducto = fotoProducto;
		}

		public Set<Servicios> getServicios() {
			return servicios;
		}

		public void setServicios(Set<Servicios> servicios) {
			this.servicios = servicios;
		}
	    
}
