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

    //Se usa un servicio mediante SuculentaService
    private final SuculentaService suculentaService;
    private final MessageSource messageSource;

    @GetMapping("/listado")
    public String listado(Model model) {
        var suculentas = suculentaService.getSuculentas();
        model.addAttribute("suculentas", suculentas);
        model.addAttribute("totalSuculentas", suculentas.size());
        return "suculenta/listado";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Suculenta suculenta,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        String titulo = "todoOk";
        String mensaje = "mensaje.actualizado";

        if (bindingResult.hasErrors()) {
            titulo = "error";
            mensaje = "suculenta.error03";
        } else {
            suculentaService.save(suculenta);
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(mensaje, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta,
            RedirectAttributes redirectAttributes) {

        String titulo = "todoOk";
        String mensaje = "mensaje.eliminado";
        try {
            suculentaService.delete(idSuculenta);
        } catch (IllegalArgumentException e) {
            titulo = "error";
            mensaje = "suculenta.error01";
        } catch (Exception e) {
            titulo = "error";
            mensaje = "suculenta.error02";
        }
        redirectAttributes.addFlashAttribute(titulo, messageSource.getMessage(mensaje, null, Locale.getDefault()));
        return "redirect:/suculenta/listado";
    }
}
