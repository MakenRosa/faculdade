fetch(
    "https://raw.githubusercontent.com/LenaLatosinski/cardapio.json/main/cardapio.json"
)
    .then((response) => response.json())
    .then((data) => {
        console.log(data)
        const cardapio = document.getElementById("cardapio")
        data.cardapio.forEach((prato) => {
            const pratoElement = document.createElement("div")
            pratoElement.classList.add("prato")
            pratoElement.innerHTML = `
				<img src="${prato.image}" onerror="this.onerror=null;this.src='https://via.placeholder.com/150';">
				<h2>${prato.name}</h2>
				<p>${prato.description}</p>
				<p>${prato.price}</p>
				<p>${prato.gluten}</p>
				<p>${prato.calories}</p>
				<button>Adicionar ao carrinho</button>
			`
            cardapio.appendChild(pratoElement)
        })
    })
    .catch((error) => console.error(error))
