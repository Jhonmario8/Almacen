const form = document.getElementById("form")
const name = document.getElementById("username")
const password = document.getElementById("password")
const errors = document.getElementById("errors")

async function getData() {
    try {
        const res = await fetch(`http://localhost:8080/users/login`, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify({
                name: name.value,
                password: password.value
            })
        })
        if (!res.ok) {
            const error = await res.text()
            errors.textContent = error
            return
        }

        const data = await res.json();
        console.log("Usuario: ", data)
        window.location.href = "../Html/index.html"
    } catch (e) {
        console.error(e)
    }
}

form.addEventListener("submit", e => {
    e.preventDefault()
    getData()
})