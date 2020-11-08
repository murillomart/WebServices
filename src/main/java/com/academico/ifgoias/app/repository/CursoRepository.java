package com.academico.ifgoias.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academico.ifgoias.app.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> 
{

}
