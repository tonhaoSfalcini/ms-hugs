package com.hugs.services;

import org.springframework.stereotype.Service;

@Service
public class CidadeService {
	
//	public Cidade convertDtoToEntity(CidadeIbgeDTO dto) {
//		Cidade cidade = new Cidade(	dto.getId(), 
//									dto.getNome(), 
//									dto.getMicrorregiao().getMesorregiao().getUF());	
//		
//		return cidade;
//	}
//	
//	public CidadeIbgeDTO  convertEntityToDto(Cidade cidade) {
//		CidadeIbgeDTO dto = new CidadeIbgeDTO(	cidade.getId(), 
//												cidade.getNome(),
//												new MicrorregiaoDTO(null, null, 
//														new MesorregiaoDTO(null, null, cidade.getEstado())));
//		
//		return dto;
//	}
}
