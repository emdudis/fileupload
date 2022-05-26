package com.example.controllers;

import com.example.entities.Persona;
import com.example.services.PaisService;
import com.example.services.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class PersonaController {

    @Autowired
    private PaisService  paisService;

    @Autowired
    private PersonaService personaService;
    

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("personas", personaService.findAll());
        return "lista";
    }



    @GetMapping("/alta")
    public String alta(Model model){
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", paisService.findAll());
        return "formAlta";
    }
    
}