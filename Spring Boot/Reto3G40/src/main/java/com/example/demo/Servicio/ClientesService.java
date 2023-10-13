package com.example.demo.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modelo.Clientes;
import com.example.demo.Repositorio.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	public List<Clientes> getAll() {
		return clientesRepository.getAll();
	}

	public Optional<Clientes> getClientes(int id) {
		return clientesRepository.getClientes(id);
	}
	
	public void deleteClientes(int id) {
		clientesRepository.deleteClientes(id);
	}
}
