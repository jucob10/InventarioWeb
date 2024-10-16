package com.inventarioweb.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
	// Consultar base datos por nombre de producto existente
    Optional<ProductoModel> findByNombreProducto(String nombreProducto);
}