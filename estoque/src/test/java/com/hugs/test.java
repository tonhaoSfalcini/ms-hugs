package com.hugs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hugs.entities.Cliente;

public class test {

	public static void main(String[] args) throws JsonProcessingException {
		Cliente c = new Cliente();
		
		ObjectMapper obj = new ObjectMapper();
		obj.writeValueAsString(c);
	}
}
