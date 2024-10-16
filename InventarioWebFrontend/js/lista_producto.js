const url = 'http://localhost:8080/producto/todos';
async function obtenerProducto() {

    try {
        const response = await fetch(url, {
            method: "GET",
            headers: { 
                "Content-Type": "application/json"
            },
        });
        if (response.ok) {
            console.log("Solicitud GET exitosa");
            const data = await response.json();
            console.log("Datos recibidos:", data);
            const productoTable = document.querySelector("#productoTable tbody");
            productoTable.innerHTML = ""; // Limpiar tabla antes de agregar los nuevos datos            
            data.forEach(producto => {
                const fila = `<tr>
                                <td>${producto.datId}</td>
                                <td>${producto.codigo}</td>
                                <td>${producto.nombreProducto}</td>
                                <td>${producto.categoria}</td>
                            </tr>`;
                productoTable.innerHTML += fila;
            });
        } else {
            console.error('Error en la solicitud', response.status);
            alert("Error al cargar productos. Código de estado: " + response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}
// Botón de actualizar
document.getElementById("btnActualizar").addEventListener("click", obtenerProducto);
// Botón de actualizar

// Cargar proveedores al iniciar la página
window.onload = obtenerProducto;