package com.hugs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
//@Builder
public class CidadeIbgeDTO {

	private Long id;
	private String nome;
//	@Builder.Default
//	private MicrorregiaoIbgeDTO microrregiao = new MicrorregiaoIbgeDTO();
	private MicrorregiaoIbgeDTO microrregiao;
	
}