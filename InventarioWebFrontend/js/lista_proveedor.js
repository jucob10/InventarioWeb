const url2 = 'http://localhost:8080/proveedor/todos';
async function cargarProveedores() {

    try {
        const response = await fetch(url2, {
            method: "GET",
            headers: { 
                "Content-Type": "application/json"
            },
        });
        if (response.ok) {
            console.log("Solicitud GET exitosa");
            const data = await response.json();
            console.log("Datos recibidos:", data);
            const Table = document.querySelector("#proveedorTable tbody");
            Table.innerHTML = ""; // Limpiar tabla antes de agregar los nuevos datos            
            data.forEach(proveedor => {
                const fila = `<tr>
                                <td>${proveedor.id}</td>
                                <td>${proveedor.nombreProveedor}</td>
                                <td>${proveedor.direccion}</td>
                                <td>${proveedor.pais}</td>
                            </tr>`;
                Table.innerHTML += fila;
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
// Botón de actualizar
document.getElementById("btnActualizar").addEventListener("click", cargarProveedores);
// Botón de actualizar

// Cargar proveedores al iniciar la página
window.onload = cargarProveedores;


