const formulario = document.querySelector('form');
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Icpf = document.querySelector(".cpf");

    function carregarUsuarios() {
      fetch("http://localhost:8080/colaboradores")
        .then(response => response.json())
        .then(data => {
            console.log(data); //
          // Seleciona o corpo da tabela
          const tabela = document.querySelector("#tabela-usuarios tbody");
          tabela.innerHTML = ""; // limpa antes de preencher

          // Percorre os registros retornados pelo backend
          data.forEach(usuario => {
            // Cria uma nova linha
            const tr = document.createElement("tr");

            // Adiciona as colunas com os atributos do usuário
           tr.innerHTML = `
              <td>${usuario.id}</td>
              <td>${usuario.cpf}</td>
              <td>${usuario.nome}</td>
              <td>${usuario.email}</td>
`;
            // Anexa a linha na tabela
            tabela.appendChild(tr);
          });
        })
        .catch(error => {
          console.error("Erro ao carregar usuários:", error);
        });
    }
    window.onload = carregarUsuarios;