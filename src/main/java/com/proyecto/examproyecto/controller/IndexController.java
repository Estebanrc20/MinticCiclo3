package com.proyecto.examproyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {

    private final Logger LOG = Logger.getLogger(""+IndexController.class);

    @GetMapping("/")
    public String index(Model model){
        LOG.log(Level.INFO,"index");
        String mensaje = "Bienvenido al Sistema de gestion de ingresos y egresos";
        model.addAttribute("mensaje", mensaje);
        return "index";
    }
}
