package br.dev.rodneybarreto.cadusupgeapi.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioReq;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Funcao;
import br.dev.rodneybarreto.cadusupgeapi.model.Genero;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;
import br.dev.rodneybarreto.cadusupgeapi.repository.FuncaoRepository;
import br.dev.rodneybarreto.cadusupgeapi.repository.UsuarioRepository;
import br.dev.rodneybarreto.cadusupgeapi.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioRes> listaTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioRes::new).collect(Collectors.toList());
	}

	@Override
	public UsuarioRes buscaPorCpf(String cpf) {
		Optional<Usuario> usuario = usuarioRepository.findByCpf(cpf);
		if (usuario.isPresent()) {
			return new UsuarioRes(usuario.get());
		}
		return null;
	}

	@Override
	public UsuarioRes buscaPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return new UsuarioRes(usuario.get());
		}
		return null;
	}

	@Override
	public Usuario adiciona(UsuarioReq usuarioReq) {
		
		Optional<Funcao> funcao = funcaoRepository.findById(Integer.parseInt(usuarioReq.getFuncaoId()));
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioReq.getNome());
		usuario.setCpf(usuarioReq.getCpf());

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNascimento = LocalDate.parse(usuarioReq.getDataNascimento(), dateFormatter);
		usuario.setDataNascimento(dataNascimento);
		
		usuario.setGenero(Genero.valueOf(usuarioReq.getGenero()));
		usuario.setFuncao((funcao.isPresent()) ? funcao.get() : null);
		
		return usuarioRepository.save(usuario);
	}

}
