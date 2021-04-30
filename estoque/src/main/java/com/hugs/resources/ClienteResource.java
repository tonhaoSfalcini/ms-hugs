package com.hugs.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.entities.Cliente;
import com.hugs.services.ClienteService;

@RestController
@RequestMapping(value = "clients")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;
	
	@PostMapping()
	public ResponseEntity<Cliente> insertCliente(){
		
		Cliente cliente = clienteService.createClient();
		
		return ResponseEntity.ok().body(cliente);
	}
}
