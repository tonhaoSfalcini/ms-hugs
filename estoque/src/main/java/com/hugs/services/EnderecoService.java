package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.EnderecoDTO;
import com.hugs.entities.Cidade;
import com.hugs.entities.Endereco;
import com.hugs.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired 
	EnderecoRepository repository;
	
	@Autowired 
	CidadeService cidadeService;

	public Endereco saveEndereco(EnderecoDTO dto) {
		Endereco e = new Endereco(dto);
		Endereco response = repository.save(e);
		
		return response;
	}
	
	public Endereco updateEndereco(Long id, EnderecoDTO dto) {
		Cidade cidade = cidadeService.getById(dto.getCidade());
		Endereco e = repository.getOne(id);
		
		e.setBairro(dto.getBairro());
		e.setCep(dto.getCep());
		e.setCidade(cidade);
		
		Endereco response = repository.save(e);
		
		return response;
	}
	
	public List<Endereco> getAll(){
		return repository.findAll();
	}
	
	
	public Endereco getById(Long id) {
		return repository.getOne(id);
	}
}
