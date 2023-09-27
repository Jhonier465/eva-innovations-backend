package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Planes;
import com.example.demo.Modelo.Usuarios;
import com.example.demo.Repositorio.UsuariosRepository;

@Service
public class UsuariosService {
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	public List<Usuarios> getAll() {
		return usuariosRepository.getAll();
	}
	public Optional<Usuarios> getUsuarios(int id) {
		return usuariosRepository.getUsuarios(id);
	}
	public void deleteUsuarios(int id) {
		usuariosRepository.deleteUsuarios(id);
	}
	public Usuarios save(Usuarios usuarios) {
		if (usuarios.getIdUsuarios() == null) {
			return usuariosRepository.save(usuarios);
		} else {
			Optional<Usuarios> usuarios1 = usuariosRepository.getUsuarios(usuarios.getIdUsuarios());
			if (usuarios1.isEmpty()) {
				return usuariosRepository.save(usuarios);
			} else {
				return usuarios;
			}
		}
	}
	public Usuarios modifyUsuarios(int id, Usuarios usuarios) {
		return usuariosRepository.modifyUsuarios(id, usuarios);
	}
}
