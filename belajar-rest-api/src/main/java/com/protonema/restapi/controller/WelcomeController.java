package com.protonema.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.protonema.restapi.dto.Request;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    
    // POST Method
    @PostMapping
    public String postData(@RequestBody Request request) {
        return "Halo, selamat datang " + request.getName();
    }

    // GET Method
    @GetMapping
    @RequestMapping("/get")
    public String getData() {
        return "Ini Get Method";
    }

    // PUT Method
    @PutMapping
    public Request updateData(@RequestBody Request request) {
        return request;
    }

    // // Parameter 1 Dan 2
    
    // @PostMapping
    // @RequestMapping("/parameter")
    // public Long postParameter(@RequestParam Long id) {
    //     return id;
    // }
    
    // Parameter
    @PostMapping
    @RequestMapping("/parameter")
    public Long postParameter(@RequestParam Long x, @RequestParam Long y) {
        return x + y;
    }
}
