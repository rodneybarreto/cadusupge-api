package br.dev.rodneybarreto.cadusupgeapi.controller;

import static org.springframework.util.ObjectUtils.isEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.UsuarioRes;
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
	
}
