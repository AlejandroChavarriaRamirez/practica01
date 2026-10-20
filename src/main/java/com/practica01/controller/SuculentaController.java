package com.practica01.controller;

import com.practica01.domain.Suculenta;
import com.practica01.service.SuculentaService;
import jakarta.validation.Valid;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/suculenta")
public class SuculentaController {

    private final SuculentaService suculentaService;
    private final MessageSource messageSource;

    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("suculentas", suculentaService.listarSuculentas());
        return "suculenta/listado";
    }

    // Sirve para registrar y para editar
    @PostMapping("/guardar")
    public String guardar(@Valid Suculenta suculenta, BindingResult resultado,
            RedirectAttributes atributos) {
        String tipo = "mensajeExito";
        String llave = "aviso.guardada";
        if (resultado.hasErrors()) {
            tipo = "mensajeError";
            llave = "aviso.datosInvalidos";
        } else {
            suculentaService.guardar(suculenta);
        }
        atributos.addFlashAttribute(tipo, messageSource.getMessage(llave, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta, RedirectAttributes atributos) {
        String tipo = "mensajeExito";
        String llave = "aviso.eliminada";
        try {
            suculentaService.eliminar(idSuculenta);
        } catch (IllegalArgumentException e) {
            tipo = "mensajeError";
            llave = "aviso.noExiste";
        }
        atributos.addFlashAttribute(tipo, messageSource.getMessage(llave, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }
}
