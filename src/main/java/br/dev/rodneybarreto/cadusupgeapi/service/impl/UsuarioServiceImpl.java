package br.dev.rodneybarreto.cadusupgeapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;
import br.dev.rodneybarreto.cadusupgeapi.repository.UsuarioRepository;
import br.dev.rodneybarreto.cadusupgeapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<UsuarioRes> listaTodos() {
		List<Usuario> usuarios = repository.findAll();
		return usuarios.stream().map(UsuarioRes::new).collect(Collectors.toList());
	}

	@Override
	public UsuarioRes buscaPorCpf(String cpf) {
		Optional<Usuario> usuario = repository.findByCpf(cpf);
		if (usuario.isPresent()) {
			return new UsuarioRes(usuario.get());
		}
		return null;
	}

	@Override
	public UsuarioRes buscaPorId(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isPresent()) {
			return new UsuarioRes(usuario.get());
		}
		return null;
	}

}
