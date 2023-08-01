<h1> tqi_kotlin_backend_developer_2023 </h1>
<h2> Desafio TQI Kotlin Backend: JuMarket 1.0 </h2>
<h4> *Está versão só apresenta o BackEnd </h4>

<h2> Instruções do sistema: </h2>

## Passos para utilizar o sistema:

#### 1 - Está na pasta principal do projeto;
#### 2 - Subir o banco(MySQL) via Docker:
    docker-compose up
#### 3 - Subir o Backend do sistema uzando o gradle: 
    gradle bootRun
<br>

## Utilizando a API:
### CATEGORIA:
#### Adicionar Categoria:
    url = localhost:8080/api/categoria
    json = 
            {
                "nome": "{Nome da Categoria}"
            }
#### Visualizar todas as Categorias:
    url = localhost:8080/api/categoria
#### Visualizar Categorias expecifica pelo id:
    url = localhost:8080/api/categoria/{id}
#### Deletar Categoria:
    url = localhost:8080/api/categoria/{id}
<br>

### PRODUTO:
#### Adicionar Produto:
    url = localhost:8080/api/produto
    json =
            {    
                "categoriaId": {id da categoria},
                "nome": "{nome do produto}",
                "unidadeMedida": "{unidade de medida do produto}",
                "preco": {valor do tipo double}
            }
#### Visualizar todas as Categorias:
    url = localhost:8080/api/produto/produtos
#### Visualizar Produtos por Categoria:
    url = localhost:8080/api/produto?categoriaId={id da categoria}
#### Visualizar Produto expecifico pelo id:
    url = localhost:8080/api/produto/{id}
#### Deletar Produto:
    url = localhost:8080/api/produto/{id}
<br>

### CLIENTE:
#### Adicionar Cliente:
    url = localhost:8080/api/cliente
    json = 
            {
                "nome": "{Nome do Cliente}"
            }
#### Visualizar Cliente expecifico pelo id:
    url = localhost:8080/api/cliente/{id}
#### Visualizar Cliente expecifico pelo nome:
    url = localhost:8080/api/cliente?clienteNome={nome do cliente}
#### Deletar Cliente:
    url = localhost:8080/api/cliente/{id}
<br>

### COMPRA:
#### Adicionar Compra:
    url = localhost:8080/api/compra
    json = 
        {
            "clienteId": {id do cliente},
            "pagamento": {numero referente ao tipo de pagamento},
            "produto":[
                {
                    "id": {id do produto},
                    "nome": "{nome do produto}",
                    "unidadeMedida": "{unidade de medida do produto}",
                    "preco": {valor do tipo double}
                    "categoria": {
                        "id:": {id da categoria},
                        "nome": "{nome da categoria}"
                    }
                }
            ]
        }
#### Visualizar Compra:
    url = localhost:8080/api/compra/{id}
#### Deletar compra:
    url = localhost:8080/api/compra/{id}

<br>

## Banco de Dados:
### O Banco de dados ja inicia com alguns dados:
    2 Categorias
    3 Produtos
    2 Clientes