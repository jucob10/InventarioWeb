package com.inventarioweb.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.EntradaProductoModel;
import com.inventarioweb.repositories.EntradaProductoRepository;

@Service
public class EntradaProductoService {

    @Autowired
    private EntradaProductoRepository entradaProductoRepository;
    
    //Metodo para registrar entrada de productos
    public void registrarEntrada(EntradaProductoModel entradaProductoModel) {

    	EntradaProductoModel entradaProducto = new EntradaProductoModel();
        entradaProducto.setNombreProductoE(entradaProductoModel.getNombreProductoE());
        entradaProducto.setCodigoE(entradaProductoModel.getCodigoE());  
        entradaProducto.setCategoriaE(entradaProductoModel.getCategoriaE());  
        entradaProducto.setNombreProveedor(entradaProductoModel.getNombreProveedor());
        entradaProducto.setValorProducto(entradaProductoModel.getValorProducto());
        entradaProducto.setUnidadesEntrada(entradaProductoModel.getUnidadesEntrada());
        entradaProducto.setTipoMovimiento(entradaProductoModel.getTipoMovimiento());   
        
        entradaProductoRepository.save(entradaProducto);
    }
    
    
    // Método para ver lista de productos
    public List<EntradaProductoModel> obtenerEntradaProducto(){		
		return entradaProductoRepository.findAll();		
	}
    
    //Metodo para obtener nombre de producto registrado previamente en producto
    public Optional<EntradaProductoModel> getProductoByName(String nombreProductoE) {
        return entradaProductoRepository.findByNombreProductoE(nombreProductoE);
    }
}
