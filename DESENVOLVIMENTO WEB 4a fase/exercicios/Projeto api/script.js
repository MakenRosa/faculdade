let cep = document.querySelector(".pesquisa");
let result = document.querySelector(".result");
let form = document.querySelector(".formulario");

form.addEventListener("submit", (e) => {
    e.preventDefault();
    getApi(cep.value);
});

async function getApi(cep) {
    let response = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
    let data = await response.json();
    if (data.erro) {
        result.innerHTML = `<p>CEP não encontrado</p>`;
    } else {
        console.log(data);
        result.innerHTML = `
        <p>Logradouro: ${data.logradouro}</p>
        <p>Bairro: ${data.bairro}</p>
        <p>Localidade: ${data.localidade}</p>
        <p>UF: ${data.uf}</p>
        <p>DDD: ${data.ddd}</p>`;
        
    }
}

