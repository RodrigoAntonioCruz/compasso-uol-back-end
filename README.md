<p align="center">
  <img align="center" alt="Logo UOL" src="https://githubfinder.compasso.rodrigodacruz.com.br/static/LogoUol.png" />
</p>

<h2 align="center">
  DESAFIO BACKEND COMPASSO UOL
</h2>


### Contexto do Desafio

Desenvolver uma `API REST` que contemple as seguintes operações nos respectivos `Endpoints`:

<ul>
  <li> Cadastrar cidade
  <li> Cadastrar cliente
  <li> Consultar cidade pelo nome
  <li> Consultar cidade pelo estado
  <li> Consultar cliente pelo nome
  <li> Consultar cliente pelo Id
  <li> Remover cliente
  <li> Alterar o nome do cliente
</ul>


<h4>Tecnologias Usadas</h4>
<ul>
  <li> Java 8
  <li> Maven
  <li> Spring Boot 
  <li> Lombok
  <li> H2 Database
  <li> MariaDB Server
  <li> FlyWayDB
</ul>



### Requisitos do seu ambiente para execução 

1. Instale <a href="https://java.com/pt-BR/download/help/java8.html" target="_blank" alt="Java 8">Java 8</a>

2. Instale <a href="https://www.postman.com/downloads/" target="_blank" alt="POSTMAN">POSTMAN</a>


### Executando o projeto

1. Clone ou baixe o projeto do repositório no seu `Workspace`.

2. Navegue até a raíz do seu diretório e `execute no terminal` o comando `mvnw spring-boot:run`. Este comando executará o servidor em `http://localhost` na porta 80 e fará a migração automatizada das tabelas `SQL`, juntamente com alguns dados de teste para o banco em memória H2.

3. Para testar os `Endpoints` use o `POSTMAN`.


### Observações
  
1. Por padrão, deixei configurado o banco em memória H2 para fins de execução rápida e testes. 

2. A `API` está preparada para trabalhar com bancos externos e `versionamento de banco de dados`.

3. Existem três tipos de `PERFILS` de acesso, são eles: `test` para testes, `dev` para desenvolvimento, `prod` para produção.

4. Para configurar um perfil de acesso navegue até o diretório `src/main/resources/`, abra o arquivo `application.properties` e configure com `test`, `dev` ou  `prod`

4. Para configurar os dados de acesso de banco de dados externos, como desenvolvimento ou produção, os arquivos de configuração são os seguintes: `application.properties.dev` para desenvolvimento, de produção no arquivo `application.properties.prod` 


### Endpoints da API-REST

<hr>

#### Endpoints - CIDADES

`Retorna todas as cidades`<br>

`GET    - RESPONSE STATUS OK : 200 - http://localhost/cidades`

<hr>

`Retorna cidade passando os parâmetros UF ou CIDADE. Parâmetros aceitos sigla do estado ou nome da cidade`<br>

`GET    - RESPONSE STATUS OK : 200 - http://localhost/cidades/{parametro}`

<hr>

`Realiza o cadastro de uma nova cidade`<br>

`POST   - RESPONSE STATUS OK : 201 - http://localhost/cidades`

<hr>

`Realiza a edição de uma cidade, passando o ID por parâmetro`<br>

`PUT    - RESPONSE STATUS OK : 204 - http://localhost/cidades/{id}`

<hr>

`Realiza a exclusão uma cidade, passando o ID por parâmetro`<br>

`DELETE - RESPONSE STATUS OK : 204 - http://localhost/cidades/{id}`

<hr>

#### Endpoints - CLIENTES

`Retorna todos os clientes`<br>

`GET    - RESPONSE STATUS OK : 200 - http://localhost/clientes`

<hr>

`Retorna cliente passando os parâmetros ID ou NOME. Parâmetros aceitos id ou nome do cliente`<br>

`GET    - RESPONSE STATUS OK : 200 - http://localhost/clientes/{parametro}`

<hr>

`Realiza o cadastro de uma novo cliente`<br>

`POST   - RESPONSE STATUS OK : 201 - http://localhost/clientes`

<hr>

`Realiza a edição de um cliente, passando o ID por parâmetro`<br>

`PUT    - RESPONSE STATUS OK : 204 - http://localhost/clientes/{id}`

<hr>

`Realiza a exclusão um cliente, passando o ID por parâmetro `<br>

`DELETE - RESPONSE STATUS OK : 204 - http://localhost/clientes/{id}`

<hr>

#### Build da API-REST em execução

Se preferir, você pode acessar o `Endpoint` abaixo e testá-lo com `POSTMAN`:

`http://162.241.48.158:8080/{parametros}`
