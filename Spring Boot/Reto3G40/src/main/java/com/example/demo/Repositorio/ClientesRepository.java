package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Interface.ClientesInterface;
import com.example.demo.Modelo.Clientes;


@Repository
public class ClientesRepository {
	@Autowired
	private ClientesInterface extencionesCrud;
	public List<Clientes> getAll() {
		return (List<Clientes>) extencionesCrud.findAll();
	}
	public Optional<Clientes> getClientes(int id) {
		return extencionesCrud.findById(id);
	}
	public void deleteClientes(int id) {
		extencionesCrud.deleteById(id);
	}
}
