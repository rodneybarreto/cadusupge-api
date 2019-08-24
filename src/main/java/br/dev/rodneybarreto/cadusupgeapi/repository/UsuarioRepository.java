package br.dev.rodneybarreto.cadusupgeapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByCpf(String cpf);

}
