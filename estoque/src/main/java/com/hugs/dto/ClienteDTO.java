package com.hugs.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hugs.entities.Cliente;

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
	
	@Past(message = "Data de nascimento inválida.")
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimentoConstituicao;
	
	@NotNull
	@Email(message = "Por favor, informe um e-mail válido")
	private String email;
	
	private Long endereco_1;
	private Long endereco_2;
	private Long endereco_3;
	
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
	
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.nomeRazaoSocial = cliente.getNomeRazaoSocial();
		this.tipoPessoa = cliente.getTipoPessoa();
		this.dataNascimentoConstituicao = cliente.getDataNascimentoConstituicao();
		this.email = cliente.getEmail();
		this.endereco_1 = cliente.getEndereco_1().getId();
		this.endereco_2 = cliente.getEndereco_2().getId();
		this.endereco_3 = cliente.getEndereco_3().getId();
		this.whatsApp = cliente.getWhatsApp();
		this.telefone_1 = cliente.getTelefone_1();
		this.telefone_2 = cliente.getTelefone_2();
		this.telefone_3 = cliente.getTelefone_3();
		this.permiteMktWhatsapp = cliente.getPermiteMktWhatsapp();
		this.permiteMktSms = cliente.getPermiteMktSms();
		this.permiteMktEmail = cliente.getPermiteMktEmail();
	}
}
