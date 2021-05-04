package com.hugs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.hugs.dto.EstadoDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @RequiredArgsConstructor @Data @Builder
@Entity(name = "tb_estado")
public class Estado {

	@Setter(value = AccessLevel.NONE) 	@NonNull
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String sigla;

	private String nome;
	
	public Estado(EstadoDTO dto) {
		this.id = dto.getId();
		this.sigla = dto.getSigla();
		this.nome = dto.getNome();
	}
}
