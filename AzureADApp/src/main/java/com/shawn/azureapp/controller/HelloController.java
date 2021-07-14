package com.shawn.azureapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class HelloController {
	@Value("${welcomeMessage}")
	private String welcomeMessage;
	
    @GetMapping("/open")
    public String open() {
        return "Open to Everyone!!!  Welcome Message:  " + this.welcomeMessage;
    }
	@PreAuthorize("hasRole('ROLE_Users')")
	@GetMapping("/")
    public String helloWorld() {
        return "Hello Users!  Welcome Message:  " + this.welcomeMessage;
    }
    @PreAuthorize("hasRole('ROLE_group1')")
    @GetMapping("/Group1")
    public String groupOne() {
        return "Hello Group 1 Users!  Welcome Message:  " + this.welcomeMessage;
    }
    @PreAuthorize("hasRole('ROLE_group2')")
    @GetMapping("/Group2")
    public String groupTwo() {
        return "Hello Group 2 Users!  Welcome Message:  " + this.welcomeMessage;
    }
}