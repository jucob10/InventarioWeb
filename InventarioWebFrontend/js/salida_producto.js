// Cargar productos y proveedores al cargar la página
addEventListener('DOMContentLoaded', async () => {
    const url = 'http://localhost:8080/entrada_producto/todos';

    try {
        // Obtener entrada de productos
        let responseProducto = await fetch(url);
        let dataProducto = await responseProducto.json();
        let selectProducto = document.getElementById('nomProductoSalida');
        selectProducto.innerHTML = ''; // Limpiar las opciones anteriores

        if (dataProducto.length > 0) {
            dataProducto.forEach(producto => {
                let option = document.createElement('option');
                option.value = producto.nombreProductoE;
                option.textContent = producto.nombreProductoE;
                selectProducto.appendChild(option);
            });
        } else {
            let option = document.createElement('option');
            option.textContent = 'No hay productos disponibles';
            selectProducto.appendChild(option);
        }
    } catch (error) {
        console.error('Error cargando productos o proveedores:', error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
});

// Mostrar suma unidades al seleccionar producto
document.getElementById('nomProductoSalida').addEventListener('change', async function () {
    let productoStock = this.value;
    try {
        let response = await fetch(`http://localhost:8080/salida_producto/saldo/${productoStock}`);
        let data = await response.json();
        document.getElementById('unidadesInventario').value = data;
        document.getElementById('unidadesSalida').value = '';
    } catch (error) {
        console.error('Error al obtener la información del producto:', error);
    }
});

// No permitir que las unidades salida sean mayores a las unidades Inventario
document.getElementById('unidadesSalida').addEventListener('input', function () {
    let unidadesInventario = parseInt(document.getElementById('unidadesInventario').value);
    let unidadesSalida = parseInt(this.value);

    // Si las unidades de salida son mayores a las unidades Inventario, muestra un error y vacía el campo
    if (unidadesSalida > unidadesInventario) {
        alert('Error: Las unidades de salida no pueden ser mayores que las unidades Inventario.');
        this.value = ''; // Vacía el campo "unidadesSalida"
    }
});
const url2 = 'http://localhost:8080/salida_producto/registro';
document.getElementById("registroSalida").addEventListener('click', function (event) {
    event.preventDefault();
    registroSalida();

});
async function registroSalida() {
    const formData = {
        nomProductoSalida: document.getElementById('nomProductoSalida').value,
        unidadesInventario: document.getElementById('unidadesInventario').value,
        unidadesSalida: document.getElementById('unidadesSalida').value,
        tipoMovimiento: document.getElementById('tipoMovimiento').value,
    };
    try {
        const response = await fetch(url2, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(formData)
        });
        if (response.ok) {
            const data = response.json();
            console.log("Salida registrada exitosamente", data);
            alert("Salida registrada exitosamente");
            document.getElementById("formSalida").reset();
            cargarSalidaProducto();
        } else {
            console.error('Error en la solicitud', response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

const url3 = 'http://localhost:8080/salida_producto/todos';
async function cargarSalidaProducto() {

    try {
        const response = await fetch(url3, {
            method: "GET",
            headers: { 
                "Content-Type": "application/json" 
            },
        });
        if (response.ok) {
            const data = await response.json();
            const tabla = document.querySelector("#salidaProductoTable tbody");
            tabla.innerHTML = ""; // Limpiar tabla antes de agregar los nuevos datos            
            data.forEach(formData => {
                const fila = `<tr>
                                <td>${formData.id}</td>
                                <td>${formData.nomProductoSalida}</td>
                                <td>${formData.unidadesInventario}</td>
                                <td>${formData.unidadesSalida}</td>
                                <td>${formData.tipoMovimiento}</td>
                            </tr>`;
                tabla.innerHTML += fila;
            });
        } else {
            console.error('Error en la solicitud', response.status);
            alert("Error al cargar salida productos. Código de estado: " + response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}
//Botón de actualizar
document.getElementById("btnActualizar").addEventListener("click", cargarSalidaProducto);
//Botón de actualizar

// Cargar proveedores al iniciar la página
window.onload = cargarSalidaProducto;
