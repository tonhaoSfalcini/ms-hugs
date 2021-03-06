package com.hugs.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity(name = "tb_estoque")
public class Estoque {

	@Setter(value = AccessLevel.NONE) 
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "produto_id", nullable = false)
	private Produto produto;

	private BigDecimal quantidade;
	
	private BigDecimal custoMedio;
	
	private BigDecimal custoMinimo;
	
	private BigDecimal custoMaximo;
	
}
