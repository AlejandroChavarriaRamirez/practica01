package com.practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // http://localhost:91/ redirige al listado de suculentas
    @GetMapping("/")
    public String index() {
        return "redirect:/suculenta/listado";
    }
}
