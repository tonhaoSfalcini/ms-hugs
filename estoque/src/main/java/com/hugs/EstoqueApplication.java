package com.hugs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.hugs.entities.UnidadeMedida;
import com.hugs.services.CidadeService;
import com.hugs.services.EstadoService;
import com.hugs.services.UnidadeMedidaService;


@SpringBootApplication
@EnableFeignClients
public class EstoqueApplication implements CommandLineRunner{

	Logger log = LoggerFactory.getLogger(EstoqueApplication.class);

	@Autowired
	CidadeService cidadeService;
	@Autowired
	EstadoService estadoService;
	@Autowired
	UnidadeMedidaService unidadeMedidaService;
	@Autowired
	RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		UnidadeMedida unim_1 = new UnidadeMedida(1L, "Kilograma", "Kg", null);
		UnidadeMedida unim_2 = new UnidadeMedida(1L, "Unidade", "Und", null);
		UnidadeMedida unim_3 = new UnidadeMedida(1L, "Grama", "g", null);
		UnidadeMedida unim_4 = new UnidadeMedida(1L, "Miligrama", "mg", null);
		UnidadeMedida unim_5 = new UnidadeMedida(1L, "Mililitro", "ml", null);
		unidadeMedidaService.saveAll(Arrays.asList(unim_1, unim_2, unim_3, unim_4, unim_5));
		log.info("Unidades de Medida inseridas");

		ObjectMapper mapper = new ObjectMapper();
		String response= "";
		String pathLocalHost = "http://localhost:8001";

		log.info("Começando a importar");

		Map<Long, Estado> mapEstadosBd = estadoService.getAll().stream().collect(Collectors.toMap(Estado::getId, estado -> estado));
		log.info(mapEstadosBd.size() +"estados listados do BD");
		response= restTemplate.getForObject(pathLocalHost+"/ibge/estados", String.class);
		List<Estado> estados = mapper.readValue(response, new TypeReference<List<Estado>>(){});
		log.info("Estados listados");

		estadoService.saveAll(estados.stream().filter(x -> Objects.isNull(mapEstadosBd.get(x.getId()))).collect(Collectors.toList()));

		log.info("Estados importados");

		Map<Long, Cidade> mapCidadesBd = cidadeService.getAll().stream().collect(Collectors.toMap(Cidade::getId, estado -> estado));
		for(Estado estado : estados) {
			log.info(">> Estado "+estado.getSigla());
			
			response= restTemplate.getForObject(pathLocalHost+"/ibge/cidades/estados/"+estado.getId()+"/municipios", String.class);
			List<Cidade> cidades = mapper.readValue(response, new TypeReference<List<Cidade>>(){});
			log.info(cidades.size()+" cidades listadas");

			cidadeService.saveAll(cidades.stream().filter(x -> Objects.isNull(mapCidadesBd.get(x.getId()))).collect(Collectors.toList()));
			
			log.info("Cidades importadas"); 
		}

	}

}
