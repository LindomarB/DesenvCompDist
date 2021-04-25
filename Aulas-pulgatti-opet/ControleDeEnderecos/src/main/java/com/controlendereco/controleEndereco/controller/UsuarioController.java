package com.controlendereco.controleEndereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.controlendereco.controleEndereco.model.Usuario;
import com.controlendereco.controleEndereco.repository.UsuarioRepository;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
		
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post (@RequestBody Usuario usuario) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
		}catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
