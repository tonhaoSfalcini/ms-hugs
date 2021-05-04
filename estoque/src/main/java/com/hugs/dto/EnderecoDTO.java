package com.hugs.dto;

import com.hugs.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class EnderecoDTO {
	
	private Long id;

	private String tipoLogradouro;
	
	private String nomeLogradouro;
	
	private Integer numero;
	
	private String bairro;
	
	private Long cidade;
	
	private String cep;
	
	private String referencia;
	
	public EnderecoDTO(Endereco endereco) {
		this.id = endereco.getId();
		this.tipoLogradouro = endereco.getTipoLogradouro();
		this.nomeLogradouro = endereco.getNomeLogradouro();
		this.numero = endereco.getNumero();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade().getId();
		this.cep = endereco.getCep();
		this.referencia = endereco.getReferencia();
	}
	
}
