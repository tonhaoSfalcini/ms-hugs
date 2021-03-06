package com.hugs.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hugs.entities.Estado;

@FeignClient(url="https://servicodados.ibge.gov.br/api/v1/localidades/estados", name="estados")
public interface EstadoFeignService {

	@GetMapping
	List<Estado> listAll();
	
	@GetMapping(value = "/{uf}")
	Estado findByUf(@PathVariable Integer uf);
	
	
}
