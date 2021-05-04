package com.hugs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hugs.dto.ProdutoDTO;
import com.hugs.entities.Produto;
import com.hugs.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired 
	ProdutoRepository produtoRepository;

	public Produto create(ProdutoDTO dto) {
		Produto cliente = new Produto(dto);
		Produto response = produtoRepository.save(cliente);
		
		return response;
	}
	
	public List<Produto> getAll(){
		return produtoRepository.findAll();
	}
	
}
