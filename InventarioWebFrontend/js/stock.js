const url = 'http://localhost:8080/stock/calcular-saldo';
document.getElementById("registroStock").addEventListener('click', function (event) {
    event.preventDefault();
    calcularSaldo();

});
async function calcularSaldo() {

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
        });
        if (response.ok) {
            alert("Stock exitosamente");
            cargarStock();
        } else {
            console.error('Error en la solicitud', response.status);
            alert("Error al calcular el saldo.");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

const url2 = 'http://localhost:8080/stock/todos';

async function cargarStock() {
    try {
        const response = await fetch(url2, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            },
        });
        if (response.ok) {
            const data = await response.json();
            const tabla = document.querySelector("#stockTable tbody");
            tabla.innerHTML = ""; // Limpiar la tabla antes de agregar los nuevos datos
            data.forEach(formData => {
                const fila = `<tr>
                                <td>${formData.productoStock}</td>
                                <td>${formData.saldoUnidades}</td>
                            </tr>`;
                tabla.innerHTML += fila;
            });
        } else {
            console.error('Error en la solicitud', response.status);
            alert("Error al cargar la tabla stock. Código de estado: " + response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

// Cargar stock al iniciar la página
window.onload = cargarStock;

