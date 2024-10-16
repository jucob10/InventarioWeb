//Url del Back-End
const url = 'http://localhost:8080/usuario/registrar';

document.getElementById("registroUsuarioForm").addEventListener("submit", function (event) {
    event.preventDefault();
    registroUsuario();

});
async function registroUsuario() {

    const usuario = {
        nombreUsuario: document.getElementById("nombreUsuario").value,
        password: document.getElementById("password").value,
        cargo: document.getElementById("cargo").value
    };

    try {
        const response = await fetch(url, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(usuario)
        });

        if (response.ok) {
            const data = response.json();
            console.log("Usuario registrado correctamente", data);
            alert("Usuario registrado correctamente");
            document.getElementById("registroUsuarioForm").reset();
        } else {
            console.error('Error en la solicitud', response.status);
        }

    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}

