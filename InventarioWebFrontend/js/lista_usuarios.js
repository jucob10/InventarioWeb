//Url del Back-End
const url = 'http://localhost:8080/usuario/todos';
async function obtenerUsuario() {
    try {
        const response = await fetch(url, {
            method: "GET",
            headers: { 
                "Content-Type": "application/json"
            },
        });
        if (response.ok) {
            const data = await response.json();
            const usuarioTable = document.querySelector("#usuarioTable tbody");
            usuarioTable.innerHTML = ""; // Limpiar tabla antes de agregar los nuevos datos

            data.forEach(usuario => {
                const fila = `<tr>
                                <td>${usuario.id}</td>
                                <td>${usuario.nombreUsuario}</td>
                                <td>${usuario.cargo}</td>
                            </tr>`;
                usuarioTable.innerHTML += fila;
            });
        } else {
            console.error('Error en la solicitud', response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

// Botón de actualizar
document.getElementById("btnActualizar").addEventListener("click", obtenerUsuario);
// Botón de actualizar

// Cargar proveedores al iniciar la página
window.onload = obtenerUsuario;


