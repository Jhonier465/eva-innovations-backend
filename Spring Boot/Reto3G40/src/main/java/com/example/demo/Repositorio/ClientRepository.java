package com.example.demo.Repositorio;

import java.util.List;
import java.util.Optional;

import com.example.demo.Interface.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.Modelo.Client;

/**
 *
 * @author USUARIO
 */

@Repository

public class ClientRepository {

	@Autowired

	private ClientInterface extencionesCrud;

	public List<Client> getAll() {
		return (List<Client>) extencionesCrud.findAll();
	}

	public Optional<Client> getClient(int id) {
		return extencionesCrud.findById(id);
	}

	public Client save(Client client) {
		return extencionesCrud.save(client);
	}

	public void deleteClient(int id) {
		extencionesCrud.deleteById(id);
	}

	public Client modifyClient(int id, Client client) {
		return extencionesCrud.findById(id).map(client1 -> {
			client1.setName(client.getName());
			client1.setAge(client.getAge());
			client1.setEmail(client.getEmail());
			client1.setPassword(client.getPassword());
			return extencionesCrud.save(client1);
		}).orElseGet(() -> {
			client.setIdClient(id);
			return extencionesCrud.save(client);
		});
	}
}
