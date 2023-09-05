package com.salavatcioglu.apiresource.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello world!";
    }

}
