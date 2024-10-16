package com.inventarioweb.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.inventarioweb.models.ProductoModel;
import com.inventarioweb.services.ProductoService;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ProductoController {

    @Autowired
    ProductoService productoService;
    
    // Método para registrar productos

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarProducto(@RequestBody ProductoModel producto) {
        String resultado = productoService.registrarProducto(producto);
        return ResponseEntity.ok(resultado);
    }
    
    // Método para obtener todos los productos
    
  	@GetMapping("/todos")
  	public ResponseEntity<List<ProductoModel>> obtenerProducto (){
  		List<ProductoModel> productos = productoService.obtenerProducto();
          return ResponseEntity.ok(productos);
  	}
  	
  	// Método para obtener información del producto por su nombre
  	
    @GetMapping("/info/{nombre}")
    public Optional<ProductoModel> getProductoInfo(@PathVariable("nombre") String nombre) {
    	return productoService.getProductoByName(nombre);
    }
    
}