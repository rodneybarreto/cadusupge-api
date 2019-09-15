package br.dev.rodneybarreto.cadusupgeapi.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.rodneybarreto.cadusupgeapi.controller.dto.FuncaoRes;
import br.dev.rodneybarreto.cadusupgeapi.controller.dto.PapelRes;
import br.dev.rodneybarreto.cadusupgeapi.model.Funcao;
import br.dev.rodneybarreto.cadusupgeapi.repository.FuncaoRepository;
import br.dev.rodneybarreto.cadusupgeapi.service.FuncaoService;

@Service
public class FuncaoServiceImpl implements FuncaoService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private FuncaoRepository repository;

	@Override
	public FuncaoRes buscaPorId(Integer id) {
		logger.info("Buscando função ID: {}", id);
		Optional<Funcao> funcao = repository.findById(id);
		
		if (funcao.isPresent()) {
			Funcao f = funcao.get();
			
			FuncaoRes funcaoRes = new FuncaoRes(f.getId().toString(), f.getNome());
			
			List<PapelRes> papeisRes = f.getPapeis().stream().map(PapelRes::new).collect(Collectors.toList());
			funcaoRes.setPapeis(papeisRes);
			
			return funcaoRes;
		}
		
		return null;
	}

}
