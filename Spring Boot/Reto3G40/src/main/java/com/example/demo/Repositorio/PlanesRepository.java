package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.Interface.PlanesInterface;
import com.example.demo.Modelo.Planes;
import com.example.demo.Modelo.Servicios;


@Repository
public class PlanesRepository {
	
	@Autowired
	private PlanesInterface extencionesCrud;
	public List<Planes> getAll() {
		return (List<Planes>) extencionesCrud.findAll();
	}
	public Optional<Planes> getPlanes(int id) {
		return extencionesCrud.findById(id);
	}
	public void deletePlanes(int id) {
		extencionesCrud.deleteById(id);
	}
	public Planes save(Planes planes) {
		return extencionesCrud.save(planes);
	}
	public Planes modifyPlanes(int id, Planes planes) {
		return extencionesCrud.findById(id).map(planes1 -> {
			planes1.setDescripcionPlanes(planes.getDescripcionPlanes());
			planes1.setCategoriaPlanes(planes.getCategoriaPlanes());
			planes1.setCostosPlanes(planes.getCostosPlanes());
			
						
			return extencionesCrud.save(planes1);
		}).orElseGet(() -> {
			planes.setIdPlanes(id);
			return extencionesCrud.save(planes);
		});
	}

}
