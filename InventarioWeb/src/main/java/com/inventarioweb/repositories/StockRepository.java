package com.inventarioweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.StockModel;

@Repository
public interface StockRepository extends JpaRepository<StockModel, Long>{
	// Consultar base datos por nombre de producto existente
	StockModel findByProductoStock(String productoStock); 
}
