package com.inventarioweb.controllers;

import java.util.List;
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
import com.inventarioweb.models.SalidaProductoModel;
import com.inventarioweb.services.SalidaProductoService;

@RestController
@RequestMapping("/salida_producto")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SalidaProductoController {
	
	@Autowired
    SalidaProductoService salidaProductoService;
	
	//Metodo para registrar salida de producto
    @PostMapping("/registro")
    public ResponseEntity<String> registrarSalidaProducto(@RequestBody SalidaProductoModel salidaProductoModel) {
    	salidaProductoService.registrarSalida(salidaProductoModel);
        return new ResponseEntity<>("Salida registrada exitosamente.", HttpStatus.CREATED);    	
    }
    
	 // Método para obtener todos los producto registrados como salida	    
   	@GetMapping("/todos")
   	public ResponseEntity<List<SalidaProductoModel>> obtenerSalidaProducto (){
   		List<SalidaProductoModel> salidaProductos = salidaProductoService.obtenerSalidaProducto();
           return ResponseEntity.ok(salidaProductos);
   	}
   	
	 // Método para obtener la sumar las unidades de entrada con el mismo nombre   	
   	/*@GetMapping("info/{nombreProductoE}")
   	public int obtenerUnidadesInventario(@PathVariable String nombreProductoE) {
        return salidaProductoService.sumarUnidadesEntrada(nombreProductoE);
    }*/
   	
   	@GetMapping("saldo/{productoStock}")
   	public ResponseEntity<Double> obtenerSaldoProducto(@PathVariable("productoStock") String productoStock) {
        double saldo = salidaProductoService.obtenerSaldo(productoStock);
        return ResponseEntity.ok(saldo);
    }
   	
   	
}
