package com.hugs.dto;

import com.hugs.entities.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
//@Builder
public class MesorregiaoIbgeDto{
	private Long id;
	private String nome;
//	@Builder.Default
//	private Estado UF = new Estado();
	private Estado UF;
	
}