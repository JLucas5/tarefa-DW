# Tarefa DW

## Arquivos

`pom.xml` - Arquivo de configuração do projeto Maven.

`src/main/webapp` - Pasta para colocar conteúdo web.

## Para executar o Tomcat

`mvn tomcat7:run`

## Para executar o banco de dados Derby

`mvn exec:java@derby-start`

## Banco de Dados

### JDBC

URL: `jdbc:derby://localhost:1527/livrodb;create=true`

Usuário: `app`

Senha: `app`

### Tabelas

`
CREATE TABLE LIVRO (
  CODIGO VARCHAR(100),
  NOME VARCHAR(100),
  AUTOR VARCHAR(100)
)
`