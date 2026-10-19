package com.practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    // La raiz manda al catalogo
    @GetMapping("/")
    public String inicio() {
        return "redirect:/suculenta/listado";
    }
}
