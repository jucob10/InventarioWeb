package com.inventarioweb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.StockModel;
import com.inventarioweb.repositories.EntradaProductoRepository;
import com.inventarioweb.repositories.SalidaProductoRepository;
import com.inventarioweb.repositories.StockRepository;

@Service
public class StockService {
	
	@Autowired
    private EntradaProductoRepository entradaProductoRepository;

    @Autowired
    private SalidaProductoRepository salidaProductoRepository;

    @Autowired
    private StockRepository stockRepository;

    // Metodo para calcular y guardar el saldo de unidades
    public void calcularYGuardarSaldo() {
        List<String> nombresProductos = entradaProductoRepository.findAllDistinctProductNames();
        
        for (String nombreProducto : nombresProductos) {
            int totalEntrada = entradaProductoRepository.sumUnidadesEntradaByNombreProductoE(nombreProducto);
            Integer totalSalida = salidaProductoRepository.sumUnidadesSalidaByNomProductoSalida(nombreProducto);

            int saldo = totalEntrada - (totalSalida != null ? totalSalida : 0);

         // Verificar si el producto ya existe en la tabla stock
            StockModel stockExistente = stockRepository.findByProductoStock(nombreProducto);
            if (stockExistente != null) {
                // Si existe, actualizar el saldo
                stockExistente.setSaldoUnidades(saldo);
                stockRepository.save(stockExistente);
            } else {
                // Si no existe, crear un nuevo registro
                StockModel stockNuevo = new StockModel();
                stockNuevo.setProductoStock(nombreProducto);
                stockNuevo.setSaldoUnidades(saldo);
                stockRepository.save(stockNuevo);
            }
        }
    }
        
    // Método para ver lista de productos en stock
    public List<StockModel> obtenerStock(){		
		return stockRepository.findAll();		
	}
    
    public StockModel obtenerStockPorNombre(String productoStock) {
        return stockRepository.findByProductoStock(productoStock);
    }

}
