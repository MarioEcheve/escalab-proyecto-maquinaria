package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Arriendo;
import com.escalab.repo.IArriendoRepo;
import com.escalab.service.IArriendoService;

@Service
public class ArriendoServiceImlp implements IArriendoService{

	@Autowired
	private IArriendoRepo arriendoRepo;
	
	@Override
	public Arriendo save(Arriendo obj) {
		return arriendoRepo.save(obj);
	}

	@Override
	public Arriendo update(Arriendo obj) {
		return arriendoRepo.save(obj);
	}

	@Override
	public List<Arriendo> list() {
		return arriendoRepo.findAll();
	}

	@Override
	public Arriendo findById(Integer id) {
		Optional<Arriendo> op = arriendoRepo.findById(id);
		return op.isPresent() ? op.get() : new Arriendo(); 
	}

	@Override
	public boolean delete(Integer id) {
		arriendoRepo.deleteById(id);
		return true;
	}

}
