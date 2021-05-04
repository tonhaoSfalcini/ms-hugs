package com.hugs.dto;

import com.hugs.entities.Estado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EstadoDTO {

	private Long id;
	private String nome;
	private String sigla;
	
	public EstadoDTO(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.sigla = estado.getSigla();
	}
}