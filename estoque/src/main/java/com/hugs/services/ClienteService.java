package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.ClienteDTO;
import com.hugs.dto.EnderecoDTO;
import com.hugs.entities.Cliente;
import com.hugs.entities.Endereco;
import com.hugs.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository repository;
	
	@Autowired 
	EnderecoService enderecoService;

	public Cliente create(ClienteDTO dto) {
		Cliente cliente = new Cliente(dto);
		Cliente response = repository.save(cliente);
		
		return response;
	}
	
	public Cliente updateDadosCriticos(Long id, ClienteDTO dto) {
		Cliente c = repository.getOne(id);
		c.setCpfCnpj(dto.getCpfCnpj());
		c.setNomeRazaoSocial(dto.getNomeRazaoSocial());
		c.setDataNascimentoConstituicao(dto.getDataNascimentoConstituicao());
		c.setEmail(dto.getEmail());
		
		Cliente response = repository.save(c);
		
		return response;
	}
	
	public Cliente update(Long id, ClienteDTO dto) {
		Cliente c = repository.getOne(id);
		c.setWhatsApp(dto.getWhatsApp());
		c.setTelefone_1(dto.getTelefone_1());
		c.setTelefone_2(dto.getTelefone_2());
		c.setTelefone_3(dto.getTelefone_3());
		c.setPermiteMktEmail(dto.getPermiteMktEmail());
		c.setPermiteMktSms(dto.getPermiteMktSms());
		c.setPermiteMktWhatsapp(dto.getPermiteMktWhatsapp());
		
		Cliente response = repository.save(c);
		
		return response;
	}
	
	public void desativar(Long id) {
		Cliente c = repository.getOne(id);
		//não temos nada pra desativar o cliente ainda kkkkkkkk
		repository.save(c);
	}
	
	public List<Cliente> getAll(){
		return repository.findAll();
	}

	public Cliente adicionaEndereco(Long id, EnderecoDTO dto) throws Exception {
		Endereco e = null;
		if(dto.getId() != null) {
			e = enderecoService.getById(dto.getId());
		}else {
			e = enderecoService.saveEndereco(dto);
		}
		
		Cliente c = repository.getOne(id);
		if(c.getEndereco_1() == null || c.getEndereco_1().getId() == null) {
			c.setEndereco_1(e);
		}else if(c.getEndereco_2() == null || c.getEndereco_2().getId() == null) {
			c.setEndereco_2(e);
		}else if(c.getEndereco_3() == null || c.getEndereco_3().getId() == null) {
			c.setEndereco_3(e);
		}else {
			throw new Exception("esse cliente já tem todos os endereços preenchidos, precisamos fazer algo a respeito.");
		}
		
		return null;
	}
	
	public Cliente getById(Long id) {
		return repository.getOne(id);
	}
	
}
