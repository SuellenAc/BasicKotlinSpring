### Descrição

Projeto desenvolvido no curso - Api Rest com Kotlin e spring boot ( camada web ) da alura

# Notas de Aulas

## Aula 1 - Introdução ao desenvolvimento de apis

Arquitetura em 3 camadas ( Arquitetura App Web Tradicional ) 
Client - Server - database

Problema da aplicação server side quando o server retorna HTML, CSS e JS visando apenas aplicações web.  Múltiplos clientes ( web, mobile, outros servers ) como enviar dados de forma flexível? Solução REST API - modelo Stateless

**REST - Representational State Transfer** - Transferência do estado de um recurso

Rest é baseado no protocolo HTTP 

Faz o gerenciamento ou manipulação de recursos ( dados armazenados, depende do escopo da aplicação ) 

Utiliza URIs - Identificação de recursos ( URI - identificador único para acesso de recursos ) - baseado no HTTP 

Manipulação de recursos ( verbos HTTP )  - GET, POST, PUT, DELETE
( Listar, Cadastrar, Atualizar, Remover ) 

Trafegando uma representação do recurso armazenado, traduzido em um formato devolvido pela API ( json, XML ) - Media types.

A comunicação ocorre de forma stateless, ou seja, ela não guarda estado. Cada requisição é única. Importante para escalabilidade. 

## Aula 2 - Criando o projeto 

Site para gerar o projeto inicial do spring - start.spring.io
(Spring web, spring boot devTools , Validation ) 

Setup inicial do projeto. Adição de Hello World. 

Adição de anotação para mapear o recurso e anotação chamada do método que retorna um get na API 

## Aula 3 - Classes de domínio

Criação dos modelos de domínio do projeto. 

## Aula 4 - Controllers
 
Criando o controller para gerenciar e devolver as informações da classe de domínio topic 

Spring usa jackson para converter os objetos para o mediatype json. Conversão é automática

Dúvidas: Como trocar a lib padrão que prove o json? Como customizar algum campo ? 

## Aula 5 - Injeção de dependencias

Spring já tem o conceito de injeção de dependências através de anotações 
Para classes do tipo service usar a anotação (Service) 

Regras de negócio ficam no service 

Dúvida: Como o spring faz a injeção de dependências? ( Service locator? ou um padrão parecido com o utilizado pelo Dagger 2? 

## Aula 6 - Parâmetros na URI


Parâmetros dinâmicos no GET (Path) - GetMapping("/{id}")

Adicionando método na classe TopicController.kt para buscar por um tópico por id. O método retorna null ou o tópico encontrado.
Esse método precisa da anotação -  **GetMapping("/{id}")** para indicar ao spring que a URI desse mapeamento aceita um path com o id do tópico a ser pesquisado.
Para linkar o id do getMapping com o id do método utilizamos a anotação - **PathVariable**

## Aula 7 - PostMapping

Criando um método para cadastrar informações usando **PostMapping** para indicar que aquele método é do tipo post e **RequestBody** para indicar o parâmetro que deve ser recebido no corpo da requisição

## Aula 8 - Postman

Ferramenta para teste de api - Postman

## Aula 9 - DTOs

Criando um objeto intermediário para passar como parâmetro do método POST


## Aula 10 - DTOs continuação


Utilizar na entrada e saída de dados - Data transfer objects

## Aula  11 - Mappers

Criação de Mappers

## Aula 12 - Bean Validation

Bean validation biblioteca para validação de formulários baseado em anotações. 
Adicionar anotações aos parâmetros da classe DTO e a anotação Valid na função POST

Para data class adicionar field:<NomeAnotação>

## Aula 13 - Put

PutMapping - Novo objeto DTO para atualização dos dados. 

## Aula 14 - Delete

DeleteMapping - Excluir um tópico

## Aula 15 - Melhorando a resposta da API

Melhorias na APi - Retorno da resposta HTTP 

( Corpo, Cabeçalho, Status ) 

POST - Retornar código 201, que indica que um recurso acabou de ser criado. 

No código 201, devemos devolver o recurso cadastrado e no HEADER location  a uri do recurso

Utilizar o ResponseEntity

Para pegar a URI do tópico utilizar - uriBuilder

Referência:
https://martinfowler.com/articles/richardsonMaturityModel.html


# Error Handling


## Aula 1 - Introdução

Introdução: Melhorias em relação a quando erros acontecem para não retornar a stackTrace para o cliente.

## Aula 2  - Tratamento de erros com RestControllerAdvice

Tratamento de erros específicos - RestControllerAdvice ( classe )  e ExceptionHandler ( método )

## Aula 3 - Tratamento de erros genéricos

Tratamento de erros genéricos 

## Aula 4 - Tratamento de erros em formulários

Tratamento de erros em cadastro de formulários 

