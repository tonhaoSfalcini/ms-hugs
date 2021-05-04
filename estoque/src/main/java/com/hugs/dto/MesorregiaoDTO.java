package com.hugs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MesorregiaoDTO{
	private Long id;
	private String nome;
	
	@JsonProperty("UF")
	private EstadoDTO UF;
	
}
