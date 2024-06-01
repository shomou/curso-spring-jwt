package com.jayr.curso.springboot.webapp.springbootweb.controllers;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayr.curso.springboot.webapp.springbootweb.models.User;
import com.jayr.curso.springboot.webapp.springbootweb.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    @ResponseBody
    public UserDto details(){

        UserDto userDto = new UserDto();
        
        User user = new User("Jayr","Perez");
        userDto.setTitle("Hola Mundo Spring Boot");
        userDto.setUser(user);
        
        return userDto;
    }

    @GetMapping("/list")
    @ResponseBody    
    public List<User> list(){
        User user = new User("Jayr","Perez");
        User user2 = new User("Pepe","Doe");
        User user3 = new User("Edmundo","Doe");

        List<User> users = Arrays.asList(user,user2,user3);

        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);


        return users;
    }


    @GetMapping("/details-map")
    @ResponseBody
    public Map<String, Object> detailsMap(){
        
        User user = new User("Jayr","Perez");
        Map <String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Spring Boot");
        body.put("user", user);

        

        return body;
    }


}
