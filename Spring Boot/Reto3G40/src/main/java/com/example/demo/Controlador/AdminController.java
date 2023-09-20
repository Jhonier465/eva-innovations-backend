/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Admin;
import com.example.demo.Servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    @CrossOrigin
    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminService.getAdmin(id);
    }
    @CrossOrigin
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }
    @CrossOrigin
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdmin(@PathVariable("id") int id ){adminService.deleteAdmin(id);}
    @CrossOrigin
    @PutMapping("/{id}")
    public Admin modifyAdmin(@RequestBody Admin admin, @PathVariable("id") int id ){ return adminService.modifyAdmin(id,admin); }

}
