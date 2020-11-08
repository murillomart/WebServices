package com.academico.ifgoias.app.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academico.ifgoias.app.core.excepions.RunTimeException;
import com.academico.ifgoias.app.core.utils.ReturnRequest;
import com.academico.ifgoias.app.core.utils.Status;
import com.academico.ifgoias.app.dto.AlunoDTO;
import com.academico.ifgoias.app.model.Aluno;
import com.academico.ifgoias.app.repository.AlunoRepository;

@Service
public class AlunoService
{
	private ModelMapper modelMapper;
	
	public AlunoService(ModelMapper modelMapper) 
	{
		this.modelMapper = modelMapper;
	}

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private Status status;
	
	@PersistenceContext
	private EntityManager con;
	
	public ReturnRequest findAll() 
	{
		List<Aluno> aluno = alunoRepository.findAll();
		
		ReturnRequest resultRequest = ReturnRequest.builder()
				.success(1)
				.status(status.getCode200())
				.totalResults(aluno.size())
				.resultsPerPage(0)
				.totalPages(0)
				.page(0)
				.successMessage("Resultados Obtidos")
				.data(aluno)
				.build();
		
		return resultRequest;
	}
	
	public ReturnRequest findOne(Integer id) 
	{
		Optional<Aluno> aluno = alunoRepository.findById(id);

		ReturnRequest resultRequest = ReturnRequest.builder()
				.success(1)
				.status(status.getCode200())
				.totalResults(1)
				.successMessage("Resultados Obtidos")
				.data(aluno)
				.build();
		
		return resultRequest;
	}
	
	@Transactional
	public ReturnRequest insert(AlunoDTO patrimony) 
	{
		Aluno entity = this.modelMapper.map(patrimony, Aluno.class);

		Aluno patrimonyAdded = alunoRepository.save(entity);
		
		ReturnRequest resultRequest = ReturnRequest.builder()
				.success(1)
				.status(status.getCode201())
				.totalResults(1)
				.successMessage("Aluno cadastrado com sucesso ")
				.data(patrimonyAdded)
				.build();

		return resultRequest;
	}
	
	public ReturnRequest update(Integer id, AlunoDTO patrimony) 
	{
		Aluno entity = this.modelMapper.map(patrimony, Aluno.class);
		entity.setIdaluno(id);

		Aluno patrimonyUpdated = alunoRepository.save(entity);
		
		ReturnRequest resultRequest = ReturnRequest.builder()
				.success(1)
				.status(status.getCode200())
				.totalResults(1)
				.successMessage("Aluno atualizado com sucesso")
				.data(patrimonyUpdated)
				.build();

		return resultRequest;
	}
	
	public ReturnRequest delete(Integer id) 
	{
		if (!alunoRepository.existsById(id)) {
			throw new RunTimeException("Aluno não existe na base de dados.");
		}
		
		alunoRepository.deleteById(id);
		
		ReturnRequest resultRequest = ReturnRequest.builder()
				.success(1)
				.status(status.getCode200())
				.successMessage("Aluno excluído com sucesso")
				.build();
		
		return resultRequest;
	}
}
