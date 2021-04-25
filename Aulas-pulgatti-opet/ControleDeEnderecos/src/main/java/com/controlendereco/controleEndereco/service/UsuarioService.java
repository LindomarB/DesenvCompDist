package com.controlendereco.controleEndereco.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.controlendereco.controleEndereco.exception.ResourceNotFoundException;
import com.controlendereco.controleEndereco.model.Usuario;
import com.controlendereco.controleEndereco.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> cadastrarUsuario (Usuario usuario) {
		
		if (usuarioRepository.findByCpf(usuario.getCpf()).isPresent() && usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			
			return null;
		}
		
		return Optional.of(usuarioRepository.save(usuario));
	}
		
	public Usuario EncontrarEndereco(long id) throws ResourceNotFoundException{
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		 if(usuario.isPresent() == false) {
	            throw new ResourceNotFoundException("Usuário de ID: " + id + " não foi encontrado.");
	        }

		 usuario.get().getEndereco();
		 usuarioRepository.save(usuario.get());

	        return usuarioRepository.save(usuario.get());
	    }
}
