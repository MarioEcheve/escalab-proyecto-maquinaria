package com.escalab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escalab.model.Maquina;
import com.escalab.service.IMaquinaService;

@RestController
@RequestMapping("/maquina")
public class MaquinaController {
	@Autowired
	private IMaquinaService maquinaService;
	
	//@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<Maquina>> listar() {
		List<Maquina> lista = maquinaService.listar();
		return new ResponseEntity<List<Maquina>>(lista, HttpStatus.OK);
	}
}
