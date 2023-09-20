package com.example.demo.Interface;

import com.example.demo.Modelo.Admin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminInterface extends CrudRepository<Admin, Integer> {
}
