# Ws-Sigma

## Requisitos
* Java 11
* Maven
* IDE (IntelliJ, Netbeans, Eclipse ou Outro)

## Estrutura do projeto
* Padrão MVC
    *  Entities - Package para as entidades do banco;
    *  DTO/Filter - Package para as classes que vão retornar ao cliente;
    *  Mapper - Package para a conversão entre Entity e DTO, mais um Package para os filtros, caso tenha algum;
    *  Service/Implements - Package para as Interfaces e Implementações da Business Logic.
    *  Repository - Package para extender a classe de chamada do JPA;
    *  Exceptions - Package para os objetos de exceção;
    *  Controller - Package para as classes de chamadas dos métodos Rest;
        *  Destaque
            * ListRest - Interface para implementar no controller, serve para facilitar o List All dos controllers e deixar mais genérico o método.
    *  Config - Package das classes de configuração do projeto;
    *  Utils - Package das classes uteis para todo o projeto;
        *  Destaque
            * BaseDTO - Classe para ignorar os campos nulos na hora da serialização;
            * BaseEntity - Classe para deixar genérico o Id das Entitys, assim podendo utilizar em várias partes do projeto;
            * DefaultParamsPagedList - Interface Annotation para deixar padrão o formato no Swagger;
            * FilterMapper - Interface com o método de conversão entre classe do Filtro e Entity;
            * GenericMapper - Interface para implementar os métodos padrão de mapeamento;
            * GenericService - Interface para implementar os métodos padrão de chamada de método do projeto;
            * GenericServiceImpl - Classe Abstrata para ter a implementação comum dos métodos do CRUD;
            * PagingUtils - Classe de limitação comum para a paginação do List All;
    

## Run project
``` shell script
mvn spring-boot:run
```

## View H2 Database
* Link para o acesso do banco.
[H2-Database](localhost:8080/h2-console)

* username: root

* password: root

## View EndPoints no Swagger
* Link para o acesso.
[Swagger-UI](localhost:8080/swagger-ui.html)


### Lista de Tarefas
- [x] O WebService ser implementado em Java;
- [ ] O Cliente deve ser implementado em Java Swing;
    * Obs.: Faltou tempo para implementar esta feature
- [x] O dados devem ser enviados e recebidos utilizando-se JSON;
- [x] O projeto deve utilizar Maven;
- [ ] O projeto deve possuir testes unitários;
    * Obs.: Faltou tempo para implementar esta feature
- [x] Deve ser possível criar, editar, pesquisar, listar e remover cada uma das entidades;
- [x] Utilizar Hibernate com o banco de dados H2 (https://www.h2database.com/);
- [x] O projeto deve estar em um servidor Git (Bitbucket, Github, etc);
- [x] Adicionar README com as instruções para execução do projeto;
- [ ] Os dados recebidos/enviados devem ser salvos em arquivos de log com todos os parâmetros e seus respectivos valores;
    * Obs.: Faltou tempo para implementar esta feature
- [x] Os dados devem ser armazenados no banco de dados H2 em suas respectivas tabelas;
- [x] O servidor deverá responder com o status “true” para sucesso e “false” em caso de erro. Caso seja retornado “false”, deverá ser retornada também uma tag descritiva do erro;
- [x] Na interface, utilizar formatação de tamanho máximo, mínimo e tipo conforme banco de dados, respeitando-se também as obrigatoriedades de campos;
    * Obs.: No arquio do teste não contém nenhuma especificação para limites de cada atributo, no entanto coloquei como tudo obrigatório.
- [x] Utilizar os verbos HTTP conforme padrões (https://www.restapitutorial.com/lessons/httpmethods.html);
- [x] Utilizar os status HTTP conforme padrões (https://www.restapitutorial.com/httpstatuscodes.html);
- [ ] A criação de uma área de auditoria onde é feito o registro (banco de dados) e visualização (interface) das operações executadas pelos clientes/usuários será um diferencial;
    * Obs.: Não sei como seria a implementação desta feature.
- [x] Após finalizar o teste, envie um e-mail compartilhando o projeto para: mruckert@seware.com, rmartins@segware.com, fcanjos@segware.com  e recrutamento@brtec.info 
 