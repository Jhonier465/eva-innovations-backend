package com.example.demo.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;
import com.example.demo.Modelo.Usuarios;
import com.example.demo.Servicio.UsuariosService;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Usuarios> getAll() {
		return usuariosService.getAll();
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Usuarios> getUsuarios(@PathVariable("id") int id) {
		return usuariosService.getUsuarios(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteUsuarios(@PathVariable("id") int id) {
		usuariosService.deleteUsuarios(id);
	}
	@CrossOrigin
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuarios save(@RequestBody Usuarios usuarios) {
		return usuariosService.save(usuarios);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Usuarios modifyUsuarios(@RequestBody Usuarios usuarios, @PathVariable("id") int id) {
		return usuariosService.modifyUsuarios(id, usuarios);
	}
	
}
