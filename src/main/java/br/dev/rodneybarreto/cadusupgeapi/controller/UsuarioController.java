package br.dev.rodneybarreto.cadusupgeapi.controller;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioReq;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;
import br.dev.rodneybarreto.cadusupgeapi.service.UsuarioService;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> busca(@RequestParam(required=false) String cpf) {

		if (!isEmpty(cpf)) {
			UsuarioRes usuario = service.buscaPorCpf(cpf);

			if (!isEmpty(usuario)) {
				return ResponseEntity.ok(usuario);
			}
			return ResponseEntity.noContent().build();
		}
		
		List<UsuarioRes> usuarios = service.listaTodos();
		if (!isEmpty(usuarios)) {
			return ResponseEntity.ok(usuarios);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UsuarioRes> buscaPorId(@PathVariable Integer id) {
	
		UsuarioRes usuario = service.buscaPorId(id);
		if (!isEmpty(usuario)) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adiciona(@RequestBody UsuarioReq usuarioReq, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = service.adiciona(usuarioReq);
		if (!isEmpty(usuario)) {
			URI uri = uriBuilder.path("/v1/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(value="/{id}", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> edita(@PathVariable Integer id, @RequestBody UsuarioReq usuarioReq) {
		
		Usuario usuario = service.edita(id, usuarioReq);
		if (!isEmpty(usuario)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		if (service.remove(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
