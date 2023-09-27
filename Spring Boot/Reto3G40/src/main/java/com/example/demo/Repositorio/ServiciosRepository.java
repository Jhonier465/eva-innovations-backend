package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Interface.ServiciosInterface;
import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;

@Repository
public class ServiciosRepository {

	@Autowired
	private ServiciosInterface extencionesCrud;
	public List<Servicios> getAll() {
		return (List<Servicios>) extencionesCrud.findAll();
	}
	
	public Optional<Servicios> getServicios(int id) {
		return extencionesCrud.findById(id);
	}
	public Servicios save(Servicios servicio) {
		return extencionesCrud.save(servicio);
	}

	public void deleteServicio(int id) {
		extencionesCrud.deleteById(id);
	}
	public Servicios modifyServicios(int id, Servicios servicios) {
		return extencionesCrud.findById(id).map(servicios1 -> {
			servicios1.setNombreServicios(servicios.getNombreServicios());
			servicios1.setDescripcionServicios(servicios.getDescripcionServicios());
			servicios1.setListaSevicios(servicios.getListaSevicios());
			servicios1.setFotoServicios(servicios.getListaSevicios());
						
			return extencionesCrud.save(servicios1);
		}).orElseGet(() -> {
			servicios.setIdServicios(id);
			return extencionesCrud.save(servicios);
		});
	}

}
