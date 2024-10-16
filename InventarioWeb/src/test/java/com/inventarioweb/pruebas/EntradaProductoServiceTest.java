package com.inventarioweb.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventarioweb.models.EntradaProductoModel;
import com.inventarioweb.repositories.EntradaProductoRepository;
import com.inventarioweb.services.EntradaProductoService;

@SpringBootTest
public class EntradaProductoServiceTest {
	
	@Mock
    private EntradaProductoRepository entradaProductoRepository;

    @InjectMocks
    private EntradaProductoService entradaProductoService;

    @Test
    public void testRegistrarEntrada() {
        // Simular un producto de entrada
        EntradaProductoModel entradaProducto = new EntradaProductoModel();
        entradaProducto.setNombreProductoE("Portatil ASUS");
        entradaProducto.setUnidadesEntrada(10);
        
     // Usar ArgumentCaptor para capturar el valor pasado al método save
        ArgumentCaptor<EntradaProductoModel> captor = ArgumentCaptor.forClass(EntradaProductoModel.class);


        // Simular el comportamiento del repositorio
        when(entradaProductoRepository.save(any(EntradaProductoModel.class))).thenReturn(captor.capture());

        // Llamar al método de servicio y verificar que el guardado se realiza correctamente
        entradaProductoService.registrarEntrada(entradaProducto);
        verify(entradaProductoRepository, times(1)).save(captor.capture());

        // Verificar que el objeto capturado tiene los valores esperados
        EntradaProductoModel capturado = captor.getValue();
        assertEquals("Portatil ASUS", capturado.getNombreProductoE());
        assertEquals(10, capturado.getUnidadesEntrada());
    }

    @Test
    public void testObtenerEntradaProducto() {
        // Simular una lista de productos de entrada
        EntradaProductoModel producto1 = new EntradaProductoModel();
        producto1.setNombreProductoE("Portatil ASUS");

        EntradaProductoModel producto2 = new EntradaProductoModel();
        producto2.setNombreProductoE("Monitor Kalley");

        List<EntradaProductoModel> listaProductos = Arrays.asList(producto1, producto2);

        // Simular el comportamiento del repositorio
        when(entradaProductoRepository.findAll()).thenReturn(listaProductos);

        // Llamar al método de servicio y verificar el resultado
        List<EntradaProductoModel> resultado = entradaProductoService.obtenerEntradaProducto();
        assertEquals(2, resultado.size());
        assertEquals("Portatil ASUS", resultado.get(0).getNombreProductoE());
        assertEquals("Monitor Kalley", resultado.get(1).getNombreProductoE());
    }

    @Test
    public void testGetProductoByName() {
        // Simular un producto de entrada
        EntradaProductoModel producto = new EntradaProductoModel();
        producto.setNombreProductoE("Portatil ASUS");

        // Simular el comportamiento del repositorio
        when(entradaProductoRepository.findByNombreProductoE("Portatil ASUS"))
            .thenReturn(Optional.of(producto));

        // Llamar al método de servicio y verificar el resultado
        Optional<EntradaProductoModel> resultado = entradaProductoService.getProductoByName("Portatil ASUS");
        assertTrue(resultado.isPresent());
        assertEquals("Portatil ASUS", resultado.get().getNombreProductoE());
    }

}
