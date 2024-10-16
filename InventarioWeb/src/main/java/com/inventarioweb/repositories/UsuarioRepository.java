package com.inventarioweb.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inventarioweb.models.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {	
// Consultar base datos por nombre de usuario existente
   Optional <UsuarioModel> findByNombreUsuarioAndPassword(String nombreUsuario, String password);    
}
