package com.inventarioweb.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.UsuarioModel;
import com.inventarioweb.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;    
	
    // Constructor para inyectar el repositorio
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;    
    }
	
	// Método para ver lista de usuarios
	public List<UsuarioModel> obtenerUsuario(){		
		return usuarioRepository.findAll();		
	}
		
	// Método para Validar usuario para inicio de sesion
	public Optional<UsuarioModel> validarCredenciales(String nombreUsuario, String password) {        
		return usuarioRepository.findByNombreUsuarioAndPassword(nombreUsuario, password);		
	}
	
	// Método para registrar nuevo usuario
	public UsuarioModel guardarUsuario(UsuarioModel usuario) {		
			return usuarioRepository.save(usuario);		
	}
}
