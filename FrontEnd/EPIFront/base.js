function carregarLayoutBase() {
    const header = `
      <div class="header">
        <div class="header-left">
          <button onclick="location.href='/'">Home</button>
        </div>
        <div class="header-right">
          <span class="user-name">João Silva</span>
          <div class="user-icon" title="Perfil">&#128100;</div>
        </div>
      </div>
    `;
  
    const sidebar = `
      <div class="sidebar">
        <div>
          <div class="menu-section">
            <div class="menu-section-title">Cadastros</div>
            <div class="menu-item">Colaborador</div>
            <div class="menu-item">Equipamentos</div>
          </div>
          <div class="menu-section">
            <div class="menu-section-title">Ação</div>
            <div class="menu-item">Controle de EPI</div>
          </div>
          <div class="menu-section">
            <div class="menu-section-title">Relatórios</div>
            <div class="menu-item">Empréstimo</div>
          </div>
          <div class="menu-section">
            <div class="menu-section-title">Configurações</div>
            <div class="menu-item">Perfil</div>
            <div class="menu-item">Sistema</div>
          </div>
        </div>
        <button class="logout-btn">Sair</button>
      </div>
    `;
  
    // Insere o layout na página
    document.body.innerHTML = `
      ${header}
      <div class="layout">
        ${sidebar}
        <div class="content" id="page-content"></div>
      </div>
    `;
  }
  function fecharModal() {
    document.getElementById("modal-confirmacao").style.display = "none";
  }
  function abrirModal() {
    document.getElementById("modal-confirmacao").style.display = "flex";
  }
  document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");
  
    if (form) {
      form.addEventListener("submit", function (e) {
        e.preventDefault(); // só para teste local, remova depois se tiver backend
        abrirModal();
      });
    }
  });
      