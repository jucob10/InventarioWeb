package com.inventarioweb.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.ProductoModel;
import com.inventarioweb.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    
    // Método para registrar nuevos productos validando que no exista previamente.
    public String registrarProducto(ProductoModel producto) {
        Optional<ProductoModel> productoExistentePorNombre = productoRepository.findByNombreProducto(producto.getNombreProducto());

        if (productoExistentePorNombre.isPresent()) {
            return "Producto ya existe";            
        }
        productoRepository.save(producto);
        return "Producto registrado exitosamente";
    }
    
    // Método para ver lista de productos
    public List<ProductoModel> obtenerProducto(){		
		return productoRepository.findAll();		
	}
    
    //Metodo para validar por nombre de producto
    public Optional<ProductoModel> getProductoByName(String nombreProducto) {
        return productoRepository.findByNombreProducto(nombreProducto);
    }
}