package com.jayr.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jayr.curso.springboot.webapp.springbootweb.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        User user = new User("Jayr","Perez");

        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title","Listado de usuarios!");
        return "list";

    }
    
    @ModelAttribute("users")
    public List<User> userModel(){
        return Arrays.asList(
            new User("pepa","gonzales"),
            new User("Lalo","Pewrez", "lalo@correo.com"),
            new User("Juanita","Roe", "juana@correo.com"),
            new User("Edmundo","Doe"));            
    }

}
