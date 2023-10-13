package com.example.demo.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Clientes {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idClientes;
	    private String nombresClientes;
	    private String apellidosClientes;
	    private Integer edadClientes;
	    private String paisClientes;
	    private String emailClientes;
	    private String telefonoClientes;
	    private String departamentoClientes;
	    private String ciudadClientes;
	    private String direccionClientes;
	    
		public Clientes() {
			
		}

		public Clientes(Integer idClientes, String nombresClientes, String apellidosClientes, Integer edadClientes,
				String paisClientes, String emailClientes, String telefonoClientes, String departamentoClientes,
				String ciudadClientes, String direccionClientes) {
			super();
			this.idClientes = idClientes;
			this.nombresClientes = nombresClientes;
			this.apellidosClientes = apellidosClientes;
			this.edadClientes = edadClientes;
			this.paisClientes = paisClientes;
			this.emailClientes = emailClientes;
			this.telefonoClientes = telefonoClientes;
			this.departamentoClientes = departamentoClientes;
			this.ciudadClientes = ciudadClientes;
			this.direccionClientes = direccionClientes;
		}

		public Integer getIdClientes() {
			return idClientes;
		}

		public void setIdClientes(Integer idClientes) {
			this.idClientes = idClientes;
		}

		public String getNombresClientes() {
			return nombresClientes;
		}

		public void setNombresClientes(String nombresClientes) {
			this.nombresClientes = nombresClientes;
		}

		public String getApellidosClientes() {
			return apellidosClientes;
		}

		public void setApellidosClientes(String apellidosClientes) {
			this.apellidosClientes = apellidosClientes;
		}

		public Integer getEdadClientes() {
			return edadClientes;
		}

		public void setEdadClientes(Integer edadClientes) {
			this.edadClientes = edadClientes;
		}

		public String getPaisClientes() {
			return paisClientes;
		}

		public void setPaisClientes(String paisClientes) {
			this.paisClientes = paisClientes;
		}

		public String getEmailClientes() {
			return emailClientes;
		}

		public void setEmailClientes(String emailClientes) {
			this.emailClientes = emailClientes;
		}

		public String getTelefonoClientes() {
			return telefonoClientes;
		}

		public void setTelefonoClientes(String telefonoClientes) {
			this.telefonoClientes = telefonoClientes;
		}

		public String getDepartamentoClientes() {
			return departamentoClientes;
		}

		public void setDepartamentoClientes(String departamentoClientes) {
			this.departamentoClientes = departamentoClientes;
		}

		public String getCiudadClientes() {
			return ciudadClientes;
		}

		public void setCiudadClientes(String ciudadClientes) {
			this.ciudadClientes = ciudadClientes;
		}

		public String getDireccionClientes() {
			return direccionClientes;
		}

		public void setDireccionClientes(String direccionClientes) {
			this.direccionClientes = direccionClientes;
		}
	    
	    
}
