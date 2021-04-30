package com.hugs.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hugs.dto.ClienteDTO;
import com.hugs.entities.Cliente;
import com.hugs.services.ClienteService;

@RestController
@RequestMapping(value = "clients")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;
	

	@PostMapping()
	public ResponseEntity<Cliente> insertCliente(@RequestBody ClienteDTO dto){
		
		Cliente cliente = clienteService.createClient(dto);
		
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> getAll(){
		List<Cliente> clients = clienteService.getClients();
		
		return ResponseEntity.ok().body(clients);
	}
	
	
	
	
	
	@GetMapping(value = "/params")
	public ResponseEntity<String> getParamsInsertCliente(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("cpfCnpj").append("\n");
		sb.append("nomeRazaoSocial").append("\n");
		sb.append("tipoPessoa").append("\n");
		sb.append("dataNascimentoConstituicao").append("\n");
		sb.append("email").append("\n");
		sb.append("endereco_1").append("\n");
		sb.append("endereco_2").append("\n");
		sb.append("endereco_3").append("\n");
		sb.append("whatsApp").append("\n");
		sb.append("telefone_1").append("\n");
		sb.append("telefone_2").append("\n");
		sb.append("telefone_3").append("\n");
		sb.append("permiteMktWhatsapp").append("\n");
		sb.append("permiteMktSms").append("\n");
		sb.append("permiteMktEmail");
		
		return ResponseEntity.ok().body(sb.toString());
	}
	
}
