package com.escalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.ResetToken;
import com.escalab.repo.IResetTokenRepo;
import com.escalab.service.IResetTokenService;

@Service
public class ResetTokenServiceImpl implements IResetTokenService {

	@Autowired
	private IResetTokenRepo resetTokenRepo;
	
	@Override
	public ResetToken findByToken(String token) {
		return resetTokenRepo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		resetTokenRepo.save(token);
		
	}

	@Override
	public void eliminar(ResetToken token) {
		resetTokenRepo.delete(token);
		
	}

}
