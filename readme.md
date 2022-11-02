# CRUD de clientes

### SOBRE  A API
API de cadastro de clientes.

Projeto construído com Java, Spring Boot, JPA, Hibernate é banco de dados H2.

### CARACTERISTICAS
Esta API fornece endpoints e ferramentas http para o seguinte:
- `post` inserir novos clientes
- `get` busca paginada de clientes
- `get\{id}` busca cliente por id
- `delete` deleta cliente por id
- `update` atualiza dados do cliente

### DETALHAMENTO

#### Rota <i>/clients</i> método <i>`POST`</i>

Objetivo: Criar um novo cliente

Exemplo de envio:
```json
{
  "name":"José Mariano",
  "cpf":"12345678901",
  "income":3000.0,
  "birthDate":"1994-07-20T10:30:00Z",
  "children":2
}
```
Exemplo de retorno:
```json
{
  "id": 1,
  "name": "José Mariano",
  "cpf": "12345678901",
  "income": 3000.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```
#
#### Rota <i>/clients</i> método <i>`GET`</i>

Objetivo: busca paginada de clientes

Requisição: `/clients?page=0&linesPerPage=5&direction=ASC&orderBy=name`
- `page` é o numero da pagina
- `linesPerPage` é a quantidade de elementos
- `direction` direção da ordenação ("ASC" ordem crescente e "DESC" ordem decrecente)
- `orderBy` campo referencia para a ordenação

Exemplo de retorno:
```json
{
  "content": [
    {
      "id": 8,
      "name": "Edinalva Santiago",
      "cpf": "12345678908",
      "income": 600.0,
      "birthDate": "2020-07-13T20:50:07.123450Z",
      "children": 3
    },
    {
      "id": 3,
      "name": "Felipe Bomfim",
      "cpf": "12345678903",
      "income": 3500.0,
      "birthDate": "2020-07-13T20:50:07.123450Z",
      "children": 0
    },
    {
      "id": 11,
      "name": "José Mariano",
      "cpf": "12345678901",
      "income": 3000.0,
      "birthDate": "1994-07-20T10:30:00Z",
      "children": 2
    },
    {
      "id": 4,
      "name": "Lelio Henrique",
      "cpf": "12345678904",
      "income": 6600.0,
      "birthDate": "2020-07-13T20:50:07.123450Z",
      "children": 2
    },
    {
      "id": 1,
      "name": "Lucas Silva",
      "cpf": "12345678901",
      "income": 6500.0,
      "birthDate": "2020-07-13T20:50:07.123450Z",
      "children": 3
    }
  ],
  "pageable": {
    "sort": {
      "empty": false,
      "sorted": true,
      "unsorted": false
    },
    "offset": 0,
    "pageSize": 5,
    "pageNumber": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalPages": 2,
  "totalElements": 10,
  "size": 5,
  "number": 0,
  "sort": {
    "empty": false,
    "sorted": true,
    "unsorted": false
  },
  "first": true,
  "numberOfElements": 5,
  "empty": false
}
```
#
#### Rota <i>/clients/{id}</i> método <i>`GET`</i>

Objetivo: busca por id

Requisição: `/clients/11`
- 11 = id registrado no banco de dados

Exemplo de retorno:
```json
{
  "id": 11,
  "name": "José Mariano",
  "cpf": "12345678901",
  "income": 3000.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```
#
#### Rota <i>/clients/{id}</i> método <i>`PUT`</i>

Objetivo: atualiza dados do cliente

Requisição: `/clients/11`
- 11 = id registrado no banco de dados

Exemplo do body:
```json
{
  "name": "Update name",
  "cpf": "123456789 01",
  "income": 3000.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

Exemplo de retorno:
```json
{
  "id": 11,
  "name": "Update name",
  "cpf": "12345678901",
  "income": 3000.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```

#
#### Rota <i>/clients/{id}</i> método <i>`DELETE`</i>

Objetivo: deletar usuário

Requisição: `/clients/11`
- 11 = id registrado no banco de dados

Retorno status: 204 No Content

