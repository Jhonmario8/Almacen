const productId = localStorage.getItem("productId")

async function getData() {
    try {
        const res= await fetch(`http://localhost:8080/products/findById/${productId}`)
        if (!res.ok){
            throw new Error("Error al obtener el producto")
        }
        const product = await res.json()

        const img = document.getElementById("product_image")
        const productName = document.getElementById("product_name")
        const description = document.getElementById("product_description")
        const price = document.getElementById("price")

        img.src = `${product.image}`
        productName.textContent = product.name
        description.textContent = product.description
        price.textContent= `$${product.price} `
    }catch (e){
        console.error(e)
    }
}

window.onload = getData
