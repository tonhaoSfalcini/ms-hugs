package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugs.dto.ProdutoDTO;
import com.hugs.entities.Produto;
import com.hugs.services.ProdutoService;

@RestController
@RequestMapping(value = "products")
public class ProdutoResource {

	@Autowired
	ProdutoService produtoService;
	
	@PostMapping()
	public ResponseEntity<Produto> insertCliente(@RequestBody ProdutoDTO dto){

		Produto cliente = produtoService.create(dto);

		return ResponseEntity.ok().body(cliente);
	}
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> clients = produtoService.getAll();

		return ResponseEntity.ok().body(clients);
	}

	@GetMapping(value = "/params", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getParamsInsertCliente() throws JsonProcessingException{
		StringBuilder sb = new StringBuilder();
		ObjectMapper obj = new ObjectMapper();
		sb.append(obj.writeValueAsString(new Produto()));
		
		return ResponseEntity.ok().body(sb.toString());
	}

}
