package com.hugs.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

	public UnidadeMedida save(UnidadeMedidaDTO dto) {
		UnidadeMedida obj = new UnidadeMedida(dto);
		return save(obj);
	}

	public List<UnidadeMedida> getAll(){
		return repository.findAll();
	}

	public UnidadeMedida getById(Long id) {
		return repository.getOne(id);
	}

	public UnidadeMedida save(UnidadeMedida obj) {
		if(obj.getDataCadastro() == null)obj.setDataCadastro(LocalDateTime.now());
		
		UnidadeMedida response = repository.save(obj);

		return response;		
	}

	public List<UnidadeMedida> saveAll(List<UnidadeMedida> list) {
		List<UnidadeMedida> response = new ArrayList<UnidadeMedida>();
		list.forEach(x -> response.add(save(x)));
		return response;
	}
}