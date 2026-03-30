const form = document.getElementById("form")
const name = document.getElementById("username")
const password = document.getElementById("password")
const errors = document.getElementById("errors")

name.addEventListener("input", () => errors.textContent = "")
password.addEventListener("input", () => errors.textContent = "")

async function getData() {
    try {

        if (!name.value || !password.value) {
            errors.textContent = "Todos los campos son obligatorios"
            errors.style.color = "red"
            return
        }

        const res = await fetch(`http://localhost:8080/users/login`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                name: name.value,
                password: password.value
            })
        })

        if (!res.ok) {
            let errorMessage = "Error inesperado"

            try {
                const error = await res.json()
                errorMessage = error.message
            } catch {
                errorMessage = await res.text()
            }

            errors.textContent = errorMessage
            errors.style.color = "red"

            console.error(errorMessage)
            return
        }

        const data = await res.json()
        errors.textContent = ""
        console.log("Usuario: ", data)

        window.location.href = "../Html/index.html"

    } catch (e) {
        console.error(e)
        errors.textContent = "Error de conexión con el servidor"
        errors.style.color = "red"
    }
}

form.addEventListener("submit", e => {
    e.preventDefault()
    getData()
})