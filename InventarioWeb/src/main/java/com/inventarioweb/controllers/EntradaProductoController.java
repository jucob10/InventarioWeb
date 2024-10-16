package com.inventarioweb.controllers;

import java.util.List;
import java.util.Optional;
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
import com.inventarioweb.models.EntradaProductoModel;
import com.inventarioweb.services.EntradaProductoService;

@RestController
@RequestMapping("/entrada_producto")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class EntradaProductoController {

    @Autowired
    private EntradaProductoService entradaProductoService;

    @PostMapping("/registro")
    public ResponseEntity<String> registrarEntradaProducto(@RequestBody EntradaProductoModel entradaProductoModel) {
    	entradaProductoService.registrarEntrada(entradaProductoModel);
        return new ResponseEntity<>("Entrada registrada exitosamente.", HttpStatus.CREATED);    	
    }
    
    // Método para obtener todos los productos
    
   	@GetMapping("/todos")
   	public ResponseEntity<List<EntradaProductoModel>> obtenerEntradaProducto (){
   		List<EntradaProductoModel> entradaProductos = entradaProductoService.obtenerEntradaProducto();
           return ResponseEntity.ok(entradaProductos);
   	}
    
    // Método para obtener información del producto por su nombre
   	
    @GetMapping("/info/{nombreProductoE}")
    public Optional<EntradaProductoModel> getProductoInfo(@PathVariable String nombreProductoE) {
    	return entradaProductoService.getProductoByName(nombreProductoE);
    }
}