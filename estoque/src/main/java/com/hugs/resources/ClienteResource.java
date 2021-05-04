package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugs.dto.ClienteDTO;
import com.hugs.dto.EnderecoDTO;
import com.hugs.entities.Cliente;
import com.hugs.services.ClienteService;

@RestController
@RequestMapping(value = "clients")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;


	@PostMapping()
	public ResponseEntity<Cliente> insertCliente(@RequestBody ClienteDTO dto){

		Cliente cliente = clienteService.create(dto);

		return ResponseEntity.ok().body(cliente);
	}
	
	@PutMapping
	public ResponseEntity<Cliente> updateCliente(@RequestParam Long id, @RequestBody ClienteDTO dto){
		
		Cliente cliente = clienteService.create(dto);
		
		return ResponseEntity.ok().body(cliente);
	}

	@PutMapping(value = "/criticalData")
	public ResponseEntity<Cliente> updateDadosCriticos(@RequestParam Long id, @RequestBody ClienteDTO dto){
		
		Cliente cliente = clienteService.updateDadosCriticos(id, dto);
		
		return ResponseEntity.ok().body(cliente);
	}

	@DeleteMapping
	public ResponseEntity<Boolean> desativarCliente(@RequestParam Long id){
		clienteService.desativar(id);
		return ResponseEntity.ok().body(true);
	}
	
	@PatchMapping
	public ResponseEntity<Cliente> adicionaEndereco(@RequestParam Long id, @RequestBody EnderecoDTO dto) throws Exception{
		Cliente c = clienteService.adicionaEndereco(id, dto);
		
		return ResponseEntity.ok().body(c);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		List<Cliente> clients = clienteService.getAll();

		return ResponseEntity.ok().body(clients);
	}




	@GetMapping(value = "/params", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getParamsInsertCliente() throws JsonProcessingException{
		StringBuilder sb = new StringBuilder();
		ObjectMapper obj = new ObjectMapper();
		sb.append(obj.writeValueAsString(new Cliente()));
		
		return ResponseEntity.ok().body(sb.toString());
	}

}
