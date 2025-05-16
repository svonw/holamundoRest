package com.sarabuitrago.demo_interminable_holamundo.controller;


import com.sarabuitrago.demo_interminable_holamundo.model.Saludo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class SaludadorController {

    private static final String template="Hello, %s!";
    private final AtomicLong counter=new AtomicLong();

    @GetMapping("/saludo")
    public Saludo saludo(@RequestParam(value="nombre", defaultValue = "a todos")String name){
        return new Saludo(counter.incrementAndGet(), String.format(template,name));
    }


}
