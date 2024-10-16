package com.inventarioweb.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventarioweb.models.ProveedorModel;
import com.inventarioweb.repositories.ProveedorRepository;

@Service
public class ProveedorService {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	// Método para registrar proveedor
	public ProveedorModel guardarProveedor(ProveedorModel proveedor) {		
		return proveedorRepository.save(proveedor);	
	}
	
	// Método para ver lista de proveedores
	public List<ProveedorModel> obtenerProveedor(){		
		return proveedorRepository.findAll();		
	}
}
