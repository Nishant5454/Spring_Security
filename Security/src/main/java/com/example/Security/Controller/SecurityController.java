package com.example.Security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {
    @GetMapping("/user")
    public String userAccess(){
        return "Hello You have user access";
    }
    @GetMapping("/admin")
    public String adminAccess(){
        return "Hello You have admin access";
    }
    public String publicaccess(){
        return "This is unsecure APIEndPoint";
    }
}
