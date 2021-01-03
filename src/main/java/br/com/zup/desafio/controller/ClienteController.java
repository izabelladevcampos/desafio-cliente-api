package br.com.zup.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.desafio.model.Cliente;
import br.com.zup.desafio.service.ClienteService;
import br.com.zup.desafio.service.exceptions.ConstraintException;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/cliente")
	public ResponseEntity<?> salvarCliente(@Valid @RequestBody Cliente cliente, BindingResult br) {
		if (br.hasErrors())
			throw new ConstraintException(br.getAllErrors().get(0).getDefaultMessage());
		clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
}