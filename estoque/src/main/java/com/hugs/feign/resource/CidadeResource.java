package com.hugs.feign.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.dto.CidadeIbgeDTO;
import com.hugs.entities.Cidade;
import com.hugs.feign.service.CidadeFeignService;
import com.hugs.services.CidadeService;

@RestController
@RequestMapping(value = "cidades")
public class CidadeResource {

	@Autowired
	CidadeFeignService feignService;

	@Autowired
	CidadeService cidadeService;
	
	@GetMapping(value="/municipios")
	public ResponseEntity<List<Cidade>> getAll(){
		
		List<CidadeIbgeDTO> list = feignService.listAll();
		List<Cidade> result = list.stream()
			.map(x -> new Cidade(x))
			.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/municipios/{codigo}")
	ResponseEntity<Cidade> findByCodigo(@PathVariable Integer codigo){
		CidadeIbgeDTO cidade = feignService.findByCodigo(codigo);
		Cidade result = new Cidade(cidade);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/estados/{UF}/municipios")
	ResponseEntity<List<Cidade>> findByUf(@PathVariable Integer UF){
		List<CidadeIbgeDTO> list = feignService.findByUf(UF);
		List<Cidade> result = list.stream()
				.map(x ->  new Cidade(x))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(result);
	}
	
}
