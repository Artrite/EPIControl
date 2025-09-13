function carregarUsuarios() {
    fetch("http://localhost:8080/equipamento")
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
    alert("Editar usuário com ID " + id);
    // Aqui você pode abrir um modal ou redirecionar para uma página de edição
  }
  
  function excluirUsuario(id) {
    if (confirm("Tem certeza que deseja excluir o usuário com ID " + id + "?")) {
      // Aqui você pode chamar a API para excluir o usuário e recarregar a lista
      alert("Usuário " + id + " excluído (simulado).");
      carregarUsuarios(); // Recarrega a tabela após exclusão
    }
  }
  window.onload = carregarUsuarios;
  
  