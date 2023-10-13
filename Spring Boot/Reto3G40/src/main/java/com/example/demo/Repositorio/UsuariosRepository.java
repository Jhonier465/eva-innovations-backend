package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.Interface.UsuariosInterface;
import com.example.demo.Modelo.Servicios;
import com.example.demo.Modelo.Usuarios;

@Repository
public class UsuariosRepository {
	
	@Autowired
	private UsuariosInterface extencionesCrud;
	public List<Usuarios> getAll() {
		return (List<Usuarios>) extencionesCrud.findAll();
	}
	public Optional<Usuarios> getUsuarios(int id) {
		return extencionesCrud.findById(id);
	}
	public void deleteUsuarios(int id) {
		extencionesCrud.deleteById(id);
	}
	public Usuarios save(Usuarios usuarios) {
		return extencionesCrud.save(usuarios);
	}
	public Usuarios modifyUsuarios(int id, Usuarios usuarios) {
		return extencionesCrud.findById(id).map(usuarios1 -> {
			usuarios1.setNombreUsuarios(usuarios.getNombreUsuarios());
			usuarios1.setApellidosUsuarios(usuarios.getApellidosUsuarios());
			usuarios1.setEdadUsuarios(usuarios.getEdadUsuarios());
			usuarios1.setPaisUsuario(usuarios.getPaisUsuario());
			usuarios1.setEmailUsuario(usuarios.getEmailUsuario());
			usuarios1.setTelefonoUsuario(usuarios.getTelefonoUsuario());
			usuarios1.setDepartamentoUsuario(usuarios.getDepartamentoUsuario());
			usuarios1.setCiudadUsuario(usuarios.getCiudadUsuario());
						
			return extencionesCrud.save(usuarios1);
		}).orElseGet(() -> {
			usuarios.setIdUsuarios(id);
			return extencionesCrud.save(usuarios);
		});
	}
}
