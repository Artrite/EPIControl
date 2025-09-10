const formulario = document.querySelector('form');
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Icpf = document.querySelector(".cpf");

function cadastrar() {

fetch("http://localhost:8080/colaboradores",
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            email: Iemail.value,
            senha: Isenha.value,
            cpf: Icpf.value
        })
    })
    .then(function (res){ console.log(res) })
    .catch(function(res){ console.log(res) });
};

function limpar(){
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Icpf.value = "";
};

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();  
    limpar();  

})
