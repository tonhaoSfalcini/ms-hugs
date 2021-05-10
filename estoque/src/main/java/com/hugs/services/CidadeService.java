package com.hugs.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugs.dto.CidadeIbgeDTO;
import com.hugs.entities.Cidade;
import com.hugs.entities.Estado;
import com.hugs.repositories.CidadeRepository;

@Service
public class CidadeService {

	Logger log = LoggerFactory.getLogger(CidadeService.class);
	
	@Autowired
	CidadeRepository repository;
	@Autowired
	EstadoService estadoService;
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.host.uri}")
	String pathLocalHost;
	
	public Cidade save(CidadeIbgeDTO dto) {
		Cidade cidade = new Cidade(dto);
		
		return save(cidade);
 	}
	
	public Cidade getById(Long id) {
		return repository.getOne(id);
	}
	
	public List<Cidade> getListAll(){
		return repository.findAll();
	}
	
	public Map<Long, Cidade> getMapAll(){
		return getListAll().stream().collect(Collectors.toMap(Cidade::getId, estado -> estado));
	}

	public List<Cidade> findByUfId(Long id) {
		return repository.findByEstadoIdEquals(id);
	}

	public Cidade save(Cidade obj) {

		Cidade result = repository.save(obj);
		
		return result;
	}

	public List<Cidade> saveAll(List<Cidade> obj) {
		
		return repository.saveAll(obj);
	}
	
	public List<Cidade> readAllFromFeignByUf(Estado estado) throws JsonMappingException, JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		String result = restTemplate.getForObject(pathLocalHost+"/ibge/cidades/estados/"+estado.getId()+"/municipios", String.class);
		List<CidadeIbgeDTO> dtoList = mapper.readValue(result, new TypeReference<List<CidadeIbgeDTO>>(){});
		log.info(">> "+estado.getSigla() +" > "+ dtoList.size()+" cidades listadas");
		List<Cidade> cidadesList = new ArrayList<>(); 
		dtoList.parallelStream().forEach(z -> cidadesList.add(new Cidade(z)));
		return cidadesList;
	}

	public void loadCidadesFromFeignIbge() {
		Map<Long, Cidade> mapCidadesBd = getMapAll();
		List<Estado> estados = estadoService.getListAll();
		estados.parallelStream()
		.forEach( x -> {
		log.info(">> "+x.getSigla());
			List<Cidade> cidadesList = null;
			try {
				cidadesList = readAllFromFeignByUf(x);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			log.info(">> "+x.getSigla() +" > "+ cidadesList.size()+" cidades listadas");
			saveAll(cidadesList.parallelStream().filter(y -> Objects.isNull(mapCidadesBd.get(y.getId()))).collect(Collectors.toList()));
			log.info(">> "+x.getSigla() +" > Cidades importadas"); 
	});
	}

}
