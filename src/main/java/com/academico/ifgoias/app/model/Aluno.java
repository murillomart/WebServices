package com.academico.ifgoias.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "alunos",  uniqueConstraints=@UniqueConstraint(columnNames="idaluno", name="PK_ID_ALUNO"))
public class Aluno 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_id_aluno")
	private Integer idaluno;
	
	private String nome;
	private String sexo;
	
	@Column(name = "dt_nasc")
	private Date dtNasc;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Curso> cursos = new ArrayList<>();
	
	public void addCurso(Curso c) {
		this.cursos.add(c);
		c.getAlunos().add(this);
	}

	public void removeCurso(Curso c) {
		this.cursos.remove(c);
		c.getAlunos().remove(this);
	}

}
