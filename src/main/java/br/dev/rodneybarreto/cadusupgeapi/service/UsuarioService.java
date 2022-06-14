package br.dev.rodneybarreto.cadusupgeapi.service;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioReq;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;

import java.util.List;

public interface UsuarioService {
	
	List<UsuarioRes> listaTodos();
	
	List<UsuarioRes> listaTodos(String nome);
	
	UsuarioRes buscaPorCpf(String cpf);
	
	UsuarioRes buscaPorId(Integer id);
	
	Usuario adiciona(UsuarioReq usuarioReq);
	
	Usuario atualiza(Integer id, UsuarioReq usuarioReq);
	
	boolean remove(Integer id);

}
