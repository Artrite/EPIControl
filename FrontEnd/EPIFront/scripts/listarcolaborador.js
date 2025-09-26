function carregarUsuarios() {
  fetch("http://localhost:8080/colaboradores")
    .then(response => response.json())
    .then(data => {
      console.log(data); 
      const tabela = document.querySelector("#tabela-usuarios tbody");
      tabela.innerHTML = ""; // limpa antes de preencher

      data.forEach(usuario => {
        const tr = document.createElement("tr");

        tr.innerHTML = `
          <td>${usuario.id}</td>
          <td>${usuario.nome}</td>
          <td>${usuario.cpf}</td>
          <td>${usuario.email}</td>
          <td>
            <button class="btn-editar" onclick="editarUsuario(${usuario.id})">✏️</button>
            <button class="btn-excluir" onclick="excluirUsuario(${usuario.id})">🗑️</button>
          </td>
        `;

        tabela.appendChild(tr);
      });
    })
    .catch(error => {
      console.error("Erro ao carregar usuários:", error);
    });
}
function editarUsuario(id) {
 //ainda fazer
}

function excluirUsuario(id) {
  //ainda fazer
  }

window.onload = carregarUsuarios;

