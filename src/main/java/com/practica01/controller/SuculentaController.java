package com.practica01.controller;

import com.practica01.domain.Suculenta;
import com.practica01.service.SuculentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
 * Rutas del catalogo de suculentas.
 * Los avisos se envian como la llave del texto en messages.properties
 * y la vista se encarga de mostrar el texto correspondiente.
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/suculenta")
public class SuculentaController {

    private final SuculentaService suculentaService;

    // GET /suculenta/listado -> catalogo con los datos de la BD
    @GetMapping("/listado")
    public String listado(Model model) {
        model.addAttribute("suculentas", suculentaService.listarSuculentas());
        return "suculenta/listado";
    }

    // POST /suculenta/guardar -> lo usa el mismo formulario para registrar y para editar
    @PostMapping("/guardar")
    public String guardar(@Valid Suculenta suculenta, BindingResult resultado,
            RedirectAttributes atributos) {
        if (resultado.hasErrors()) {
            atributos.addFlashAttribute("avisoError", "aviso.datosInvalidos");
        } else {
            suculentaService.guardar(suculenta);
            atributos.addFlashAttribute("avisoExito", "aviso.guardada");
        }
        return "redirect:/suculenta/listado";
    }

    // POST /suculenta/eliminar -> recibe el id desde el boton Eliminar de cada tarjeta
    @PostMapping("/eliminar")
    public String eliminar(@RequestParam Integer idSuculenta, RedirectAttributes atributos) {
        if (suculentaService.eliminar(idSuculenta)) {
            atributos.addFlashAttribute("avisoExito", "aviso.eliminada");
        } else {
            atributos.addFlashAttribute("avisoError", "aviso.noExiste");
        }
        return "redirect:/suculenta/listado";
    }
}
