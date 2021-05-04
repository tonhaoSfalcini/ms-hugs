package com.hugs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hugs.entities.Cidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class CidadeIbgeDTO {

	private Long id;
	private String nome;
	@JsonProperty("microrregiao")
	private MicrorregiaoDTO microrregiao;
	
	
	public CidadeIbgeDTO(Cidade cidade) {
		this.id = cidade.getId();
		this.nome = cidade.getNome();
		this.microrregiao = new MicrorregiaoDTO(null, null,
				new MesorregiaoDTO(null, null, 
				new EstadoDTO(cidade.getEstado().getId(),
							  cidade.getEstado().getNome(),
							  cidade.getEstado().getSigla())));
	}
}