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

	public Cliente create(ClienteDTO dto) {
		Cliente cliente = new Cliente(dto);
		Cliente response = clienteRepository.save(cliente);
		
		return response;
	}
	
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
	
}
