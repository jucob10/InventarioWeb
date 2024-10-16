package com.inventarioweb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventarioweb.models.UsuarioModel;
import com.inventarioweb.services.UsuarioService;

@RestController
@RequestMapping ("/usuario")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UsuarioController {
	
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;    
    }
	
	// Método para obtener todos los usuarios registrados	
 	@GetMapping("/todos")
 	public ResponseEntity<List<UsuarioModel>> obtenerUsuario (){
 		List<UsuarioModel> usuarios = usuarioService.obtenerUsuario();
         return ResponseEntity.ok(usuarios);
 	}
 	
 	// Metodo para registrar usuarios 	
    @PostMapping("/registrar")    
    public UsuarioModel registrarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioService.guardarUsuario(usuario);
    }
	
    // Metodo para Inicio de sesión    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UsuarioModel usuario) {    	
    
    	Optional<UsuarioModel> usuarioEncontrado = usuarioService.validarCredenciales(usuario.getNombreUsuario(), usuario.getPassword());
    	if (usuarioEncontrado.isPresent()) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }     	
    }	
}
