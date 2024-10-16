package com.inventarioweb.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.inventarioweb.models.ProductoModel;
import com.inventarioweb.repositories.ProductoRepository;
import com.inventarioweb.services.ProductoService;

@SpringBootTest
public class ProductoServiceTest {
	 @Mock
	    private ProductoRepository productoRepository;

	    @InjectMocks
	    private ProductoService productoService;

	    @Test
	    public void testRegistrarProducto_NuevoProducto() {
	        // Simular un nuevo producto que no existe
	        ProductoModel producto = new ProductoModel();
	        producto.setNombreProducto("Portatil ASUS");

	        when(productoRepository.findByNombreProducto("Portatil ASUS")).thenReturn(Optional.empty());

	        String resultado = productoService.registrarProducto(producto);
	        assertEquals("Producto registrado exitosamente", resultado);

	        // Verificar que el método save fue llamado
	        verify(productoRepository, times(1)).save(producto);
	    }

	    @Test
	    public void testRegistrarProducto_ProductoExistente() {
	        // Simular un producto existente
	        ProductoModel productoExistente = new ProductoModel();
	        productoExistente.setNombreProducto("Portatil ASUS");

	        when(productoRepository.findByNombreProducto("Portatil ASUS")).thenReturn(Optional.of(productoExistente));

	        // Intentar registrar un producto con el mismo nombre
	        ProductoModel nuevoProducto = new ProductoModel();
	        nuevoProducto.setNombreProducto("Portatil ASUS");

	        String resultado = productoService.registrarProducto(nuevoProducto);
	        assertEquals("Producto ya existe", resultado);

	        // Verificar que el método save no fue llamado
	        verify(productoRepository, times(0)).save(nuevoProducto);
	    }

	    @Test
	    public void testObtenerProducto() {
	        // Simular una lista de productos
	        ProductoModel producto1 = new ProductoModel();
	        producto1.setNombreProducto("Portatil ASUS");

	        ProductoModel producto2 = new ProductoModel();
	        producto2.setNombreProducto("Monitor Kalley");

	        List<ProductoModel> listaProductos = Arrays.asList(producto1, producto2);

	        // Simular el comportamiento del repositorio
	        when(productoRepository.findAll()).thenReturn(listaProductos);

	        // Llamar al método de servicio y verificar el resultado
	        List<ProductoModel> resultado = productoService.obtenerProducto();
	        assertEquals(2, resultado.size());
	        assertEquals("Portatil ASUS", resultado.get(0).getNombreProducto());
	        assertEquals("Monitor Kalley", resultado.get(1).getNombreProducto());
	    }

	    @Test
	    public void testGetProductoByName() {
	        // Simular un producto
	        ProductoModel producto = new ProductoModel();
	        producto.setNombreProducto("Portatil ASUS");

	        // Simular el comportamiento del repositorio
	        when(productoRepository.findByNombreProducto("Portatil ASUS")).thenReturn(Optional.of(producto));

	        // Llamar al método de servicio y verificar el resultado
	        Optional<ProductoModel> resultado = productoService.getProductoByName("Portatil ASUS");
	        assertTrue(resultado.isPresent());
	        assertEquals("Portatil ASUS", resultado.get().getNombreProducto());
	    }
}
