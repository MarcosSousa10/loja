package com.dev.loja.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.dev.loja.modelos.Funcionario;
import com.dev.loja.reposiotiros.Funcionariorepositorio;
@Controller
public class FuncionarioCopntrole {
    @Autowired
    private Funcionariorepositorio funcionariorepositorio;
    @GetMapping("/administrativo/funcionarios/cadastrar")
    public ModelAndView cadastrar(Funcionario funcionario){
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/cadastro");
        mv.addObject("funcionario", funcionario);
        return mv;
    }
    @GetMapping("/administrativo/funcionarios/editar/{id}")
    public ModelAndView editar (@PathVariable("id") Long id){
        Optional<Funcionario> funcionario= funcionariorepositorio.findById(id);
        return cadastrar(funcionario.get());
    }
    @GetMapping("/administrativo/funcionarios/remover/{id}")
    public ModelAndView remover (@PathVariable("id") Long id){
        Optional<Funcionario> funcionario= funcionariorepositorio.findById(id);
        funcionariorepositorio.delete(funcionario.get());
        return listar();
    }
    @GetMapping("/administrativo/funcionarios/listar")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("administrativo/funcionarios/lista");
        mv.addObject("listaFuncionarios", funcionariorepositorio.findAll());
        return mv;
    }
    @PostMapping("/administrativo/funcionarios/salvar")
    public ModelAndView salvar (@Validated Funcionario funcionario, BindingResult result){
        if(result.hasErrors()){
            return cadastrar(funcionario);
        }
        funcionariorepositorio.saveAndFlush(funcionario);
        return cadastrar(new Funcionario());
    }
}
