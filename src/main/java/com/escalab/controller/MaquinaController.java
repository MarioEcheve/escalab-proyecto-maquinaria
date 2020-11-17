package com.escalab.controller;

import java.util.List;
import java.net.URI;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModelNotFoundException;
import com.escalab.model.Maquina;
import com.escalab.service.IMaquinaService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
	
	@GetMapping("/{id}")
	public ResponseEntity<Maquina> listarPorId(@PathVariable("id") Integer id) {
		Maquina maq = maquinaService.findById(id);
		if (maq.getNumeroSerie() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Maquina>(maq, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Maquina> modificar(@Valid @RequestBody Maquina maquina) {
		Maquina maq = maquinaService.update(maquina);
		return new ResponseEntity<Maquina>(maq, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Maquina maq = maquinaService.findById(id);
		if (maq.getNumeroSerie() == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
		}
		maquinaService.delete(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	//nivel 1
	@GetMapping("/pageable")
	public ResponseEntity<Page<Maquina>> listarPageable(Pageable pageable) {
		Page<Maquina> maquina = maquinaService.listarPageable(pageable);
		return new ResponseEntity<Page<Maquina>>(maquina, HttpStatus.OK);
	}
}
