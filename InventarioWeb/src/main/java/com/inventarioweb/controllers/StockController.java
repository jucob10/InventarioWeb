package com.inventarioweb.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.inventarioweb.models.StockModel;
import com.inventarioweb.services.StockService;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StockController {
	
	@Autowired
    private StockService stockService;
	
	// Metodo para calcular y guardar el saldo de unidades
	
    @PostMapping("/calcular-saldo")
    public ResponseEntity<String> calcularYGuardarSaldo() {
        stockService.calcularYGuardarSaldo();
        return ResponseEntity.ok("Saldo stock calculado y guardado exitosamente");
    }
    
    // Método para ver lista de productos en stock
   	@GetMapping("/todos")
   	public ResponseEntity<List<StockModel>> obtenerStock (){
   		List<StockModel> stockProductos = stockService.obtenerStock();
           return ResponseEntity.ok(stockProductos);
   	}
}
