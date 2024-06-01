package com.jayr.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jayr.curso.springboot.webapp.springbootweb.models.User;
import com.jayr.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.code}")
    private Integer code;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;


    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valuesList;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap; 


    @GetMapping("/vaz/{message}")
    public ParamDto vaz(@PathVariable String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }


    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVariable(@PathVariable String product, @PathVariable Long id) {
        
        Map<String, Object> json = new HashMap<>();

        json.put("product", product);
        json.put("id", id);

        return json;

    }



    @PostMapping("/create")
    public User create(@RequestBody User user){

        user.setName(user.getName().toUpperCase());

        //Hacer algo con el usuario por ejemplo un save

        return user;
    }


    @GetMapping("/values")
    public Map<String, Object> values(@Value ("${config.message}") String message){

        Map<String, Object> json  = new HashMap<>();

        json.put("message", this.message);
        json.put("username", this.username);
        json.put("code", this.code);
        json.put("listOfValues", this.listOfValues);
        json.put("valueList", this.valuesList);
        json.put("valueList", this.valuesMap);

        


        return json;
    }
    
    

}
