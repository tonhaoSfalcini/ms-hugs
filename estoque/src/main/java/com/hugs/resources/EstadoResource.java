package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hugs.entities.Estado;
import com.hugs.services.EstadoService;

@RestController
@RequestMapping(value = "estados")
public class EstadoResource {

	@Autowired
	EstadoService service;
	
	@PostMapping(value="initialData")
	public ResponseEntity<String> loadInitialData() throws JsonMappingException, JsonProcessingException{
		service.loadEstadosFromFeignIbge();
		return ResponseEntity.ok().body("Processado com sucesso");
	}
	
	@GetMapping
	public ResponseEntity<List<Estado>> getAll(){
		List<Estado> list = service.getListAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{uf}")
	ResponseEntity<Estado> findByUf(@PathVariable Long uf){
		Estado estado = service.getById(uf);
		
		return ResponseEntity.ok().body(estado);
	}
	
}
