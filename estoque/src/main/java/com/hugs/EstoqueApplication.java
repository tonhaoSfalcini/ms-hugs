package com.hugs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugs.entities.Cidade;
import com.hugs.entities.Estado;
import com.hugs.repositories.CidadeRepository;
import com.hugs.repositories.EstadoRepository;

@SpringBootApplication
@EnableFeignClients
public class EstoqueApplication implements CommandLineRunner{

	@Autowired
	CidadeRepository cidadeRep;
	@Autowired
	EstadoRepository estadoRep;

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rest = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		String response= "";
		String pathLocalHost = "http://localhost:8001";

		response= rest.getForObject(pathLocalHost+"/estados", String.class);
		List<Estado> estados = mapper.readValue(response, new TypeReference<List<Estado>>(){});
		for (Estado obj: estados) {
			estadoRep.save(obj);
		}


		response= rest.getForObject(pathLocalHost+"/cidades/municipios", String.class);

		List<Cidade> cidades = mapper.readValue(response, new TypeReference<List<Cidade>>(){});
		for (Cidade obj: cidades) {
			cidadeRep.save(obj);
		}
	}

}
