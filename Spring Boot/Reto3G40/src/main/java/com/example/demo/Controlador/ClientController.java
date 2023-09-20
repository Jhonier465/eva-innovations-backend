/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;


import org.springframework.web.bind.annotation.*;
import com.example.demo.Modelo.Client;
import com.example.demo.Servicio.ClientService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Client")

public class ClientController {
     @Autowired
    private ClientService clientService;
    @CrossOrigin
    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int id){
        return clientService.getClient(id);
    }
    @CrossOrigin
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return clientService.save(client);
    }
    @CrossOrigin
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable("id") int id ){clientService.deleteClient(id);}
    @CrossOrigin
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client modifyClient(@RequestBody Client client, @PathVariable("id") int id ){ return clientService.modifyClient(id,client); }




}