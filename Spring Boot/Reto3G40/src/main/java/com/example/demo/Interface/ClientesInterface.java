package com.example.demo.Interface;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Modelo.Clientes;

public interface ClientesInterface extends CrudRepository<Clientes, Integer>  {

}
