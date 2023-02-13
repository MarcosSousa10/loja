package com.dev.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principal {
    @GetMapping("/administrativo")
    public String acessarPrincipal(){
        return "administrativo/home";
    }
}
