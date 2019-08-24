package br.dev.rodneybarreto.cadusupgeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByCpf(String cpf);

}
