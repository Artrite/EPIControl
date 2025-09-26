# EPIControl

Passos para executar o EPIControl usando SpringBoot

//Clone o repositório
git clone <https://github.com/Artrite/EPIControl.git>
cd EPIControl-main

//Crie o Banco Mysql

CREATE TABLE colaborador 
( 
 id_colaborador INT PRIMARY KEY,  
 cpf varchar(14) not null,
 nome varchar(45) not null,
 email varchar(45) not null,
 senha varchar(45) not null
); 

CREATE TABLE usuario 
( 
 id_usuario INT PRIMARY KEY,  
 cpf varchar(14) not null,
 nome varchar(45) not null,
 email varchar(45) not null,
 senha varchar(45) not null 
); 

CREATE TABLE equipamento 
( 
 id_equipamento INT PRIMARY KEY,  
 nome varchar(45),  
 quantidade INT
); 

CREATE TABLE emprestimo 
( 
 data_emprestimo DATETIME(),
 data_devolucao DATETIME(),
 idusuario INT,  
 idcolaborador INT,  
 idequipamento INT,  
 id_emprestimo INT PRIMARY KEY,  
 FOREIGN KEY (idusuario) REFERENCES usuario(idusuario),
 FOREIGN KEY (idcolaborador) REFERENCES colaborador(idcolaborador),
 FOREIGN KEY (idequipamento) REFERENCES equipamento(idequipamento)
  
); 
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

