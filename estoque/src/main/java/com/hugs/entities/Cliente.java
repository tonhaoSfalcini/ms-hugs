package com.hugs.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hugs.dto.ClienteDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @Builder @NoArgsConstructor @Getter @Setter 
@Entity(name = "tb_cliente")
public class Cliente {

	@Setter(value = AccessLevel.NONE)
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 14)
	private String cpfCnpj;
	
	private String nomeRazaoSocial;

	private String tipoPessoa;
	
	private LocalDate dataNascimentoConstituicao;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "endereco_1_id")
	@Builder.Default private Endereco endereco_1 = new Endereco();
	
	@ManyToOne
	@JoinColumn(name = "endereco_2_id")
	@Builder.Default
	private Endereco endereco_2 = new Endereco();
	
	@ManyToOne
	@JoinColumn(name = "endereco_3_id")
	@Builder.Default
	private Endereco endereco_3 = new Endereco();;
	
	private String whatsApp;
	
	private String telefone_1;
	
	private String telefone_2;
	
	private String telefone_3;
	
	private Boolean permiteMktWhatsapp;
	
	private Boolean permiteMktSms;
	
	private Boolean permiteMktEmail;
	
	public Cliente(ClienteDTO dto) {
		this.id = dto.getId();
		this.cpfCnpj = dto.getCpfCnpj();
		this.nomeRazaoSocial = dto.getNomeRazaoSocial();
		this.tipoPessoa = dto.getTipoPessoa();
		this.dataNascimentoConstituicao = dto.getDataNascimentoConstituicao();
		this.email = dto.getEmail();
//		this.endereco_1 = new Endereco(dto.getEndereco_1(), null, null, null, null, null, null, null);
//		this.endereco_2 = new Endereco(dto.getEndereco_2(), null, null, null, null, null, null, null);
//		this.endereco_3 = new Endereco(dto.getEndereco_3(), null, null, null, null, null, null, null);
		this.whatsApp = dto.getWhatsApp();
		this.telefone_1 = dto.getTelefone_1();
		this.telefone_2 = dto.getTelefone_2();
		this.telefone_3 = dto.getTelefone_3();
		this.permiteMktWhatsapp = dto.getPermiteMktWhatsapp();
		this.permiteMktSms = dto.getPermiteMktSms();
		this.permiteMktEmail = dto.getPermiteMktEmail();
	}
}