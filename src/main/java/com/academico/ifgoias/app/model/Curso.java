package com.academico.ifgoias.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cursos",  uniqueConstraints=@UniqueConstraint(columnNames="idcurso", name="PK_ID_CURSO"))
public class Curso {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_curso")
	private Integer idcurso;
	
	private String nomecurso;
	
	@ManyToMany
	@JsonIgnore
	@JoinTable( name="aluno_curso",
				joinColumns = @JoinColumn(name="idcurso"),
				inverseJoinColumns = @JoinColumn(name="idaluno"))
	private List<Aluno> alunos = new ArrayList<>();
}
