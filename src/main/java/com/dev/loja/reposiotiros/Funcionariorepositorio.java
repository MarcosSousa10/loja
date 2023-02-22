package com.dev.loja.reposiotiros;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.loja.modelos.Funcionario;

public interface Funcionariorepositorio extends JpaRepository<Funcionario,Long>{
    
}
