package com.example.demo.Interface;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Modelo.Productos;
import com.example.demo.Modelo.Servicios;

public interface ProductosInterface  extends CrudRepository<Productos, Integer> {

}
