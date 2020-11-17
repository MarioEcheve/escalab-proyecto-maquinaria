package com.escalab.controller;

import java.util.List;
import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.escalab.model.Maquina;
import com.escalab.service.IMaquinaService;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {
	@Autowired
	private IMaquinaService maquinaService;

	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Maquina>> listar() {
		List<Maquina> lista = maquinaService.list();
		return new ResponseEntity<List<Maquina>>(lista, HttpStatus.OK);
	}

	// nivel 2
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Maquina maquina) {
		Maquina maq = maquinaService.save(maquina);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(maq.getNumeroSerie()).toUri();
		return ResponseEntity.created(location).build();
	}
}
