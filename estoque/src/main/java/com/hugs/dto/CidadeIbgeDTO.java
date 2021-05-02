package com.hugs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class CidadeIbgeDTO {

	private Long id;
	private String nome;
	private MicrorregiaoDTO microrregiao;
	
}