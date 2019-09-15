package br.dev.rodneybarreto.cadusupgeapi.controller;

import static org.springframework.util.ObjectUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.FuncaoRes;
import br.dev.rodneybarreto.cadusupgeapi.service.FuncaoService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping(FuncaoController.RESOURCE)
public class FuncaoController {
	
	protected static final String RESOURCE = "/v1/funcoes";
	
	@Autowired
	private FuncaoService service;
	
	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<FuncaoRes> buscaPorId(@PathVariable Integer id) {
		
		FuncaoRes funcaoRes = service.buscaPorId(id);
		
		if (!isEmpty(funcaoRes)) {
			return ResponseEntity.ok(funcaoRes);
		}
		
		return ResponseEntity.notFound().build();
	}

}
