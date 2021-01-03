
package br.com.zup.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.zup.desafio.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByCpf(String cpf);

	public Cliente findByEmail(String email);

}
