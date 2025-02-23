# Itaú - Desafio técnico Backend Júnior

## Descrição do desafio
Criar uma API REST que recebe transações e retorna estatística sobre as mesmas.

[Clique aqui para acessar o repositório do desafio técnico](https://github.com/rafaellins-itau/desafio-itau-vaga-99-junior "Clique aqui para acessar o repositório do desafio técnico")

## Como posso executar a aplicação?

1. Certifique-se de ter o Git, Docker e Maven instalados e configurados no computador.
2. Clone o projeto para uma pasta de sua preferência.
3. Abra o projeto em uma IDE para que seja possível compilar o mesmo utilizando o seguinte comando no terminal:
```bash
mvn clean package
```
4. Com o projeto compilado em um arquivo .jar, basta executar o seguinte comando para criar e rodar o container:
```bash
docker-compose up --build
```
## Endpoints da API

### `POST /transacao`

Este é o endpoint que irá receber as transações. Cada transação consiste em um valor e uma dataHora de quando ocorreu:
```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```
Este endpoint aceitará transações que:
1. Tenham os campos `valor` e `dataHora` preenchidos.
2. Tenham acontecido em algum momento no passado.
3. Não sejam negativas.

Respostas possíveis:
- `201 Created` sem corpo
    - A transação foi aceita (validada e registrada)
- `422 Unprocessable Entity` sem corpo
    - A transação não foi aceita por qualquer motivo (um ou mais dos critérios não foram atendidos)
- `400 Bad Request` sem corpo
    - A API não compreendeu a requisição do cliente.

### `DELETE /transacao`

Esse endpoint apaga **todos os dados de transações** que estejam armazenados.

Respostas possíveis:
- `200 OK` sem corpo
    - Todas as informações foram apagadas com sucesso.

### `GET /estatistica?intervalo=`
Este endpoint deve retornar todas as estatísticas das transações que aconteceram durante um intervalo. Por padrão, são considerados os últimos 60 segundos.
```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

Respostas possíveis:
- `200 OK` sem corpo
    - Um JSON com os campos `count`, `sum`, `avg`, `min` e `max` todos preenchidos com seus respectivos valores.
    - Quando não houverem transações nos últimos 60 segundos, os valores são considerados como 0.