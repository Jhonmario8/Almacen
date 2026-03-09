async function getData(){
    try{
        let res= await fetch("http://localhost:8080/products/All")
        if (!res.ok){
            throw new Error("Error al obtener los productos")
        }
        let json= await res.json()

        let galery = document.getElementById("gal")
        json.forEach(product=>{
            const div= document.createElement("div")
            div.innerHTML=`<div><img src="${product.image}" class="imagenes"></div>
            <p >${product.name} </p>`
            const p = document.createElement("p")
            p.className="boton"
            p.textContent= "Ver Producto"
            p.addEventListener("click",() =>{
                localStorage.setItem("productId",product.id)
                window.location.href = "../Html/unique.html"
            })
            div.appendChild(p)
            galery.appendChild(div)
        })
    }catch (e){
        console.error(e)
    }
}
document.addEventListener("DOMContentLoaded",getData)