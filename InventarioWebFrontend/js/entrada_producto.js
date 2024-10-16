
// Cargar productos y proveedores al cargar la página
addEventListener('DOMContentLoaded', async () => {
    const url2 = 'http://localhost:8080/producto/todos';
    const url3 = 'http://localhost:8080/proveedor/todos';

    try {
        // Obtener productos
        let responseProducto = await fetch(url2);
        let dataProducto = await responseProducto.json();
        let selectProducto = document.getElementById('nombreProductoE');
        selectProducto.innerHTML = ''; // Limpiar las opciones anteriores

        if (dataProducto.length > 0) {
            dataProducto.forEach(producto => {
                let option = document.createElement('option');
                option.value = producto.nombreProducto;
                option.textContent = producto.nombreProducto;
                selectProducto.appendChild(option);
            });
        } else {
            let option = document.createElement('option');
            option.textContent = 'No hay productos disponibles';
            selectProducto.appendChild(option);
        }

        // Obtener proveedores
        let responseProveedor = await fetch(url3);
        let dataProveedor = await responseProveedor.json();
        let selectProveedor = document.getElementById('nombreProveedor');
        selectProveedor.innerHTML = ''; // Limpiar las opciones anteriores

        if (dataProveedor.length > 0) {
            dataProveedor.forEach(proveedor => {
                let option = document.createElement('option');
                option.value = proveedor.nombreProveedor;
                option.textContent = proveedor.nombreProveedor;
                selectProveedor.appendChild(option);
            });
        } else {
            let option = document.createElement('option');
            option.textContent = 'No hay proveedores disponibles';
            selectProveedor.appendChild(option);
        }
    } catch (error) {
        console.error('Error cargando productos o proveedores:', error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");

    }

});

// Mostrar código y categoría al seleccionar producto
document.getElementById('nombreProductoE').addEventListener('change', async function () {
    let nombreProducto = this.value;
    try {
        let response = await fetch(`http://localhost:8080/producto/info/${nombreProducto}`);
        let data = await response.json();
        document.getElementById('codigoE').value = data.codigo;
        document.getElementById('categoriaE').value = data.categoria;
    } catch (error) {
        console.error('Error al obtener la información del producto:', error);
    }
});

const url4 = 'http://localhost:8080/entrada_producto/registro';
document.getElementById("registroEntrada").addEventListener('click', function (event) {
    event.preventDefault();
    registroEntrada();

});
async function registroEntrada() {
    const formData = {
        nombreProductoE: document.getElementById('nombreProductoE').value,
        codigoE: document.getElementById('codigoE').value,
        categoriaE: document.getElementById('categoriaE').value,
        nombreProveedor: document.getElementById('nombreProveedor').value,
        valorProducto: document.getElementById('valorProducto').value,
        unidadesEntrada: document.getElementById('unidadesEntrada').value,
        tipoMovimiento: document.getElementById('tipoMovimiento').value,
    };
    try {
        const response = await fetch(url4, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(formData)
        });
        if (response.ok) {
            const data = response.json();
            console.log("Entrada registrada exitosamente", data);
            alert("Entrada registrada exitosamente");
            document.getElementById("formEntrada").reset();
            cargarEntradaProducto();
        } else {
            console.error('Error en la solicitud', response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

const url5 = 'http://localhost:8080/entrada_producto/todos';
async function cargarEntradaProducto() {

    try {
        const response = await fetch(url5, {
            method: "GET",
            headers: { 
                "Content-Type": "application/json" 
            },
        });
        if (response.ok) {
            const data = await response.json();
            const tabla = document.querySelector("#entradaProductoTable tbody");
            tabla.innerHTML = ""; // Limpiar tabla antes de agregar los nuevos datos            
            data.forEach(formData => {
                const fila = `<tr>
                                <td>${formData.id}</td>
                                <td>${formData.nombreProductoE}</td>
                                <td>${formData.codigoE}</td>
                                <td>${formData.categoriaE}</td>
                                <td>${formData.nombreProveedor}</td>
                                <td>${formData.valorProducto}</td>
                                <td>${formData.unidadesEntrada}</td>
                                <td>${formData.tipoMovimiento}</td>
                            </tr>`;
                tabla.innerHTML += fila;
            });
        } else {
            console.error('Error en la solicitud', response.status);
            alert("Error al cargar proveedores. Código de estado: " + response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}
//Botón de actualizar
document.getElementById("btnActualizar").addEventListener("click", cargarEntradaProducto);

// Cargar proveedores al iniciar la página
window.onload = cargarEntradaProducto;
