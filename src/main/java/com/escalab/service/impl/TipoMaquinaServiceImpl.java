package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.TipoMaquina;
import com.escalab.repo.ITipoMaquinaRepo;
import com.escalab.service.ITipoMaquinaService;


@Service
public class TipoMaquinaServiceImpl implements ITipoMaquinaService {

	@Autowired
	private ITipoMaquinaRepo tipoMaquinaRepo;
	
	@Override
	public TipoMaquina save(TipoMaquina obj) {
		return tipoMaquinaRepo.save(obj);
	}

	@Override
	public TipoMaquina update(TipoMaquina obj) {
		return tipoMaquinaRepo.save(obj);
	}

	@Override
	public List<TipoMaquina> list() {
		return tipoMaquinaRepo.findAll();
	}

	@Override
	public TipoMaquina findById(Integer id) {
		Optional<TipoMaquina> op = tipoMaquinaRepo.findById(id); 
		return op.isPresent() ? op.get() : new TipoMaquina();
	}

	@Override
	public boolean delete(Integer id) {
		tipoMaquinaRepo.deleteById(id);
		return true;
	}

}
