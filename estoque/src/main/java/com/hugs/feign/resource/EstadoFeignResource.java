package com.hugs.feign.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.entities.Estado;
import com.hugs.feign.service.EstadoFeignService;

@RestController
@RequestMapping(value = "ibge/estados")
public class EstadoFeignResource {

	@Autowired
	EstadoFeignService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> getAll(){
		List<Estado> list = service.listAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{uf}")
	ResponseEntity<Estado> findByUf(@PathVariable Integer uf){
		Estado estado = service.findByUf(uf);
		
		return ResponseEntity.ok().body(estado);
	}
	
}
