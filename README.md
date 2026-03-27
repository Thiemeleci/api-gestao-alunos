## API de Gestão de Alunos

API REST desenvolvida com Java + Spring Boot para gerenciamento de alunos e matrículas.
O projeto foi criado com foco em boas práticas de desenvolvimento backend, organização em camadas e uso de testes automatizados.

## Funcionalidades:

- Cadastro de alunos

- Listagem de alunos

- Atualização de dados do aluno

- Remoção de alunos

- Matrículas associadas aos alunos

- Geração automática de código de matrícula

- API REST estruturada em camadas

- Testes com JUnit

## Tecnologias utilizadas:

- Java
- Spring Boot
- Spring Data JPA
- Banco de dados H2 (em memória)
- JUnit
- Maven

## Estrutura do projeto:

- controller → endpoints REST

-  service → Regras de negócio

- repository → Acesso ao banco de dados

- dto → comunicação da API

- entity → Modelagem das entidades

## Banco de Dados:

O projeto utiliza H2 Database, um banco em memória.


Como Executar o Projeto: 

Clonar o repositório 

- git clone https://github.com/Thiemeleci/api-gestao-alunos.git

Acessar a pasta

- cd api-gestao-alunos

Executar

- AlunosApplication.java

Ou via Maven

- mvn spring-boot:run

## Requisições:

As requisições da API podem ser feitas diretamente pelo arquivo .http
dentro do IntelliJ ou utilizando ferramentas como:

- Postman
- Insomnia
- Curl

## Objetivo do Projeto : 

Projeto desenvolvido para fins de estudo com foco em:

- Desenvolvimento de APIs REST
- Spring Boot
- JPA
- Relacionamentos entre entidades
- Arquitetura em camadas
- Testes automatizados

## Autor

Thiemeleci Isaque - Desenvolvedor Backend Java.

- GitHub: https://github.com/Thiemeleci
- LinkedIn: https://www.linkedin.com/in/thiemeleci-isaque-059116243/

