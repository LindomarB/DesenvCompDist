package com.controlendereco.controleEndereco.controller;



import javax.naming.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controlendereco.controleEndereco.exception.ResourceNotFoundException;
import com.controlendereco.controleEndereco.model.Endereco;
import com.controlendereco.controleEndereco.model.Usuario;
import com.controlendereco.controleEndereco.repository.EnderecoRepository;
import com.controlendereco.controleEndereco.service.UsuarioService;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Endereco> post (@RequestBody Endereco endereco) {
	
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(enderecoRepository.save(endereco));
		}catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/idusuario/{id}")
    public ResponseEntity <Usuario> getAllEnderecos(@PathVariable long id) throws ResourceNotFoundException {
			return ResponseEntity.ok(usuarioService.EncontrarEndereco(id));
    }
}
