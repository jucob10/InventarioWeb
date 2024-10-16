package com.inventarioweb.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventarioweb.models.UsuarioModel;
import com.inventarioweb.repositories.UsuarioRepository;
import com.inventarioweb.services.UsuarioService;

@SpringBootTest
public class UsuarioServiceTest {
	
	@Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testObtenerUsuario() {
        // Simular lista de usuarios
        UsuarioModel usuario1 = new UsuarioModel();
        usuario1.setNombreUsuario("Maria");
        
        UsuarioModel usuario2 = new UsuarioModel();
        usuario2.setNombreUsuario("Pedro");

        List<UsuarioModel> listaUsuarios = Arrays.asList(usuario1, usuario2);

        // Simular comportamiento del repositorio
        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        // Llamar al método de servicio y verificar el resultado
        List<UsuarioModel> resultado = usuarioService.obtenerUsuario();
        assertEquals(2, resultado.size());
        assertEquals("Maria", resultado.get(0).getNombreUsuario());
        assertEquals("Pedro", resultado.get(1).getNombreUsuario());
    }

    @Test
    public void testValidarCredenciales() {
        // Simular un usuario válido
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombreUsuario("Maria");
        usuario.setPassword("123");

        // Simular el comportamiento del repositorio
        when(usuarioRepository.findByNombreUsuarioAndPassword("Maria", "123"))
            .thenReturn(Optional.of(usuario));

        // Llamar al método de servicio y verificar el resultado
        Optional<UsuarioModel> resultado = usuarioService.validarCredenciales("Maria", "123");
        assertTrue(resultado.isPresent());
        assertEquals("Maria", resultado.get().getNombreUsuario());
    }

    @Test
    public void testGuardarUsuario() {
        // Simular un usuario a guardar
        UsuarioModel usuario = new UsuarioModel();
        usuario.setNombreUsuario("nuevoUsuario");

        // Simular el comportamiento del repositorio
        when(usuarioRepository.save(any(UsuarioModel.class))).thenReturn(usuario);

        // Llamar al método de servicio y verificar el resultado
        UsuarioModel resultado = usuarioService.guardarUsuario(usuario);
        assertEquals("nuevoUsuario", resultado.getNombreUsuario());
    }

}
