package com.hugs.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.UnidadeMedidaDTO;
import com.hugs.entities.UnidadeMedida;
import com.hugs.repositories.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {
	Logger log = LoggerFactory.getLogger(EstadoService.class);


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
		if(obj.getDataCadastro() == null) {
			obj.setDataCadastro(LocalDateTime.now());
		}
		
		UnidadeMedida response = repository.saveAndFlush(obj);

		return response;		
	}

	public List<UnidadeMedida> saveAll(List<UnidadeMedida> list) {
		List<UnidadeMedida> response = new ArrayList<UnidadeMedida>();
		list.forEach(x -> response.add(save(x)));
		return response;
	}
	
	public void loadInitialData() {
		UnidadeMedida unim_1 = new UnidadeMedida(null, "Kilograma", "Kg", null);
		UnidadeMedida unim_2 = new UnidadeMedida(null, "Unidade", "Und", null);
		UnidadeMedida unim_3 = new UnidadeMedida(null, "Grama", "g", null);
		UnidadeMedida unim_4 = new UnidadeMedida(null, "Miligrama", "mg", null);
		UnidadeMedida unim_5 = new UnidadeMedida(null, "Mililitro", "ml", null);
		saveAll(Arrays.asList(unim_1, unim_2, unim_3, unim_4, unim_5));
		log.info("Unidades de Medida inseridas");
	}
}