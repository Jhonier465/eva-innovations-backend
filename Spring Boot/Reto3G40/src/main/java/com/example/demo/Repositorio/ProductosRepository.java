package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Interface.ProductosInterface;
import com.example.demo.Interface.ServiciosInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;

@Repository
public class ProductosRepository {
	
	@Autowired
	private ProductosInterface extencionesCrud;
	public List<Productos> getAll() {
		return (List<Productos>) extencionesCrud.findAll();
	}
	
	public Optional<Productos> getProductos(int id) {
		return extencionesCrud.findById(id);
	}
	public Productos save(Productos productos) {
		return extencionesCrud.save(productos);
	}

	public void deleteProductos(int id) {
		extencionesCrud.deleteById(id);
	}
	public Productos modifyProductos(int id, Productos productos) {
		return extencionesCrud.findById(id).map(productos1 -> {
			productos1.setNombreProducto(productos.getNombreProducto());
			productos1.setDescripcionProducto(productos.getDescripcionProducto());
			productos1.setCategoriaProducto(productos.getCategoriaProducto());
			productos1.setPreciosProducto(productos.getPreciosProducto());
			productos1.setFotoProducto(productos.getFotoProducto());
			
			return extencionesCrud.save(productos1);
		}).orElseGet(() -> {
			productos.setIdProducto(id);
			return extencionesCrud.save(productos);
		});
	}
}
