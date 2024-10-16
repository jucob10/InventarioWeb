//Url del Back-End
const url = 'http://localhost:8080/proveedor/registrar';
document.getElementById("registroProveedorForm").addEventListener("submit", function (event) {
    event.preventDefault();
    registroProveedor();

});
async function registroProveedor() {

    const proveedor = {
        nombreProveedor: document.getElementById("nombreProveedor").value,
        direccion: document.getElementById("direccion").value,
        pais: document.getElementById("pais").value
    };

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(proveedor)
        });

        if (response.ok) {
            const data = response.json();
            console.log("Provedor registrado correctamente", data);
            alert("Provedor registrado correctamente");
            document.getElementById("registroProveedorForm").reset();
            cargarProveedores();
        } else {
            console.error('Error en la solicitud', response.status);
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}