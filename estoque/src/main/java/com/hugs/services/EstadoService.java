package com.hugs.services;

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
import com.hugs.dto.EstadoDTO;
import com.hugs.entities.Estado;
import com.hugs.repositories.EstadoRepository;

@Service
public class EstadoService {
	Logger log = LoggerFactory.getLogger(EstadoService.class);

	@Autowired
	EstadoRepository repository;
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${api.host.uri}")
	String pathLocalHost;
	
	public Estado save(EstadoDTO dto) {
		Estado estado = new Estado(dto);

		return save(estado);
	}

	public List<Estado> saveAll(List<Estado> list) {
		return repository.saveAll(list);
	}

	public Estado getById(Long id) {
		return repository.getOne(id);
	}

	public List<Estado> getListAll(){
		return repository.findAll();
	}

	public Map<Long, Estado> getMapAll(){
		return getListAll().stream().collect(Collectors.toMap(Estado::getId, estado -> estado));
	}
	
	public Estado save(Estado obj) {
		Estado result = repository.save(obj);

		return result;

	}

	public List<Estado> readAllFromFeign() throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String response= "";
		
		response= restTemplate.getForObject(pathLocalHost+"/ibge/estados", String.class);
		List<Estado> estados = mapper.readValue(response, new TypeReference<List<Estado>>(){});
		
		return estados;
	}

	public void loadEstadosFromFeignIbge() throws JsonMappingException, JsonProcessingException {
		List<Estado> estados = readAllFromFeign();
		log.info("Estados listados na API");
		
		Map<Long, Estado> mapEstadosBd = getMapAll();
		log.info(mapEstadosBd.size() +"estados listados do BD");
		
		saveAll(estados.parallelStream().filter(x -> Objects.isNull(mapEstadosBd.get(x.getId()))).collect(Collectors.toList()));
		log.info("Estados importados");
	}
}