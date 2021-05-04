package com.hugs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hugs.dto.EnderecoDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
@Entity(name = "tb_endereco")
public class Endereco {
	
	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipoLogradouro;
	
	private String nomeLogradouro;
	
	private Integer numero;
	
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false)
	@Builder.Default private Cidade cidade = new Cidade();
	
	private String cep;
	
	private String referencia;

	public Endereco(EnderecoDTO dto) {
		this.id = dto.getId();
		this.tipoLogradouro = dto.getTipoLogradouro();
		this.nomeLogradouro = dto.getNomeLogradouro();
		this.numero = dto.getNumero();
		this.bairro = dto.getBairro();
		this.cidade = new Cidade(dto.getCidade(), null, null);
		this.cep = dto.getCep();
		this.referencia = dto.getReferencia();
	}
	
}
