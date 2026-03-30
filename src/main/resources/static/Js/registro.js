const form = document.getElementById("form")
const name = document.getElementById("username")
const email = document.getElementById("email")
const password = document.getElementById("password")
const confirmPassword = document.getElementById("confirmPassword")
const errors = document.getElementById("errors")

email.addEventListener("input", () => email.setCustomValidity(""))
confirmPassword.addEventListener("input", () => confirmPassword.setCustomValidity(""))
password.addEventListener("input", () => password.setCustomValidity(""))

async function getData() {
    try {
        const res = await fetch(`http://localhost:8080/users`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
                name: name.value,
                email: email.value,
                password: password.value
            })
        })

        if (!res.ok) {
            const error = await res.json()

            if (res.status === 409) {
                errors.textContent = error.message
                errors.style.color = "red"
                return
            }

            if (res.status === 400) {
                errors.textContent = error.message || "Datos inválidos"
                errors.style.color = "red"
                return
            }

            throw new Error("Error inesperado")
        }


        errors.textContent = ""
        alert("Registro exitoso")
        window.location.reload()

    } catch (e) {
        console.error(e)
        errors.textContent = "Error de conexión con el servidor"
        errors.style.color = "red"
    }
}

form.addEventListener("submit", ev => {
    ev.preventDefault()

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/

    if (!emailRegex.test(email.value)) {
        email.setCustomValidity("Ingrese un correo válido")
        email.reportValidity()
        return
    }

    if (!passwordRegex.test(password.value)) {
        password.setCustomValidity("Debe tener mayúscula, número, símbolo y mínimo 8 caracteres")
        password.reportValidity()
        return
    }

    if (password.value !== confirmPassword.value) {
        confirmPassword.setCustomValidity("Las contraseñas no coinciden")
        confirmPassword.reportValidity()
        return
    }

    getData()
})