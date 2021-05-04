package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.entities.Cidade;
import com.hugs.services.CidadeService;

@RestController
@RequestMapping(value = "cidades")
public class CidadeResource {

	@Autowired
	CidadeService service;

	@GetMapping()
	public ResponseEntity<List<Cidade>> getAll(){
		
		List<Cidade> list = service.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Cidade> findByCodigo(@PathVariable Long id){
		Cidade c = service.getById(id);
		
		return ResponseEntity.ok().body(c);
	}
	
	@GetMapping(value = "/estados/{UF}/municipios")
	ResponseEntity<List<Cidade>> findByUfId(@PathVariable Long id){
		List<Cidade> list = service.findByUfId(id);
		return ResponseEntity.ok().body(list);
	}
	
}
