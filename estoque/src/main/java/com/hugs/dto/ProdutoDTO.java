package com.hugs.dto;

import java.math.BigDecimal;

import com.hugs.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor 
public class ProdutoDTO {

	private Long id;
	private String descricao;
	private String cor;
	private String marca;
	private String especificacao;
	private Long unidadeMedida;
	private String categoria;
	private Integer mesesDurabilidade;
	private String modeloArmazenamento;
	private BigDecimal valorCusto;
	private BigDecimal valorVenda;


	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.cor = produto.getCor();
		this.marca = produto.getMarca();
		this.especificacao = produto.getEspecificacao();
		this.unidadeMedida = produto.getUnidadeMedida().getId();
		this.categoria = produto.getCategoria();
		this.mesesDurabilidade = produto.getMesesDurabilidade();
		this.modeloArmazenamento = produto.getModeloArmazenamento();
		this.valorCusto = produto.getValorCusto();
		this.valorVenda = produto.getValorVenda();
	}
}