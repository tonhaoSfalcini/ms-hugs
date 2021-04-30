package com.hugs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity(name = "tb_estado")
public class Estado {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer codigoIbge;

	private String nome;
	
}
