package com.escalab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Maquina update(Maquina obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Maquina> listar() {
		// TODO Auto-generated method stub
		return maquinaRepo.findAll();
	}

	@Override
	public Maquina findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
