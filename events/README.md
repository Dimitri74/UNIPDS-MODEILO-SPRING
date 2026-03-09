# 🎯 UNIPDS Events API

Uma API robusta para gerenciamento de eventos, conferências, sessões e inscrições desenvolvida com Spring Boot 3 e arquitetura moderna.

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Arquitetura](#arquitetura)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Como Usar](#como-usar)
- [Endpoints da API](#endpoints-da-api)
- [Documentação Swagger](#documentação-swagger)
- [Banco de Dados H2](#banco-de-dados-h2)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Troubleshooting](#troubleshooting)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## 📖 Sobre o Projeto

O **UNIPDS Events API** é um sistema backend desenvolvido para gerenciar eventos, conferências, sessões e inscrições de usuários. O projeto implementa as melhores práticas de desenvolvimento com Spring Boot, incluindo:

✅ Arquitetura em camadas (Controller → Service → Repository)  
✅ Validação de dados robusta  
✅ Tratamento centralizado de exceções  
✅ Documentação automática com Swagger/OpenAPI  
✅ Banco de dados H2 em memória para testes  
✅ RESTful API completa  

---

## 🛠️ Tecnologias Utilizadas

### Backend Framework
- **Spring Boot 3.5.11** - Framework web e aplicações Java
- **Spring Data JPA** - ORM e persistência de dados
- **Spring Web MVC** - Desenvolvimento de APIs REST

### Banco de Dados
- **H2 Database** - Banco de dados em memória para desenvolvimento/testes
- **Hibernate** - ORM para mapeamento objeto-relacional

### Documentação e Testes
- **SpringDoc OpenAPI 2.8.5** - Documentação automática da API
- **Swagger UI** - Interface interativa para explorar endpoints
- **JUnit** - Framework de testes unitários

### Build e Dependência
- **Maven 3** - Gerenciador de dependências e build
- **Spring Boot Maven Plugin** - Plugin para builds otimizados

### Ambiente de Desenvolvimento
- **Java 21** - Linguagem de programação
- **Windows PowerShell** - Terminal de comando

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em **três camadas**:

```
┌─────────────────────────────────────────┐
│         CONTROLLER LAYER                │
│   (ConferenceController, etc)           │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│         SERVICE LAYER                   │
│   (IConferenceService, etc)             │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│       REPOSITORY LAYER                  │
│   (ConferenceRepo, etc)                 │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│        DATABASE (H2)                    │
└─────────────────────────────────────────┘
```

### Componentes Principais:

- **Controllers** - Endpoints REST que recebem requisições HTTP
- **Services** - Lógica de negócio e regras aplicadas
- **Repositories** - Acesso e manipulação de dados
- **Models/Entities** - Entidades JPA mapeadas para tabelas
- **DTOs** - Data Transfer Objects para respostas de erro
- **Exceptions** - Tratamento centralizado de erros

---

## ✅ Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- **Java 21** ou superior
  ```powershell
  java -version
  ```
  
- **Maven 3.6+** (incluído no projeto via `mvnw`)
  ```powershell
  .\mvnw -v
  ```

- **Navegador moderno** (Chrome, Firefox, Edge) para acessar Swagger
- **Windows 10/11** ou outro SO com PowerShell

---

## 🚀 Instalação e Configuração

### 1. Clone ou extraia o projeto

```powershell
cd C:\Users\marcu\workspace\UNIPDS\UNIPDS-MODULO-SPRING\events
```

### 2. Construir o projeto (Maven)

```powershell
.\mvnw clean install
```

Isso irá:
- Compilar o código-fonte
- Executar testes unitários
- Gerar artefatos JAR
- Baixar dependências

### 3. Iniciar o servidor Spring Boot

```powershell
.\mvnw spring-boot:run
```

Ou use o script PowerShell fornecido:

```powershell
.\start-server.ps1
```

**Aguarde a mensagem:**
```
Started EventsApplication in X.XXX seconds
```

---

## 💻 Como Usar

### Iniciando o Servidor

```powershell
# Terminal - Navegue até o diretório do projeto
cd C:\Users\marcu\workspace\UNIPDS\UNIPDS-MODULO-SPRING\events

# Execute o servidor
.\mvnw spring-boot:run
```

O servidor iniciará na porta **8081**.

### Acessando a Documentação

1. Abra seu navegador
2. Acesse: **http://localhost:8081/swagger-ui.html**
3. Você verá todos os endpoints disponíveis
4. Pode testar cada endpoint diretamente na interface

### Acessando o H2 Console

1. Abra seu navegador
2. Acesse: **http://localhost:8081/h2-console**
3. Use as credenciais:
   - **User Name:** `sa`
   - **Password:** (deixe em branco)
   - **JDBC URL:** `jdbc:h2:mem:db_events`
4. Clique em "Connect"

---

## 🔌 Endpoints da API

### Conference (Conferências)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/conferences` | Listar todas as conferências |
| GET | `/conferences/{id}` | Obter conferência específica |
| POST | `/conferences` | Criar nova conferência |
| PUT | `/conferences/{id}` | Atualizar conferência |
| DELETE | `/conferences/{id}` | Deletar conferência |

### Session (Sessões)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/sessions` | Listar todas as sessões |
| GET | `/sessions/{id}` | Obter sessão específica |
| POST | `/sessions` | Criar nova sessão |
| PUT | `/sessions/{id}` | Atualizar sessão |
| DELETE | `/sessions/{id}` | Deletar sessão |

### User (Usuários)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/users` | Listar todos os usuários |
| GET | `/users/{id}` | Obter usuário específico |
| POST | `/users` | Criar novo usuário |
| PUT | `/users/{id}` | Atualizar usuário |
| DELETE | `/users/{id}` | Deletar usuário |

### Subscription (Inscrições)

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/subscriptions` | Listar todas as inscrições |
| POST | `/subscriptions` | Criar nova inscrição |
| DELETE | `/subscriptions/{id}` | Cancelar inscrição |

*Para exemplos completos e schemas, consulte a documentação Swagger.*

---

## 📚 Documentação Swagger

### O que é Swagger/OpenAPI?

Swagger é uma ferramenta que gera documentação interativa automaticamente a partir do código.

### URLs da Documentação

| Recurso | URL |
|---------|-----|
| **Swagger UI (Interface)** | http://localhost:8081/swagger-ui.html |
| **OpenAPI JSON** | http://localhost:8081/v3/api-docs |
| **OpenAPI YAML** | http://localhost:8081/v3/api-docs.yaml |

### Como Usar o Swagger UI

1. **Visualizar Endpoints:** Todos os endpoints aparecem agrupados por controllers
2. **Ver Detalhes:** Clique em um endpoint para expandir e ver parâmetros
3. **Testar:** Use o botão "Try it out" para fazer requisições
4. **Ver Respostas:** Responses mostram status codes e formatos de retorno
5. **Download:** Baixe a documentação em JSON/YAML

---

## 🗄️ Banco de Dados H2

### Configuração

O H2 é configurado em `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:db_events
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Hibernate DDL Auto
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Console H2

**URL:** http://localhost:8081/h2-console

**Credenciais:**
- User: `sa`
- Password: (vazio)
- JDBC URL: `jdbc:h2:mem:db_events`

### Tabelas Criadas Automaticamente

O Hibernate cria automaticamente as seguintes tabelas:

- **CONFERENCE** - Dados de conferências
- **SESSION** - Dados de sessões
- **USER** - Dados de usuários
- **SUBSCRIPTION** - Dados de inscrições

---

## 📁 Estrutura do Projeto

```
events/
├── src/
│   ├── main/
│   │   ├── java/br/com/unipds/events/
│   │   │   ├── EventsApplication.java              # Classe principal Spring Boot
│   │   │   ├── config/
│   │   │   │   └── OpenApiConfig.java              # Configuração Swagger/OpenAPI
│   │   │   ├── controller/
│   │   │   │   ├── ConferenceController.java       # Endpoints de conferências
│   │   │   │   ├── SessionController.java          # Endpoints de sessões
│   │   │   │   ├── UserController.java             # Endpoints de usuários
│   │   │   │   ├── SubscriptionController.java     # Endpoints de inscrições
│   │   │   │   └── ControllerExceptionHandler.java # Tratamento de exceções
│   │   │   ├── service/
│   │   │   │   ├── IConferenceService.java         # Interface de serviço
│   │   │   │   ├── ConferenceServiceImpl.java       # Implementação
│   │   │   │   ├── ISessionService.java
│   │   │   │   ├── SessionServiceImpl.java
│   │   │   │   ├── IUserService.java
│   │   │   │   ├── UserServiceImpl.java
│   │   │   │   ├── ISubscriptionService.java
│   │   │   │   └── SubscriptionServiceImpl.java
│   │   │   ├── repository/
│   │   │   │   ├── ConferenceRepo.java             # JPA Repository
│   │   │   │   ├── SessionRepo.java
│   │   │   │   ├── UserRepo.java
│   │   │   │   └── SubscriptionRepo.java
│   │   │   ├── model/
│   │   │   │   ├── Conference.java                 # Entidade JPA
│   │   │   │   ├── Session.java
│   │   │   │   ├── User.java
│   │   │   │   ├── Subscription.java
│   │   │   │   └── SubscriptionID.java             # Chave composta
│   │   │   ├── dto/
│   │   │   │   └── ErrorDTO.java                   # Transfer Object de erro
│   │   │   └── exception/
│   │   │       └── NotFoundException.java           # Exceção customizada
│   │   └── resources/
│   │       ├── application.properties               # Configurações Spring
│   │       ├── static/                              # Arquivos estáticos
│   │       └── templates/                           # Templates (se houver)
│   └── test/
│       └── java/br/com/unipds/events/
│           └── EventsApplicationTests.java          # Testes unitários
├── pom.xml                                          # Arquivo Maven
├── mvnw                                             # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                                         # Maven Wrapper (Windows)
├── start-server.ps1                                 # Script de inicialização
├── README.md                                        # Esta documentação
├── README_SWAGGER.md                                # Resumo Swagger
├── SWAGGER_H2_URLS.md                               # URLs de Acesso
├── HELP.md                                          # Ajuda adicional
└── target/                                          # Arquivos compilados (Maven)
```

---

## 🔧 Configurações Principais

### application.properties

```properties
# Identificação da aplicação
spring.application.name=events

# Porta do servidor
server.port=8081

# Banco de dados H2
spring.datasource.url=jdbc:h2:mem:db_events
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

# Console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Swagger/OpenAPI
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
```

---

## 🐛 Troubleshooting

### ❌ Erro: "Connection refused" na porta 8081

**Causa:** A porta 8081 já está sendo usada por outro processo

**Solução:**
```powershell
# Encontrar processo na porta 8081
netstat -ano | findstr :8081

# Matar o processo (substitua <PID> pelo número)
taskkill /PID <PID> /F
```

### ❌ Erro: "Cannot find HTTP method 'GET'"

**Causa:** Erro ao compilar ou dependências não sincronizadas

**Solução:**
```powershell
.\mvnw clean install
```

### ❌ Swagger não carrega (erro 404)

**Verificação:**
1. Servidor está rodando? (http://localhost:8081)
2. Verifique se a porta é 8081 (não 8080)
3. URL correta: `/swagger-ui.html` (não `/swagger-ui/` ou `/swagger-ui/index.html`)

### ❌ H2 Console não conecta

**Credenciais corretas:**
- **JDBC URL:** `jdbc:h2:mem:db_events` (caso sensível)
- **User Name:** `sa`
- **Password:** (deixe vazio)

### ❌ Erro 500 em /v3/api-docs

**Causa:** Referências circulares ou problemas na serialização de entidades

**Solução:** Verifique se as entidades têm `@JsonIgnore` nas relações bidirecionais

---

## 📊 Versões e Dependências

| Componente | Versão |
|-----------|--------|
| Java | 21 |
| Spring Boot | 3.5.11 |
| Spring Data JPA | (herdada de Spring Boot) |
| SpringDoc OpenAPI | 2.8.5 |
| H2 Database | (herdada de Spring Boot) |
| Maven | 3.6+ |
| JUnit | (herdada de Spring Boot) |

---

## 🤝 Contribuição

Para contribuir com o projeto:

1. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
2. Commit suas mudanças (`git commit -m 'Add minha feature'`)
3. Push para a branch (`git push origin feature/minha-feature`)
4. Abra um Pull Request

---

## 📝 Licença

Este projeto está sob licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

## 📞 Suporte e Contato

Para dúvidas ou sugestões:

- **Email:** contato@unipds.com
- **Website:** https://www.unipds.com
- **Documentação:** Consulte o Swagger em http://localhost:8081/swagger-ui.html

---

## ✨ Próximos Passos

- [ ] Implementar autenticação JWT
- [ ] Adicionar validações adicionais de negócio
- [ ] Criar testes unitários mais abrangentes
- [ ] Implementar paginação nos endpoints
- [ ] Adicionar filtros e busca avançada
- [ ] Documentar modelos de dados em mais detalhes
- [ ] Implementar cache com Redis
- [ ] Adicionar logs estruturados

---

**Última atualização:** Março 2026  
**Desenvolvido por:** UNIPDS Development Team

