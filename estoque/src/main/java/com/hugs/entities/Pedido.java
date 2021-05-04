package com.hugs.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
@Entity(name = "tb_pedido")
public class Pedido {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Builder.Default private LocalDateTime dataCadastro = LocalDateTime.now();

	private LocalDate dataEntrega;

	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	@Builder.Default private Cliente cliente = new Cliente();
	
	private Boolean entrega;
	
	private String status;
}
