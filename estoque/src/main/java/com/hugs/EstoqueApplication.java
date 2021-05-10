package com.hugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

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
	@Async(value = "taskExecutor")
	public void run(String... args) throws Exception {
		
		unidadeMedidaService.loadInitialData();

		estadoService.loadEstadosFromFeignIbge();
		
		cidadeService.loadCidadesFromFeignIbge();
	}

}
