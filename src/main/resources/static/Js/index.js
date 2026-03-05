async function getData(){
    try{
        let res = await fetch("http://localhost:8080/products/findAll");
        if (!res.ok){
            throw new Error("Error al obtener los productos")
        }
        let json=await res.json()
        console.log("Productos recibidos:", json);

        const prods=document.getElementById("products")
        const com = [...json].sort(()=>0.5 - Math.random())
        for (let i = 0; i < 2; i++) {

            const product = com[i]
            let art= document.createElement("article")

            art.innerHTML=`<div><img src="${product.image}" class="imagenes"></div>
            <p >${product.name} </p>`
            const p = document.createElement("p")
            p.className="boton"
            p.textContent= "Ver Producto"
            p.addEventListener("click",() =>{
                localStorage.setItem("productId",product.id)
                window.location.href = "../Html/unique.html"
            })
            art.appendChild(p)
            prods.appendChild(art)
        }
    }catch (e){
        console.error(e);
    }
}
document.addEventListener("DOMContentLoaded",getData)
