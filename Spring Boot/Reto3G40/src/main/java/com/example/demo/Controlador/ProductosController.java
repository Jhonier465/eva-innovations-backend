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
import com.example.demo.Servicio.ProductosService;


@RestController
@RequestMapping("/api/Productos")
public class ProductosController {

	@Autowired
	private ProductosService productosService;
	
	@CrossOrigin
	@GetMapping("/all")
	public List<Productos> getAll() {
		return productosService.getAll();
	}
	

	@CrossOrigin
	@GetMapping("/{id}")
	public Optional<Productos> getProductos(@PathVariable("id") int id) {
		return productosService.getProductos(id);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProductos(@PathVariable("id") int id) {
		productosService.deleteProductos(id);
	}
	
	@CrossOrigin
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Productos save(@RequestBody Productos productos) {
		return productosService.save(productos);
	}
	
	@CrossOrigin
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Productos modifyProductos(@RequestBody Productos productos, @PathVariable("id") int id) {
		return productosService.modifyProductos(id, productos);
	}

}
