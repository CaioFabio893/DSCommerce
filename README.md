
# 📦 DSCommerce

**DSCommerce** é uma aplicação completa de e-commerce desenvolvida em **Java com Spring Boot**, contendo sistema de autenticação com **Spring Security + JWT**, controle de acesso por perfis, gerenciamento de produtos, categorias e pedidos, além de integração com banco de dados e boas práticas de arquitetura.

Este projeto foi desenvolvido com foco em aprendizado prático de **APIs REST, Segurança, JPA/Hibernate, arquitetura limpa e mercado real**.

---

## 🧠 Visão Geral do Sistema

O sistema implementa a base de um e-commerce real, incluindo:

* Autenticação e autorização com **JWT**
* Perfis de usuário (**Client** e **Admin**)
* Cadastro, listagem e gerenciamento de produtos
* Sistema de pedidos com itens
* Regras de acesso garantindo segurança
* Estrutura profissional de API REST

---

## 🚀 Funcionalidades Implementadas

### 🔐 Autenticação & Segurança

* Login com geração de **Token JWT**
* Middleware de validação de token em cada requisição protegida
* Proteção de rotas sensíveis
* Autorização baseada em perfil:

    * **CLIENTE**

        * Pode visualizar produtos
        * Pode criar pedidos
        * Pode visualizar apenas seus próprios pedidos
    * **ADMIN**

        * Pode cadastrar, atualizar e deletar produtos
        * Pode acessar pedidos de qualquer usuário
* Gestão de sessão totalmente **stateless**
* Integração com **Spring Security**

---

### 🧑‍💻 Usuários

* Cadastro de usuários
* Login
* Recuperação de dados do usuário autenticado
* Relacionamento entre usuário → pedidos

---

### 🛍️ Produtos

* Listagem paginada
* Busca por ID
* Associação com categorias
* CRUD completo (ADMIN)

---

### 🧾 Pedidos

* Criação de pedidos
* Associação com itens e produtos
* Relacionamento com usuário autenticado
* Regra:

    * Cliente só vê seu pedido
    * Admin pode ver todos

---

## 🛠️ Tecnologias Utilizadas

| Categoria      | Tecnologia                          |
| -------------- | ----------------------------------- |
| Linguagem      | Java                                |
| Framework      | Spring Boot                         |
| Segurança      | Spring Security + JWT               |
| Persistência   | Spring Data JPA / Hibernate         |
| Banco de Dados | H2 / PostgreSQL / outro configurado |
| Build          | Maven                               |
| API            | RESTful                             |

---

## 📁 Estrutura do Projeto

```
src/main/java
 └── com.dscommerce
      ├── controllers
      ├── services
      ├── repositories
      ├── entities
      ├── dto
      ├── config
      ├── security
      └── exceptions
```

---

## ⚙️ Como Rodar o Projeto

### 1️⃣ Clonar

```bash
  git clone https://github.com/CaioFabio893/DSCommerce.git
  cd DSCommerce
```

### 2️⃣ Configurar o banco

Por padrão o projeto usa H2 (ou configure outro DB no `application.properties`).

### 3️⃣ Executar

```bash
  ./mvnw spring-boot:run
```

Ou execute a classe principal na IDE.

---

## 🔐 Como usar a autenticação

### 1️⃣ Login

Enviar POST para:

```
POST /login
```

Com corpo contendo usuário e senha.
A resposta retorna um **JWT token**.

### 2️⃣ Usar o token

Enviar nas próximas requisições:

```
Authorization: Bearer SEU_TOKEN
```

---

## 🧪 Testes

* Testes unitários e/ou integrados (caso implementados no seu projeto)
* Execução:

```
mvn test
```

---

## 📌 Boas Práticas Utilizadas

✔ Camadas bem definidas
✔ DTOs para evitar exposição de entidades
✔ Tratamento global de exceções
✔ Paginação nas listagens
✔ Segurança robusta com JWT
✔ Código limpo e padronizado

---

## 🚀 Possíveis Melhorias Futuras

* Upload de imagem para produtos
* Checkout com pagamento
* Relatórios
* Dashboard admin
* Deploy em nuvem

---

## 👤 Autor

**Caio Fábio**

📌 GitHub: [https://github.com/CaioFabio893](https://github.com/CaioFabio893)

📌 LinkedIn: [https://www.linkedin.com/in/caio-fabio-souza](https://www.linkedin.com/in/caio-fabio-souza)

---

