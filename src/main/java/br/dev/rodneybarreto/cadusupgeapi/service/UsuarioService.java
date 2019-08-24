package br.dev.rodneybarreto.cadusupgeapi.service;

import java.util.List;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;

public interface UsuarioService {
	
	List<UsuarioRes> listaTodos();
	
	UsuarioRes buscaPorCpf(String cpf);
	
	UsuarioRes buscaPorId(Integer id);

}
