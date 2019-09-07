package br.dev.rodneybarreto.cadusupgeapi;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.dev.rodneybarreto.cadusupgeapi.controller.UsuarioController;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Genero;
import br.dev.rodneybarreto.cadusupgeapi.service.UsuarioService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UsuarioControllerTest {

	private MockMvc mvc;
	
	private UsuarioRes usuario;
	private List<UsuarioRes> usuarios;
	
	@Mock
	private UsuarioService service;
	
	@InjectMocks
	private UsuarioController controller;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		UsuarioRes u1 = new UsuarioRes();
		u1.setId("1");
		u1.setNome("Cláudia Leite");
		u1.setCpf("11111111111");
		u1.setDataNascimento("02/07/1999");
		u1.setGenero(Genero.FEMININO.toString());
		u1.setFuncao("ADMINISTRADOR");
		
		usuario = u1;
		
		UsuarioRes u2 = new UsuarioRes();
		u2.setId("2");
		u2.setNome("Beth Carvalho");
		u2.setCpf("22222222222");
		u2.setDataNascimento("15/04/1947");
		u2.setGenero(Genero.FEMININO.toString());
		u2.setFuncao("USUARIO_COMUM");
		
		usuarios = Arrays.asList(u1, u2);
	}
	
	@Test
	public void deveRetornarAListaDeUsuarios() throws Exception {
		
		when(service.listaTodos()).thenReturn(usuarios);
		
		mvc.perform(get("/v1/usuarios").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json; charset=UTF-8"))
			.andExpect(jsonPath("$[1].cpf").value("22222222222"))
			.andDo(print());
	}
	
	@Test
	public void deveBuscarOUsuarioPorSeuCpf() throws Exception {
		
		when(service.buscaPorCpf(any(String.class))).thenReturn(usuario);
		
		mvc.perform(get("/v1/usuarios/cpf/11111111111").accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType("application/json; charset=UTF-8"))
			.andExpect(jsonPath("$.nome").value("Cláudia Leite"))
			.andDo(print());
	}
	
}
