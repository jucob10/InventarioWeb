//Url del Back-End
const url = 'http://localhost:8080/usuario/login';


document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault();
    inicioSesion();

});
async function inicioSesion() {

    const login = {
        nombreUsuario: document.getElementById("nombreUsuario").value,
        password: document.getElementById("password").value
    };
    try {
        const response = await fetch(url, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json" 
            },
            body: JSON.stringify(login)
        });


        if (response.ok) {
            // Redirigir a la ventana menu_principal si el login es exitoso
            window.location.href = "menu_principal.html";
        } else {
            alert("Credenciales incorrectas");
        }

    } catch (error) {
        console.error("Error:", error);
        alert("Ocurrió un error en la conexión. Por favor, intenta más tarde.");
    }
}



