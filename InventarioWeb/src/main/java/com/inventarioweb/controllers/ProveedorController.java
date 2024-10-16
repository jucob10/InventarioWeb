package com.inventarioweb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventarioweb.models.ProveedorModel;
import com.inventarioweb.services.ProveedorService;

@RestController
@RequestMapping ("/proveedor")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProveedorController {
	
	@Autowired
	ProveedorService proveedorService;	
	
	// Método para registrar un proveedor	
	@PostMapping("/registrar")    
	public ProveedorModel registrarProveedor(@RequestBody ProveedorModel proveedor) {
		return this.proveedorService.guardarProveedor(proveedor);
    }
	
	// Método para obtener todos los proveedores	
	@GetMapping("/todos")
	public ResponseEntity<List<ProveedorModel>> obtenerProveedor (){
		List<ProveedorModel> proveedores = proveedorService.obtenerProveedor();
        return ResponseEntity.ok(proveedores);
	}
}
