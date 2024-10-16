package com.inventarioweb.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.ProveedorModel;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorModel, Long> {
	// Consultar base datos por nombre de proveedor existente
    Optional<ProveedorModel> findByNombreProveedor(String nombreProveedor);
}
