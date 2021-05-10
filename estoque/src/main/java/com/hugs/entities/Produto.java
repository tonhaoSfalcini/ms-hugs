package com.hugs.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hugs.dto.ProdutoDTO;

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
	
	@Column(nullable = false)
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
	
	@Column(nullable = false)
	private BigDecimal valorVenda;
	
	public Produto(ProdutoDTO dto) {
		this.id = dto.getId();
		this.descricao = dto.getDescricao();
		this.cor = dto.getCor();
		this.marca = dto.getMarca();
		this.especificacao = dto.getEspecificacao();
		this.unidadeMedida = new UnidadeMedida(dto.getUnidadeMedida(), null, null, null);
		this.categoria = dto.getCategoria();
		this.mesesDurabilidade = dto.getMesesDurabilidade();
		this.modeloArmazenamento = dto.getModeloArmazenamento();
		this.valorCusto = dto.getValorCusto();
		this.valorVenda = dto.getValorVenda();
	}
}
