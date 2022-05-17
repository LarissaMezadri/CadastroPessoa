# Cadastro simples de pessoas

# Requisitos

Para este projeto você vai precisar:

- Java 11+
- Banco de Dados MySQL 5.7+
- Maven 3.8.4+

# Start do Projeto

Configure o application.properties:

- spring.datasource.url e flyway.url : url de conexão com seu banco de dados
- spring.datasource.username e flyway.user : usuário de conexão com seu banco de dados
- spring.datasource.password e flyway.password : senha de conexão com seu banco de dados
- flyway.schemas : schema para aplicação no seu banco de dados

Quando você iniciar a aplicação a estrutura de banco de dados será automaticamente criada pelo Flyway. 