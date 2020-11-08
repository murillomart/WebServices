package com.academico.ifgoias.app.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO 
{
	private String nome;
	private String sexo;
	private Date dtNasc;
}
