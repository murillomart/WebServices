package com.academico.ifgoias.app.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.academico.ifgoias.app.core.utils.ReturnRequest;
import com.academico.ifgoias.app.core.utils.Status;
import com.academico.ifgoias.app.dto.AlunoDTO;
import com.academico.ifgoias.app.service.AlunoService;

@RestController
@RequestMapping("/v1/alunos")
public class AlunoController
{
	@Autowired 
	private AlunoService alunoService;
	
	@Autowired
	private Status status;
	
	@Autowired
	private HttpServletResponse response;
	
	@GetMapping
	public ReturnRequest findAll() 
	{
		try {
			ReturnRequest result = alunoService.findAll();
			
			ResponseEntity.ok(result.getData());
			response.setStatus(result.getStatus());
			
			return result;
		} catch (Exception e) {
			ReturnRequest resultRequest = ReturnRequest.builder()
					.success(0)
					.status(status.getCode400())
					.errorMessage(e.getMessage())
					.build();
			
			ResponseEntity.badRequest().build();
			response.setStatus(status.getCode400());
			
			return resultRequest;
		}
	}
	
	@GetMapping("/{id}")
	public ReturnRequest findOne(@PathVariable Integer id) 
	{
		try {
			ReturnRequest result = alunoService.findOne(id);
			
			ResponseEntity.ok(result.getData());
			response.setStatus(result.getStatus());
			
			return result;
		} catch (Exception e) {
			ReturnRequest resultRequest = ReturnRequest.builder()
					.success(0)
					.status(status.getCode400())
					.errorMessage(e.getMessage())
					.build();
			
			ResponseEntity.badRequest().build();
			response.setStatus(status.getCode400());
			
			return resultRequest;
		}
	}

	@PostMapping
	public ReturnRequest insert(@Valid @RequestBody AlunoDTO patrimony)
	{
		try {
			ReturnRequest result = alunoService.insert(patrimony);
			
			ResponseEntity.ok(result.getData());
			response.setStatus(result.getStatus());
			
			return result;
		} catch (Exception e) {
			ReturnRequest resultRequest = ReturnRequest.builder()
					.success(0)
					.status(status.getCode400())
					.errorMessage(e.getMessage())
					.build();
			
			ResponseEntity.badRequest().build();
			response.setStatus(status.getCode400());
			
			return resultRequest;
		}
	}
	
	@PutMapping("/{id}")
	public ReturnRequest update(@Valid @PathVariable Integer id, @RequestBody AlunoDTO patrimony) 
	{
		try {
			ReturnRequest result = alunoService.update(id, patrimony);
			
			ResponseEntity.ok(result.getData());
			response.setStatus(result.getStatus());
			
			return result;
		} catch (Exception e) {
			ReturnRequest resultRequest = ReturnRequest.builder()
					.success(0)
					.status(status.getCode400())
					.errorMessage(e.getMessage())
					.build();
			
			ResponseEntity.badRequest().build();
			response.setStatus(status.getCode400());
			
			return resultRequest;
		}
	}
	
	@DeleteMapping("/{id}")
	public ReturnRequest delete(@PathVariable Integer id) 
	{
		try {
			ReturnRequest result = alunoService.delete(id);
			
			ResponseEntity.ok();
			response.setStatus(result.getStatus());
			
			return result;
		} catch (Exception e) {
			ReturnRequest resultRequest = ReturnRequest.builder()
					.success(0)
					.status(status.getCode400())
					.errorMessage(e.getMessage())
					.build();
			
			ResponseEntity.badRequest().build();
			response.setStatus(status.getCode400());
			
			return resultRequest;
		}
	}
}
