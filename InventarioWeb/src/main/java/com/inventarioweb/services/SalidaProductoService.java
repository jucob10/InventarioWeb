package com.inventarioweb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.SalidaProductoModel;
import com.inventarioweb.models.StockModel;
import com.inventarioweb.repositories.SalidaProductoRepository;

@Service
public class SalidaProductoService {
	
	@Autowired
    private SalidaProductoRepository salidaProductoRepository;
	
	@Autowired
    private StockService stockService; 
    
    public void registrarSalida(SalidaProductoModel salidaProductoModel) {

    	SalidaProductoModel salidaProducto = new SalidaProductoModel();
    	salidaProducto.setNomProductoSalida(salidaProductoModel.getNomProductoSalida()); 
    	salidaProducto.setUnidadesInventario(salidaProductoModel.getUnidadesInventario());
    	salidaProducto.setUnidadesSalida(salidaProductoModel.getUnidadesSalida());
    	salidaProducto.setTipoMovimiento(salidaProductoModel.getTipoMovimiento()); 
        
    	salidaProductoRepository.save(salidaProducto);
    }
    
 // Método para ver lista salida productos
    public List<SalidaProductoModel> obtenerSalidaProducto(){		
		return salidaProductoRepository.findAll();		
	}    
    
    public double obtenerSaldo(String productoStock) {
        StockModel stock = stockService.obtenerStockPorNombre(productoStock);
        return stock != null ? stock.getSaldoUnidades() : 0.0;
    }
    
}
