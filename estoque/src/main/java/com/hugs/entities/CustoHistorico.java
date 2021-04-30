package com.hugs.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
@Entity(name = "tb_custohistorico")
public class CustoHistorico {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "custo_id", nullable = false)
	private Custo custo;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "unidadeMedida_id", nullable = false)
	private UnidadeMedida unidadeMedida;

	private BigDecimal valorUnitario;
	
	private LocalDateTime dataCadastro;
}
