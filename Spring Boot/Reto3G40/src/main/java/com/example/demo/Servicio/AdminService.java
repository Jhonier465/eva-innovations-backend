/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Servicio;

import com.example.demo.Modelo.Admin;
import com.example.demo.Repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USUARIO
 */

@Service

public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
     public Admin save (Admin admin){
        if (admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if(admin1.isEmpty()){
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public void deleteAdmin(int id) {adminRepository.deleteAdmin(id);
    }
    public Admin modifyAdmin(int id, Admin admin) { return adminRepository.modifyAdmin(id,admin);
    }

}
