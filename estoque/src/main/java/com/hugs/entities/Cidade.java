package com.hugs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hugs.dto.CidadeIbgeDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
@Entity(name = "tb_cidade")
public class Cidade {

	@Setter(value = AccessLevel.NONE)
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false)
	@Builder.Default private Estado estado = new Estado();
	
	public Cidade(CidadeIbgeDTO dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.estado = new Estado(dto.getMicrorregiao().getMesorregiao().getUF());
	}
}

