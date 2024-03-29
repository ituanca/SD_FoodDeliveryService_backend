package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path="/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/index")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @GetMapping("/{id}")
    public Admin findById(@PathVariable Integer id){
        log.info("AdminController:findById " + " id entered: " + id);
        return (Admin) adminService.findById(String.valueOf(id));
    }

    @GetMapping("/checkIfValid")
    public String checkIfValid(@Param("email") String email, @Param("username") String username) {
        log.info("AdminController:checkIfValid " + " email sent from frontend: " + email);
        log.info("AdminController:checkIfValid " + " username sent from frontend: " + username);
        return adminService.checkIfValid(email, username);
    }

    @GetMapping("/login")
    public String login(@Param("username") String username, @Param("password") String password){
        log.info("AdminController:login " + " username sent from frontend: " + username);
        return adminService.login(username, password);
    }

}