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
@Table(name = "usuarios")
public class Usuarios {
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer idUsuarios;
	    private String nombreUsuarios;
	    private String apellidosUsuarios;
	    private Integer edadUsuarios;
	    private String paisUsuario;
	    private String emailUsuario;
	    private String telefonoUsuario;
	    private String departamentoUsuario;
	    private String ciudadUsuario;
	    
	    @ManyToMany
	    private Set<Planes> planes= new HashSet<>();
	    
		public Usuarios() {
		}

		public Usuarios(Integer idUsuarios, String nombreUsuarios, String apellidosUsuarios, Integer edadUsuarios,
				String paisUsuario, String emailUsuario, String telefonoUsuario, String departamentoUsuario,
				String ciudadUsuario) {
			super();
			this.idUsuarios = idUsuarios;
			this.nombreUsuarios = nombreUsuarios;
			this.apellidosUsuarios = apellidosUsuarios;
			this.edadUsuarios = edadUsuarios;
			this.paisUsuario = paisUsuario;
			this.emailUsuario = emailUsuario;
			this.telefonoUsuario = telefonoUsuario;
			this.departamentoUsuario = departamentoUsuario;
			this.ciudadUsuario = ciudadUsuario;
		}

		public Integer getIdUsuarios() {
			return idUsuarios;
		}

		public void setIdUsuarios(Integer idUsuarios) {
			this.idUsuarios = idUsuarios;
		}

		public String getNombreUsuarios() {
			return nombreUsuarios;
		}

		public void setNombreUsuarios(String nombreUsuarios) {
			this.nombreUsuarios = nombreUsuarios;
		}

		public String getApellidosUsuarios() {
			return apellidosUsuarios;
		}

		public void setApellidosUsuarios(String apellidosUsuarios) {
			this.apellidosUsuarios = apellidosUsuarios;
		}

		public Integer getEdadUsuarios() {
			return edadUsuarios;
		}

		public void setEdadUsuarios(Integer edadUsuarios) {
			this.edadUsuarios = edadUsuarios;
		}

		public String getPaisUsuario() {
			return paisUsuario;
		}

		public void setPaisUsuario(String paisUsuario) {
			this.paisUsuario = paisUsuario;
		}

		public String getEmailUsuario() {
			return emailUsuario;
		}

		public void setEmailUsuario(String emailUsuario) {
			this.emailUsuario = emailUsuario;
		}

		public String getTelefonoUsuario() {
			return telefonoUsuario;
		}

		public void setTelefonoUsuario(String telefonoUsuario) {
			this.telefonoUsuario = telefonoUsuario;
		}

		public String getDepartamentoUsuario() {
			return departamentoUsuario;
		}

		public void setDepartamentoUsuario(String departamentoUsuario) {
			this.departamentoUsuario = departamentoUsuario;
		}

		public String getCiudadUsuario() {
			return ciudadUsuario;
		}

		public void setCiudadUsuario(String ciudadUsuario) {
			this.ciudadUsuario = ciudadUsuario;
		}

		public Set<Planes> getPlanes() {
			return planes;
		}

		public void setPlanes(Set<Planes> planes) {
			this.planes = planes;
		}	    
	    
}
