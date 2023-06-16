package br.com.divMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.divMaster.dto.SignupRequest;
import br.com.divMaster.dto.UsuarioDto;
import br.com.divMaster.serviceJwt.AuthService;

@RestController
@RequestMapping("/signup")
public class SignupController {

	@Autowired
	private AuthService authService;

	@PostMapping
	public ResponseEntity<?> signupUser(@RequestBody SignupRequest request) {
		UsuarioDto usuarioDto = authService.createUser(request);
		if(usuarioDto == null) {
			return new ResponseEntity<>("Usuário não Foi Criado Tente Mais Tarde!", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(usuarioDto, HttpStatus.CREATED);
	}
}
