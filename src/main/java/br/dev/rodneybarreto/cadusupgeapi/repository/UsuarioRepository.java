package br.dev.rodneybarreto.cadusupgeapi.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByCpf(String cpf);
	
	@Query(value="select * from usuario u where upper(u.nome) like upper('%'|| :pNome ||'%')", nativeQuery=true)
	Collection<Usuario> listaTodosPorNome(@Param("pNome") String nome);

}
