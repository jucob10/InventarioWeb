package com.inventarioweb.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.SalidaProductoModel;

@Repository
public interface SalidaProductoRepository extends JpaRepository<SalidaProductoModel, Long>{
	// Consultar base datos por nombre de producto existente
	Optional<SalidaProductoModel> findByNomProductoSalida(String nomProductoSalida);
	
	// Suma las unidades de salida con el mismo nombre de producto
	@Query("SELECT SUM(s.unidadesSalida) FROM SalidaProductoModel s WHERE s.nomProductoSalida = :nomProductoSalida")
	Integer sumUnidadesSalidaByNomProductoSalida(@Param("nomProductoSalida") String nombreProducto);
}
