package br.dev.rodneybarreto.cadusupgeapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
import br.dev.rodneybarreto.cadusupgeapi.util.StringConverter;

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
		return (usuario.isPresent()) ? new UsuarioRes(usuario.get()) : null;
	}

	@Override
	public UsuarioRes buscaPorId(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return (usuario.isPresent()) ? new UsuarioRes(usuario.get()) : null;
	}

	@Transactional
	@Override
	public Usuario adiciona(UsuarioReq usuarioReq) {
		
		Optional<Funcao> funcao = funcaoRepository.findById(Integer.parseInt(usuarioReq.getFuncaoId()));
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioReq.getNome());
		usuario.setCpf(usuarioReq.getCpf());
		usuario.setDataNascimento(StringConverter.toDate(usuarioReq.getDataNascimento()));
		usuario.setGenero(Genero.valueOf(usuarioReq.getGenero()));
		usuario.setFuncao((funcao.isPresent()) ? funcao.get() : null);
		
		return usuarioRepository.save(usuario);
	}

	@Transactional
	@Override
	public Usuario edita(Integer id, UsuarioReq usuarioReq) {
		
		Optional<Usuario> opt = usuarioRepository.findById(id);
		if (opt.isPresent()) {
		
			Usuario usuario = opt.get();
			usuario.setNome(usuarioReq.getNome());
			usuario.setCpf(usuarioReq.getCpf());
			usuario.setDataNascimento(StringConverter.toDate(usuarioReq.getDataNascimento()));
			usuario.setGenero(Genero.valueOf(usuarioReq.getGenero()));
			usuario.setFuncao(new Funcao(Integer.parseInt(usuarioReq.getFuncaoId())));
			
			return usuario;
		}
		return null;
	}

	@Transactional
	@Override
	public boolean remove(Integer id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			usuarioRepository.delete(usuario.get());
			return true;
		}
		return false;
	}
	
}
