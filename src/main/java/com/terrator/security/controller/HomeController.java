package com.terrator.security.controller;

import com.terrator.security.entity.SecurityUser;
import com.terrator.security.service.SecurityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private SecurityUserService securityUserService;

    @GetMapping("/home")
    public String home() {
        return  "You are in the user home page";
    }

    @GetMapping("/dashboard")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String dashBoard() {
        return "You are in the dashboard page";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String profile() {
        return "You are in the profile page";
    }

    @PostMapping("/register")
    public String register(@RequestBody SecurityUser securityUser) {
        return securityUserService.save(securityUser);
    }
}
