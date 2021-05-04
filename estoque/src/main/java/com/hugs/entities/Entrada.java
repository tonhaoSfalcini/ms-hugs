package com.hugs.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
@Entity(name = "tb_entrada")
public class Entrada {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Builder.Default private LocalDateTime dataCadastro = LocalDateTime.now();

	private LocalDate dataMovimento;
	
	private String tipo;
	
	private BigDecimal valorFrete;
	
	private BigDecimal valorTotal;
	
	@OneToMany(mappedBy = "entrada")
	@Builder.Default List<EntradaItem> itens = new ArrayList<>();
}
