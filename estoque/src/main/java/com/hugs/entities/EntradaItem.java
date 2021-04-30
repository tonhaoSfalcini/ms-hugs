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
@Entity(name = "tb_entradaitem")
public class EntradaItem {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataCadastro;
	
	@ManyToOne
	@JoinColumn(name = "entrada_id", nullable = false)
	private Entrada entrada;

	private BigDecimal valorFrete;
	
	private BigDecimal valorTotal;
	
}
