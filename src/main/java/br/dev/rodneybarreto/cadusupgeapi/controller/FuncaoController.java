package br.dev.rodneybarreto.cadusupgeapi.controller;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.FuncaoRes;
import br.dev.rodneybarreto.cadusupgeapi.service.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.util.ObjectUtils.isEmpty;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping(FuncaoController.RESOURCE)
public class FuncaoController {
	
	protected static final String RESOURCE = "/v1/funcoes";
	
	@Autowired
	private FuncaoService service;
	
	@GetMapping(value="/{id}", produces= APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<FuncaoRes> buscaPorId(@PathVariable Integer id) {
		
		FuncaoRes funcaoRes = service.buscaPorId(id);
		
		if (isEmpty(funcaoRes)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(funcaoRes);
	}

}
