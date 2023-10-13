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
import com.example.demo.Modelo.Servicios;
import com.example.demo.Servicio.ServiciosService;

@RestController
@RequestMapping("/api/Servicios")
public class ServiciosController {
	
	@Autowired
	private ServiciosService serviciosService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Servicios> getAll() {
		return serviciosService.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Servicios> getServicios(@PathVariable("id") int id) {
		return serviciosService.getServicios(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteServicios(@PathVariable("id") int id) {
		serviciosService.deleteServicios(id);
	}
	
	@CrossOrigin
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Servicios save(@RequestBody Servicios servicios) {
		return serviciosService.save(servicios);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Servicios modifyServicios(@RequestBody Servicios servicios, @PathVariable("id") int id) {
		return serviciosService.modifyServicios(id, servicios);
	}
	
}
