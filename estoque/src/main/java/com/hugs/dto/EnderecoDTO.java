package com.hugs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EnderecoDTO {
	
//	private Long id;

	private String tipoLogradouro;
	
	private String nomeLogradouro;
	
	private Integer numero;
	
	private String bairro;
	
	private Long cidade;
	
	private String cep;
	
	private String referencia;
	
}
