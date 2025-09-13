# EPIControl

Passos para executar o EPIControl usando SpringBoot

//Clone o repositório
git clone <https://github.com/Artrite/EPIControl.git>
cd EPIControl-main

//Crie o Banco Mysql
CREATE TABLE Colaborador 
( 
 id_colaborador INT PRIMARY KEY,  
 cpf_colaborador INT,  
 nome_colaborador INT,  
 idade_colaborador INT,  
); 

CREATE TABLE Usuario 
( 
 id_usuario INT PRIMARY KEY,  
 cpf_usuario INT,  
 nome_usuario INT,  
 senha_usuario INT,  
 idade_usuario INT,  
); 

CREATE TABLE Equipamento 
( 
 id_equipamento INT PRIMARY KEY,  
 nome_equipamento INT,  
 descricao_equipamento INT,  
 tipo_equipamento INT,  
 quantidade_equipamento INT,  
); 

CREATE TABLE Emprestimo 
( 
 data_emprestimo INT,  
 fk_id_usuario INT,  
 fk_id_colaborador INT,  
 fk_id_equipamento INT,  
 id_emprestimo INT PRIMARY KEY,  
 idColaborador INT,  
); 

CREATE TABLE Realizando 
( 
 id_emprestimo INT PRIMARY KEY,  
 id_usuario INT PRIMARY KEY,  
); 

CREATE TABLE Rel 
( 
 id_equipamento INT PRIMARY KEY,  
 id_emprestimo INT PRIMARY KEY,  
); 

ALTER TABLE Emprestimo ADD FOREIGN KEY(idColaborador) REFERENCES Colaborador (idColaborador)
ALTER TABLE Realizando ADD FOREIGN KEY(id_emprestimo) REFERENCES Emprestimo (id_emprestimo)
ALTER TABLE Realizando ADD FOREIGN KEY(id_usuario) REFERENCES Usuario (id_usuario)
ALTER TABLE Rel ADD FOREIGN KEY(id_equipamento) REFERENCES Equipamento (id_equipamento)
ALTER TABLE Rel ADD FOREIGN KEY(id_emprestimo) REFERENCES Emprestimo (id_emprestimo)
------------------------------------------------------------------------------------------------------------

//Configure a conexão com o banco(application.properties);
spring.datasource.url=jdbc:mysql://localhost:3306/NOME-DO-BANCO
spring.datasource.username=SEU-USUÁRIO
spring.datasource.password=SUA-SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

//Executar app
Execute a classe - EpiApplication.java
No terminal digite: mvn spring-boot:run

//A aplicação vai subir em http://localhost:8080

//Em seguida no Postman
//Comando para listar todos os colaboradores
GET http://localhost:8080/colaboradores

// Comando para buscar colaborador por ID
GET http://localhost:8080/colaboradores/{id}

//Comando para criar novo colaborador
POST http://localhost:8080/colaboradores
Content-Type: application/json

{
  "nome": "Joao",
  "email": "joao@email.com",
  "cpf": "123.456.789-00",
  "senha": "senha123"
}

//Comando para atualizar colaborador
PUT http://localhost:8080/colaboradores/{id}
Content-Type: application/json

{
  "nome": "Joao Atualizado",
  "email": "novo@email.com",
  "cpf": "123.456.789-00",
  "senha": "novaSenha123"
}

//Comando para deletar colaborador

DELETE http://localhost:8080/colaboradores/{id}
