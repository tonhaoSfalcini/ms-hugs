package com.hugs.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ClienteDTO {

//	private Long id;

	@NotNull
	@Size(min = 11, max = 14)
	private String cpfCnpj;
	private String nomeRazaoSocial;
	
	@Size(min = 2, max = 2)
	private String tipoPessoa;
	
	@Past(message = "Data de nascimento inválida.")
	private LocalDate dataNascimentoConstituicao;
	
	@NotNull
	@Email(message = "Por favor, informe um e-mail válido")
	private String email;
	private String whatsApp;
	
	@Size(min = 8, max = 12)
	private String telefone_1;
	
	@Size(min = 8, max = 12)
	private String telefone_2;
	
	@Size(min = 8, max = 12)
	private String telefone_3;
	private Boolean permiteMktWhatsapp;
	private Boolean permiteMktSms;
	private Boolean permiteMktEmail;
	
}
