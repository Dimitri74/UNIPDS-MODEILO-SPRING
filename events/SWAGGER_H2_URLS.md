# 🚀 UNIPDS Events API - Swagger & H2 Console

## ✅ Configuração Completa e Funcional

O Spring Boot está **rodando e totalmente configurado** com Swagger e H2 Console.

---

## 📋 URLs de Acesso

### 1. **Swagger UI - Documentação Interativa**
```
http://localhost:8081/swagger-ui.html
```
✅ **Status:** Funcionando  
📝 **Descrição:** Interface web interativa para explorar e testar todos os endpoints da API  
🔄 **Recursos:** 
- Visualizar todos os endpoints disponíveis
- Testar endpoints diretamente pelo navegador
- Ver modelos de dados e respostas
- Autenticação e autorização (quando configurada)

---

### 2. **OpenAPI JSON Definition**
```
http://localhost:8081/v3/api-docs
```
✅ **Status:** Disponível  
📝 **Descrição:** Definição em formato JSON da API no padrão OpenAPI 3.0  
🔄 **Usos:**
- Consumido pelo Swagger UI
- Usado por ferramentas de client generation
- Compartilhável com outros desenvolveres
- Integração com ferramentas de teste automático

---

### 3. **H2 Database Console**
```
http://localhost:8081/h2-console
```
✅ **Status:** Funcionando  
📝 **Descrição:** Interface web para gerenciar banco de dados H2 em memória

**Credenciais de Login:**
- **Driver Class:** `org.h2.Driver`
- **JDBC URL:** `jdbc:h2:mem:db_events`
- **User Name:** `sa`
- **Password:** (deixe vazio)

🔄 **Funcionalidades:**
- Visualizar tabelas e estrutura do banco
- Executar queries SQL
- Inserir/atualizar/deletar dados
- Analisar logs de acesso

---

## 🛠️ Configurações Realizadas

### Arquivo: `application.properties`
```properties
# H2 Console Configuration
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Swagger/OpenAPI Configuration
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.enabled=true
```

### Arquivo: `OpenApiConfig.java`
Nova classe de configuração criada em:  
`src/main/java/br/com/unipds/events/config/OpenApiConfig.java`

Customizações:
- **Título:** UNIPDS Events API
- **Versão:** 1.0.0
- **Descrição:** API para gerenciamento de eventos, conferências, sessões e inscrições
- **Contato:** UNIPDS (https://www.unipds.com)

---

## 📦 Dependência Maven

O projeto já possui a dependência correta:
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.8.5</version>
</dependency>
```

---

## 🎯 Próximos Passos

### 1. Acessar Swagger UI
```
Navegador → http://localhost:8081/swagger-ui.html
```
Lá você verá:
- Todos os endpoints disponíveis (Conference, Session, User, Subscription)
- Possibilidade de testar cada endpoint
- Modelos de requisição e resposta

### 2. Acessar H2 Console
```
Navegador → http://localhost:8081/h2-console
```
Faça login com as credenciais fornecidas e explore:
- Tabelas criadas pelo Hibernate
- Dados inseridos
- Execute queries customizadas

### 3. Melhorar Documentação (Opcional)
Você pode adicionar anotações aos controllers para melhorar a documentação:

```java
@GetMapping("/{id}")
@Operation(summary = "Obter conferência por ID", description = "Retorna uma conferência específica")
@ApiResponse(responseCode = "200", description = "Conferência encontrada")
@ApiResponse(responseCode = "404", description = "Conferência não encontrada")
public ResponseEntity<Conference> getConferenceById(@PathVariable Integer id) {
    // ...
}
```

---

## 🔗 Endpoints da API

Os endpoints são documentados automaticamente no Swagger:

### Conference
- `GET /conferences` - Listar todas as conferências
- `GET /conferences/{id}` - Obter conferência específica
- `POST /conferences` - Criar nova conferência

### Session
- Endpoints de gerenciamento de sessões

### User
- Endpoints de gerenciamento de usuários

### Subscription
- Endpoints de gerenciamento de inscrições

*Veja a interface Swagger para documentação completa com exemplos*

---

## ✨ Troubleshooting

### Se o Swagger não aparecer:
1. Verifique se o Spring está rodando: `http://localhost:8081`
2. Confirme se a porta 8081 está livre
3. Reinicie o Spring Boot

### Se o H2 Console não funciona:
1. Verifique se `spring.h2.console.enabled=true`
2. Confirme as credenciais (user: `sa`, password: vazio)
3. Verifique a URL do banco: `jdbc:h2:mem:db_events`

### Se há erro de porta em uso:
```bash
# Windows - Matar processo na porta 8081
netstat -ano | findstr :8081
taskkill /PID <PID> /F
```

---

## 📊 Resumo Técnico

| Item | Valor |
|------|-------|
| Framework | Spring Boot 3.5.11 |
| Java | 21 |
| Banco | H2 (em memória) |
| Swagger Version | 2.8.5 (SpringDoc) |
| OpenAPI | 3.0 |
| Porta | 8081 |

---

**Tudo pronto! O projeto está totalmente funcional com Swagger e H2 Console. 🎉**

Acesse as URLs acima no seu navegador e explore a API!
