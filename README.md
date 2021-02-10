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
  <li> Spring Boot 
  <li> Maven
  <li> Lombok
  <li> H2 Database
  <li> MariaDB Server
  <li> FlyWayDB
  <li> Swagger
  <li> Validation
  <li> JUnit
</ul>


### Executando o projeto

1. Clone ou baixe o projeto do repositório no seu `Workspace`.

2. Navegue até a raíz do seu diretório e `execute via terminal` o comando `mvnw spring-boot:run`. Este comando executará o servidor em `http://localhost` na porta `80` e fará a migração automatizada das tabelas `SQL`, juntamente com os dados de teste para o banco em memória H2.

3. Abra seu browser e navegue até `http://localhost` que estará disponível a documentação da `API` juntamente com os `Endpoints` para teste.


### Executando os Testes

1.Navegue até a raíz do seu diretório e `execute via terminal` o comando `mvnw clean test`. Este comando executará todos os casos de teste, resultando em:

<hr>

<p align="center">
  <img align="center" alt="Testes" src="https://githubfinder.compasso.rodrigodacruz.com.br/static/test.png" />
</p>

<hr>


### Build em execução
Se preferir, você ler a documentação da `API` ou testar os `Endpoints` no endereço :
<a href="http://162.241.48.158:8080" target="_blank" alt="Swagger documentação">`DOCUMENTAÇÃO DA API-REST`</a>

<hr>

<p align="center">
  <img align="center" alt="Swagger" src="https://githubfinder.compasso.rodrigodacruz.com.br/static/swager.png" />
</p>

<hr>


### Observações
  
1. Por padrão, deixei configurado o banco em memória H2 para fins de execução rápida e testes. 

2. A `API` está preparada para trabalhar com bancos externos e `versionamento de banco de dados`.

3. Existem três tipos de `PERFILS` de acesso, são eles: `test` para testes, `dev` para desenvolvimento, `prod` para produção.

4. Para configurar um perfil de acesso navegue até o diretório `src/main/resources/`, abra o arquivo `application.properties` e configure com `test`, `dev` ou  `prod`

4. Para configurar os dados de acesso de banco de dados externos, como desenvolvimento ou produção, os arquivos de configuração são os seguintes: `application.properties.dev` para desenvolvimento, de produção no arquivo `application.properties.prod` 
