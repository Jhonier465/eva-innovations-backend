package com.example.demo.Repositorio;

import com.example.demo.Interface.AdminInterface;
import com.example.demo.Modelo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

private AdminInterface adminInterface;


    @Autowired
    private AdminInterface extencionesCrud;

    public List<Admin> getAll(){
        return (List<Admin>) extencionesCrud.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return extencionesCrud.findById(id);
    }

    public Admin save(Admin admin){
        return extencionesCrud.save(admin);
    }
    public void deleteAdmin(int id){
        extencionesCrud.deleteById(id);
    }

    public Admin modifyAdmin(int id, Admin admin) {
        return extencionesCrud.findById(id)
                .map(admin1 -> {
                    admin1.setName(admin.getName());
                    admin1.setEmail(admin.getEmail());
                    admin1.setPassword(admin.getPassword());
                    return extencionesCrud.save(admin1);
                })
                .orElseGet(() -> {
                    admin.setIdAdmin(id);
                    return extencionesCrud.save(admin);
                });
    }

}
