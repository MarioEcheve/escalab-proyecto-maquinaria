package com.escalab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Usuario;
import com.escalab.repo.ILoginRepo;
import com.escalab.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginRepo loginRepo;

	@Override
	public Usuario verificarNombreUsuario(String usuario) throws Exception {
		Usuario us = null;
		try {
			us = loginRepo.verificarNombreUsuario(usuario);
			us = us != null ? us : new Usuario();
		} catch (Exception e) {
			us = new Usuario();
		}
		return us;
	}

	@Override
	public int cambiarClave(String clave, String nombre) throws Exception {
		int rpta = 0;
		try {
			loginRepo.cambiarClave(clave, nombre);
			rpta = 1;
		} catch (Exception e) {
			rpta = 0;
		}
		return rpta;
	}
	

	

}
