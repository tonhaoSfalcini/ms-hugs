package com.hugs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MesorregiaoDTO{
	private Long id;
	private String nome;
	private EstadoDTO UF;
	
}
