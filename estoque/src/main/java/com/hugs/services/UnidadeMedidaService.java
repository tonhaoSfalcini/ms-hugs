package com.hugs.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.UnidadeMedidaDTO;
import com.hugs.entities.UnidadeMedida;
import com.hugs.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {

	
	@Autowired 
	UnidadeMedidaRepository repository;

	public UnidadeMedida create(UnidadeMedidaDTO dto) {
		UnidadeMedida obj = new UnidadeMedida(dto);
		obj.setDataCadastro(LocalDateTime.now());
		UnidadeMedida response = repository.save(obj);
		
		return response;
	}
	
	public List<UnidadeMedida> getAll(){
		return repository.findAll();
	}
	
	public UnidadeMedida getById(Long id) {
		return repository.getOne(id);
	}
	
	
}
