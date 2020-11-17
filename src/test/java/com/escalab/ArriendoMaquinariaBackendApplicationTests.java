package com.escalab;

import static org.junit.Assert.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.escalab.model.Usuario;
import com.escalab.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArriendoMaquinariaBackendApplicationTests {
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Test
	public void crearUsuario() {
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("mario@gmail.com");
		us.setPassword(bcrypt.encode("12345"));
		us.setEnabled(true);
		
		Usuario retorno = usuarioRepo.save(us);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
