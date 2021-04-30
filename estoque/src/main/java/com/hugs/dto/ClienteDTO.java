package com.hugs.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.hugs.entities.Endereco;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ClienteDTO {

	private Long id;

	@NotNull
	@Size(min = 11, max = 14)
	private String cpfCnpj;
	private String nomeRazaoSocial;
	
	@Size(min = 2, max = 2)
	private String tipoPessoa;
	
	@Past
	private LocalDate dataNascimentoConstituicao;
	
	@Email
	private String email;
	private Endereco endereco_1;
	private Endereco endereco_2;
	private Endereco endereco_3;
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