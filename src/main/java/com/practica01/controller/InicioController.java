package com.practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * La aplicacion solo tiene el catalogo, entonces la raiz del sitio
 * (http://localhost:91/) manda directamente a esa pagina.
 */
@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/suculenta/listado";
    }
}
