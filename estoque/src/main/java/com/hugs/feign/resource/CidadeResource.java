package com.hugs.feign.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	public ResponseEntity<String> getAll() throws JsonMappingException, JsonProcessingException{
//		public ResponseEntity<List<Cidade>> getAll(){
		String list = feignService.listAll();
		
		ObjectMapper obj = new ObjectMapper();
		List<CidadeIbgeDTO> listCar = obj.readValue(list, new TypeReference<List<CidadeIbgeDTO>>(){});

		listCar.forEach(x -> System.out.println(x));
		
//		List<CidadeIbgeDTO> list = feignService.listAll();
//		List<Cidade> result = list.stream()
//			.map(x -> cidadeService.convertDtoToEntity(x))
//			.collect(Collectors.toList());
		
//		return ResponseEntity.ok().body(result);
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping(value = "/municipios/{codigo}")
//	ResponseEntity<Cidade> findByCodigo(@PathVariable Integer codigo){
//		CidadeIbgeDTO cidade = feignService.findByCodigo(codigo);
//		Cidade result = cidadeService.convertDtoToEntity(cidade);
//		
//		return ResponseEntity.ok().body(result);
//	}
//	
//	@GetMapping(value = "/estados/{UF}/municipios")
//	ResponseEntity<List<Cidade>> findByUf(@PathVariable Integer UF){
//		List<CidadeIbgeDTO> list = feignService.findByUf(UF);
//		List<Cidade> result = list.stream()
//				.map(x -> cidadeService.convertDtoToEntity(x))
//				.collect(Collectors.toList());
//		
//		return ResponseEntity.ok().body(result);
//	}
	
}
