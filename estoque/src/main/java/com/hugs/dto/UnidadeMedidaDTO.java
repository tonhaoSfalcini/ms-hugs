package com.hugs.dto;

import java.time.LocalDateTime;

import com.hugs.entities.UnidadeMedida;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UnidadeMedidaDTO {

	private Long id;
	
	private String descricao;

	private String sigla;
	
	private LocalDateTime dataCadastro;
	
	public UnidadeMedidaDTO(UnidadeMedida unidadeMedida) {
		this.id = unidadeMedida.getId();
		this.descricao = unidadeMedida.getDescricao();
		this.sigla = unidadeMedida.getSigla();
		this.dataCadastro = unidadeMedida.getDataCadastro();
	}
}
