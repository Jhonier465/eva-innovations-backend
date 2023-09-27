package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Planes;
import com.example.demo.Modelo.Productos;
import com.example.demo.Repositorio.PlanesRepository;
import com.example.demo.Repositorio.ProductosRepository;

@Service
public class PlanesService {
	
	@Autowired
	private PlanesRepository planesRepository;
	
	public List<Planes> getAll() {
		return planesRepository.getAll();
	}
	public Optional<Planes> getPlanes(int id) {
		return planesRepository.getPlanes(id);
	}
	public void deletePlanes(int id) {
		planesRepository.deletePlanes(id);
	}
	public Planes save(Planes planes) {
		if (planes.getIdPlanes() == null) {
			return planesRepository.save(planes);
		} else {
			Optional<Planes> planes1 = planesRepository.getPlanes(planes.getIdPlanes());
			if (planes1.isEmpty()) {
				return planesRepository.save(planes);
			} else {
				return planes;
			}
		}
	}
	public Planes modifyPlanes(int id, Planes planes) {
		return planesRepository.modifyPlanes(id, planes);
	}
}
