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
        const comments = document.getElementById("comments")
        img.src = `${product.image}`
        productName.textContent = product.name
        description.textContent = product.description
        price.textContent= `$${product.price} `
        product.comments.forEach(comment =>{
            comments.innerHTML +=`${comment} <br><br><br>`
        })
    }catch (e){
        console.error(e)
    }
}

window.onload = getData

const comment = document.getElementById("comment")
const commentBtn = document.getElementById("commentBtn")

commentBtn.addEventListener("click",async (e)=>{
    e.preventDefault()
    const errorMessage = document.getElementById("errorMessage")
    errorMessage.textContent = ""
    if (comment.value.trim() === "") {
        errorMessage.textContent = "El campo de comentario no puede estar vacío.";
        return;
    }
    try{
        let res= await fetch(`http://localhost:8080/products/findById/${productId}`)
        if (!res.ok){
            throw new Error("Error al obtener el producto")
        }
        const product = await res.json()
        const com= document.getElementById("comment")
        let response = await fetch( `http://localhost:8080/products/${product.id}/comment`,{
            method:"PUT",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({
                comment: comment.value
            })
        })
        comment.value=""
    }catch (e){
        console.error(e)
    }
})