package com.inventarioweb.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.EntradaProductoModel;

@Repository
public interface EntradaProductoRepository extends JpaRepository<EntradaProductoModel, Long> {	
	// Consultar base datos por nombre de producto existente
	Optional<EntradaProductoModel> findByNombreProductoE(String nombreProductoE);
	
	// Consultar base datos nombre de productos y traerlos a la lista sin duplicarlos
	@Query("SELECT e.nombreProductoE FROM EntradaProductoModel e GROUP BY e.nombreProductoE")
    List<String> findAllDistinctProductNames();
	
	 // Consulta base datos para sumar las unidades de entrada por nombre de producto
    @Query("SELECT SUM(e.unidadesEntrada) FROM EntradaProductoModel e WHERE e.nombreProductoE = :nombreProductoE")
    int sumUnidadesEntradaByNombreProductoE(@Param("nombreProductoE") String nombreProducto);   
}

