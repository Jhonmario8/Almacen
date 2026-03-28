const form = document.getElementById("form")
const name = document.getElementById("name")
const email = document.getElementById("email")
const password = document.getElementById("password")
const confirmPassword = document.getElementById("confirmPassword")

email.addEventListener("input", () => email.setCustomValidity(""))
confirmPassword.addEventListener("input", () => confirmPassword.setCustomValidity(""))
password.addEventListener("input", () => password.setCustomValidity(""))

async function getData() {

    try {
        const response = await fetch(`http://localhost:8080/users/existsByEmail/${encodeURIComponent(email.value)}`)
        if (!response.ok && response.status !== 404) {
            throw new Error("Error al validar el usuario")
        }
        const exist = await response.json();
        if (exist) {
            alert("El correo ingresado ya esta en uso")
            return
        }
        const res = await fetch(`http://localhost:8080/users`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                name: name.value,
                email: email.value,
                password: password.value
            })
        })
        if (!res.ok) {
            throw new Error("Error al guardar el usuario")
        }
        alert("Registro Exitoso")
        window.location.reload()

    } catch (e) {
        console.error(e)
    }
}


form.addEventListener("submit", ev => {
    ev.preventDefault()
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).+$/;
    if (!emailRegex.test(email.value)) {
        email.setCustomValidity("Ingrese un correo válido")
        email.reportValidity()
        return
    }
    if (!passwordRegex.test(password.value)) {
        password.setCustomValidity("La contraseña debe tener: una mayuscula, un numero, un simbolo y almenos 8 caracteres")
        password.reportValidity()
        return;
    }

    if (password.value !== confirmPassword.value) {
        confirmPassword.setCustomValidity("Las contraseñas no coinciden")
        confirmPassword.reportValidity()
        return
    }

    getData()
})



