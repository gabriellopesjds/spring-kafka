# Spring Boot with MongoDB and Kafka.

#### Postman
+ Collections disponíveis para request: [clique aqui](others/doc/postman/Kafka.postman_collection)

## API's disponíveis:

#### Product ( Produto )
+ Cadastrar um produto.
+ Buscar um produto por código.
+ Buscar todos os produtos.
+ Buscar todos os produtos por um preço mínimo e máximo.

## Configurações

#### Versão de Java
A build terá exigências de versões específicas do Java 11.

#### Plugins
Para auxiliar no desenvolvimento é recomendado a instalação dos plugins para as seguintes ferramentas:
* [Lombok](https://projectlombok.org)

### Executando Kafka + MongoDB no Docker
```sh
docker-compose up
```