package com.hugs.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hugs.dto.UnidadeMedidaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity(name = "tb_unidademedida")
public class UnidadeMedida {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String descricao;

	@Column(unique = true, nullable = false)
	private String sigla;
	
	@Column(nullable = false)
	private LocalDateTime dataCadastro;
	
	public UnidadeMedida(UnidadeMedidaDTO dto) {
		this.id = dto.getId();
		this.descricao = dto.getDescricao();
		this.sigla = dto.getSigla();
		this.dataCadastro = dto.getDataCadastro();
	}
}
