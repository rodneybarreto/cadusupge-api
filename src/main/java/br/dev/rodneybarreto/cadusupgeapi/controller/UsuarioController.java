package br.dev.rodneybarreto.cadusupgeapi.controller;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioReq;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Usuario;
import br.dev.rodneybarreto.cadusupgeapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping(UsuarioController.RESOURCE)
public class UsuarioController {
	
	protected static final String RESOURCE = "/v1/usuarios";
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(produces= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<UsuarioRes>> listaTodos(@RequestParam(required=false) String nome) {
		List<UsuarioRes> usuarios = null;
		
		if (isEmpty(nome)) {
			usuarios = service.listaTodos();
		} else {
			usuarios = service.listaTodos(nome);
		}
		
		if (isEmpty(usuarios)) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping(value="/cpf/{cpf}", produces= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UsuarioRes> buscaPorCpf(@PathVariable String cpf) {
		
		UsuarioRes usuario = service.buscaPorCpf(cpf);

		if (isEmpty(usuario)) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value="/{id}", produces= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<UsuarioRes> buscaPorId(@PathVariable Integer id) {
	
		UsuarioRes usuario = service.buscaPorId(id);
		
		if (isEmpty(usuario)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@PostMapping(consumes= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adiciona(@RequestBody UsuarioReq usuarioReq, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = service.adiciona(usuarioReq);
		
		if (isEmpty(usuario)) {
			return ResponseEntity.notFound().build();
		}
		
		URI uri = uriBuilder.path(RESOURCE +"/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}", consumes= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> atualiza(@PathVariable Integer id, @RequestBody UsuarioReq usuarioReq) {

		Usuario usuario = service.atualiza(id, usuarioReq);
		
		if (isEmpty(usuario)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<?> remove(@PathVariable Integer id) {
		
		if (service.remove(id)) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
