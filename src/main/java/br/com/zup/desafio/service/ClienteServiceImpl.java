package br.com.zup.desafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.zup.desafio.model.Cliente;
import br.com.zup.desafio.repository.ClienteRepository;
import br.com.zup.desafio.service.exceptions.DataIntegrityException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Cliente salvar(Cliente cliente) {

		try {
			this.validarDados(cliente);

			return clienteRepository.save(cliente);

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Cadastro não realizado!");

		}

	}

	private void validarDados(Cliente cliente) {

		Cliente clienteValido = new Cliente();

		clienteValido = clienteRepository.findByCpf(cliente.getCpf());

		if (clienteValido != null) {
			throw new DataIntegrityException("Já há um registro com o CPF informado!");
		}

		clienteValido = clienteRepository.findByEmail(cliente.getEmail());
		if (clienteValido != null) {
			throw new DataIntegrityException("Já há um registro com o e-mail informado!");
		}

	}

}
