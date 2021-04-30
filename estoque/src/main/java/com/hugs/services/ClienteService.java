package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.ClienteDTO;
import com.hugs.entities.Cliente;
import com.hugs.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository clienteRepository;

	public Cliente createClient(ClienteDTO dto) {
		Cliente cliente = convertDtoToEntity(dto);
		Cliente response = clienteRepository.save(cliente);
		
		return response;
	}
	
	public List<Cliente> getClients(){
		return clienteRepository.findAll();
	}
	
	public Cliente convertDtoToEntity(ClienteDTO dto) {
		Cliente cliente = new Cliente(	
										null,//	dto.getId(), 
										dto.getCpfCnpj(), 
										dto.getNomeRazaoSocial(),
										dto.getTipoPessoa(),
										dto.getDataNascimentoConstituicao(),
										dto.getEmail(), null, null, null,
										dto.getWhatsApp(),
										dto.getTelefone_1(),
										dto.getTelefone_2(),
										dto.getTelefone_3(),
										dto.getPermiteMktWhatsapp(),
										dto.getPermiteMktSms(),
										dto.getPermiteMktEmail());
		
		return cliente;
	}
	
	public ClienteDTO convertEntityToDto(Cliente cliente) {
		ClienteDTO dto = new ClienteDTO(
//										cliente.getId(), 
										cliente.getCpfCnpj(), 
										cliente.getNomeRazaoSocial(),
										cliente.getTipoPessoa(),
										cliente.getDataNascimentoConstituicao(),
										cliente.getEmail(),
										cliente.getWhatsApp(),
										cliente.getTelefone_1(),
										cliente.getTelefone_2(),
										cliente.getTelefone_3(),
										cliente.getPermiteMktWhatsapp(),
										cliente.getPermiteMktSms(),
										cliente.getPermiteMktEmail());
		
		return dto;
	}
}
