package com.hugs.services;

import org.springframework.stereotype.Service;

import com.hugs.dto.CidadeIbgeDTO;
import com.hugs.dto.MesorregiaoIbgeDto;
import com.hugs.dto.MicrorregiaoIbgeDTO;
import com.hugs.entities.Cidade;

@Service
public class CidadeService {
	
	public Cidade convertDtoToEntity(CidadeIbgeDTO dto) {
		Cidade cidade = new Cidade(	dto.getId(), 
									dto.getNome(), 
									dto.getMicrorregiao().getMesorregiao().getUF());	
		
		return cidade;
	}
	
	public CidadeIbgeDTO  convertEntityToDto(Cidade cidade) {
		CidadeIbgeDTO dto = new CidadeIbgeDTO(	cidade.getId(), 
												cidade.getNome(),
												new MicrorregiaoIbgeDTO(null, null, 
														new MesorregiaoIbgeDto(null, null, cidade.getEstado())));
		
		return dto;
	}
}
