package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.EnderecoDTO;
import com.hugs.entities.Endereco;
import com.hugs.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired 
	EnderecoRepository repository;

	public Endereco saveEndereco(EnderecoDTO dto) {
		Endereco cliente = convertDtoToEntity(dto);
		Endereco response = repository.save(cliente);
		
		return response;
	}
	
	public List<Endereco> getClients(){
		return repository.findAll();
	}
	
	public Endereco convertDtoToEntity(EnderecoDTO dto) {
		Endereco cliente = new Endereco(	
										null,//	dto.getId(), 
										dto.getTipoLogradouro(),
										dto.getNomeLogradouro(),
										dto.getNumero(),
										dto.getBairro(),
										null, dto.getCep(),
										dto.getReferencia());
		
		return cliente;
	}
	
	public EnderecoDTO convertEntityToDto(Endereco endereco) {
		EnderecoDTO dto = new EnderecoDTO(
										endereco.getTipoLogradouro(), 
										endereco.getNomeLogradouro(),
										endereco.getNumero(),
										endereco.getBairro(),
										endereco.getCidade().getId(),
										endereco.getCep(),
										endereco.getReferencia());
		
		return dto;
	}
}