package com.hugs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
//@Builder
public class MicrorregiaoIbgeDTO{
	private Long id;
	private String nome;
//	@Builder.Default
//	private MesorregiaoIbgeDto mesorregiao = new MesorregiaoIbgeDto();
	private MesorregiaoIbgeDto mesorregiao ;
	
}