package com.hugs.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hugs.dto.CidadeIbgeDTO;

@FeignClient(url="https://servicodados.ibge.gov.br/api/v1/localidades", name="cidades")
public interface CidadeFeignService {

	@GetMapping(value = "/municipios")
	List<CidadeIbgeDTO> listAll();
	
	@GetMapping(value = "/municipios/{codigo}")
	CidadeIbgeDTO findByCodigo(@PathVariable Integer codigo);
	
	
	@GetMapping(value = "/estados/{UF}/municipios")
	List<CidadeIbgeDTO> findByUf(@PathVariable Integer UF);
}
