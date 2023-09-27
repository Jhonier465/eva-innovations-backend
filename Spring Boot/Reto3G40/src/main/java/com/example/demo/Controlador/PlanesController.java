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

import com.example.demo.Modelo.Planes;
import com.example.demo.Modelo.Productos;
import com.example.demo.Servicio.PlanesService;
import com.example.demo.Servicio.ProductosService;

@RestController
@RequestMapping("/api/Planes")
public class PlanesController {
	@Autowired
	private PlanesService planesService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Planes> getAll() {
		return planesService.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Planes> getPlanes(@PathVariable("id") int id) {
		return planesService.getPlanes(id);
	}
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletePlanes(@PathVariable("id") int id) {
		planesService.deletePlanes(id);
	}
	@CrossOrigin
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Planes save(@RequestBody Planes planes) {
		return planesService.save(planes);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Planes modifyPlanes(@RequestBody Planes planes, @PathVariable("id") int id) {
		return planesService.modifyPlanes(id, planes);
	}
}
