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
import com.hugs.dto.UnidadeMedidaDTO;
import com.hugs.entities.UnidadeMedida;
import com.hugs.services.UnidadeMedidaService;

@RestController
@RequestMapping(value = "medidas")
public class UnidadeMedidaResource {

	@Autowired
	UnidadeMedidaService unidadeMedidaService;
	
	@PostMapping()
	public ResponseEntity<UnidadeMedida> insertCliente(@RequestBody UnidadeMedidaDTO dto){

		UnidadeMedida result = unidadeMedidaService.save(dto);

		return ResponseEntity.ok().body(result);
	}
	@GetMapping
	public ResponseEntity<List<UnidadeMedida>> getAll(){
		List<UnidadeMedida> result = unidadeMedidaService.getAll();

		return ResponseEntity.ok().body(result);
	}

	@GetMapping(value = "/params", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getParamsInsert() throws JsonProcessingException{
		StringBuilder sb = new StringBuilder();
		ObjectMapper obj = new ObjectMapper();
		sb.append(obj.writeValueAsString(new UnidadeMedida()));
		
		return ResponseEntity.ok().body(sb.toString());
	}

}
