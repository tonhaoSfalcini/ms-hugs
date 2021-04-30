package com.hugs.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity(name = "tb_produto")
public class Produto {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	private String cor;
	
	private String marca;
	
	private String especificacao;
	
	@ManyToOne
	@JoinColumn(name = "unidademedida_id", nullable = false)
	private UnidadeMedida unidadeMedida;

	private String categoria;
	
	private Integer mesesDurabilidade;
	
	private String modeloArmazenamento;
	
	private BigDecimal valorCusto;
	
	private BigDecimal valorVenda;
	
}
