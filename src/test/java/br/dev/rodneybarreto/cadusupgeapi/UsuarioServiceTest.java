package br.dev.rodneybarreto.cadusupgeapi;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.helper.DateHelper;
import br.dev.rodneybarreto.cadusupgeapi.model.Funcao;
import br.dev.rodneybarreto.cadusupgeapi.model.Genero;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;
import br.dev.rodneybarreto.cadusupgeapi.repository.UsuarioRepository;
import br.dev.rodneybarreto.cadusupgeapi.service.impl.UsuarioServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class UsuarioServiceTest {

	protected Optional<Usuario> usuario;
	
	@Mock
	private UsuarioRepository repository;
	
	@InjectMocks
	private UsuarioServiceImpl service;
	
	@Before
	public void init() {
		Usuario u = new Usuario();
		u.setId(1);
		u.setNome("Cláudia Leite");
		u.setCpf("11111111111");
		u.setDataNascimento(DateHelper.toDate("02/07/1999"));
		u.setGenero(Genero.FEMININO);
		
		Funcao funcao = new Funcao(1);
		u.setFuncao(funcao);
		
		this.usuario = Optional.of(u);
	}
	
	@Test
	public void deveBuscarOUsuarioPorSeuCpf() {
		String cpf = "11111111111";

		when(repository.findByCpf(any(String.class))).thenReturn(usuario);
		
		UsuarioRes usuarioRetornado = service.buscaPorCpf(cpf);
		
		assertEquals("Cláudia Leite", usuarioRetornado.getNome());
		verify(repository, times(1)).findByCpf(cpf);
	}

	@Test
	public void deveBuscarOUsuarioPorId() {
		Integer id = 1;

		when(repository.findById(any(Integer.class))).thenReturn(usuario);

		UsuarioRes usuarioRetornado = service.buscaPorId(id);

		assertEquals("111.111.111-11", usuarioRetornado.getCpf());
		verify(repository, times(1)).findById(id);
	}

}
