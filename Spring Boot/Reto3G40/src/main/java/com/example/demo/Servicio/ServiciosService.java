package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Client;
import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;
import com.example.demo.Repositorio.ClientRepository;
import com.example.demo.Repositorio.ServiciosRepository;

@Service
public class ServiciosService {
	
	@Autowired
	private ServiciosRepository serviciosRepository;
	
	public List<Servicios> getAll() {
		return serviciosRepository.getAll();
	}

	public Optional<Servicios> getServicios(int id) {
		return serviciosRepository.getServicios(id);
	}
	
	public void deleteServicios(int id) {
		serviciosRepository.deleteServicio(id);
	}
	public Servicios save(Servicios servicios) {
		if (servicios.getIdServicios() == null) {
			return serviciosRepository.save(servicios);
		} else {
			Optional<Servicios> servicios1 = serviciosRepository.getServicios(servicios.getIdServicios());
			if (servicios1.isEmpty()) {
				return serviciosRepository.save(servicios);
			} else {
				return servicios;
			}
		}
	}
	

	public Servicios modifyServicios(int id, Servicios servicios) {
		return serviciosRepository.modifyServicios(id, servicios);
	}
}

