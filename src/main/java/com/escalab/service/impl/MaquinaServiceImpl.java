package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Maquina;
import com.escalab.repo.IMaquinaRepo;
import com.escalab.service.IMaquinaService;

@Service
public class MaquinaServiceImpl implements IMaquinaService{

	@Autowired
	private IMaquinaRepo maquinaRepo;
	
	@Override
	public Maquina save(Maquina obj) {
		return maquinaRepo.save(obj);
	}

	@Override
	public Maquina update(Maquina obj) {
		return maquinaRepo.save(obj);
	}

	@Override
	public List<Maquina> list() {
		return maquinaRepo.findAll();
	}

	@Override
	public Maquina findById(Integer id) {
		Optional<Maquina> op = maquinaRepo.findById(id);
		return op.isPresent() ? op.get() : new Maquina();
	}

	@Override
	public boolean delete(Integer id) {
		maquinaRepo.deleteById(id);
		return true;
	}

	@Override
	public Page<Maquina> listarPageable(Pageable pageable) {
		return maquinaRepo.findAll(pageable);
	}

}
