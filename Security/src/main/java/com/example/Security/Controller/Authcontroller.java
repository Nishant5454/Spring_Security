package com.example.Security.Controller;

import com.example.Security.Entity.Authorities;
import com.example.Security.Entity.Users;
import com.example.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class Authcontroller {
    @Autowired
    private UserService userService;
    public Authcontroller(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users users, @RequestBody Authorities authorities){
       userService.saveUser(users.getUsername(), users.getPassword());
       userService.saveUser(authorities.getUsername(), authorities.getAuthority());

       return ResponseEntity.ok().body("OK hai sab");
    }
    @GetMapping("/get")
    public ResponseEntity<String> getUser(@RequestParam String username, @RequestParam String password){
        boolean isValidUser= userService.getUser(username, password);
        if(isValidUser){
            return ResponseEntity.ok("Login Succsess");
        }
        else{
            return ResponseEntity.ok("Invalid credentials");
        }
    }

}

