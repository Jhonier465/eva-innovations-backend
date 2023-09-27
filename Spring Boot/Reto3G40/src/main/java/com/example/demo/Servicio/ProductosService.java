package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;
import com.example.demo.Repositorio.ProductosRepository;


@Service
public class ProductosService {
	
	@Autowired
	private ProductosRepository productosRepository;
	
	public List<Productos> getAll() {
		return productosRepository.getAll();
	}

	public Optional<Productos> getProductos(int id) {
		return productosRepository.getProductos(id);
	}
	
	public void deleteProductos(int id) {
		productosRepository.deleteProductos(id);
	}
	
	public Productos save(Productos productos) {
		if (productos.getIdProducto() == null) {
			return productosRepository.save(productos);
		} else {
			Optional<Productos> productos1 = productosRepository.getProductos(productos.getIdProducto());
			if (productos1.isEmpty()) {
				return productosRepository.save(productos);
			} else {
				return productos;
			}
		}
	}
	public Productos modifyProductos(int id, Productos productos) {
		return productosRepository.modifyProductos(id, productos);
	}
}
