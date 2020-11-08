package com.academico.ifgoias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academico.ifgoias.app.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> 
{

}
