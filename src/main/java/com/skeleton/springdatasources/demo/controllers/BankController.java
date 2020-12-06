package com.skeleton.springdatasources.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/bank")
public class BankController {

    @GetMapping
    public String getBank() {
        String message = "Hello world!!";
        return message;
    }
}