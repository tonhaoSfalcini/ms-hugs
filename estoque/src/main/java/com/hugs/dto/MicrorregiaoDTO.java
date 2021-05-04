package com.hugs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class MicrorregiaoDTO{
	private Long id;
	private String nome;
	
	@JsonProperty("mesorregiao")
	private MesorregiaoDTO mesorregiao ;
	
}