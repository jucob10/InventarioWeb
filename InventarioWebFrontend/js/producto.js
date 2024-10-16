//Url del Back-End
const url = 'http://localhost:8080/producto/registrar';
document.getElementById("formProducto").addEventListener("submit", function (event) {
    event.preventDefault();
    registroProducto();

});
async function registroProducto() {
    const producto = {
        codigo: document.getElementById('codigo').value,
        nombreProducto: document.getElementById('nombreProducto').value,
        categoria: document.getElementById('categoria').value
    };
    try {
        const response = await fetch(url, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(producto)
        });
        if (response.ok) {
            const data = response.json();
            console.log("Producto registrado correctamente", data);
            alert("Producto registrado correctamente");
            document.getElementById("formProducto").reset();
        } else {
            console.error('Error en la solicitud', response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}


