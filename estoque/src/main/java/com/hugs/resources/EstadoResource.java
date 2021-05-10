package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.entities.Estado;
import com.hugs.services.EstadoService;

@RestController
@RequestMapping(value = "estados")
public class EstadoResource {

	@Autowired
	EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> getAll(){
		List<Estado> list = service.getListAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{uf}")
	ResponseEntity<Estado> findByUf(@PathVariable Long id){
		Estado estado = service.getById(id);
		
		return ResponseEntity.ok().body(estado);
	}
	
}
