
package com.escalab;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.escalab.model.ResetToken;
import com.escalab.model.Usuario;
import com.escalab.service.ILoginService;
import com.escalab.service.IResetTokenService;
import com.escalab.util.EmailUtil;
import com.escalab.util.Mail;

@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private ILoginService service;
	
	@Autowired
	private IResetTokenService tokenService;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> enviarCorreo(@RequestBody String correo) {
		int rpta = 0;
		try {
			Usuario us = service.verificarNombreUsuario(correo);
			if (us != null && us.getIdUsuario() > 0) {
				
				ResetToken token = new ResetToken();
				token.setToken(UUID.randomUUID().toString());
				token.setUser(us);
				token.setExpiracion(10);
				tokenService.guardar(token);
				
				Mail mail = new Mail();
				mail.setFrom("email.prueba.demo@gmail.com");
				mail.setTo(us.getUsername());
				mail.setSubject("RESTABLECER CONTRASEÑA - ARRIENDO MAQUINARIA");
				
				Map<String, Object> model = new HashMap<>();
				String url = "http://localhost:4200/recuperar/" + token.getToken();
				model.put("user", token.getUser().getUsername());
				model.put("resetUrl", url);
				mail.setModel(model);
				emailUtil.enviarMail(mail);
				rpta = 1;
			}
		} catch(Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
}
