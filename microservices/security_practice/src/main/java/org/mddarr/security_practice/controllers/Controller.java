package org.mddarr.security_practice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping
    public String getString(){
        return "string";
    }
}
