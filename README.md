
# Sistema de Biblioteca

Projeto desenvolvido como atividade de formação em
Programação Orientada a Objetos com Java e Banco de Dados
PostgreSQL.

## Objetivo

Desenvolver um sistema para controlar o acervo de uma
biblioteca, permitindo o cadastro de livros, revistas,
usuários, empréstimos e devoluções.

O projeto foi dividido em três exercícios.

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos (POO)
- PostgreSQL
- SQL

## Estrutura do projeto

```text
sistema-biblioteca/
│
├── exercicio-1-java/
│   └── src/
│       ├── ItemBiblioteca.java
│       ├── Livro.java
│       ├── Revista.java
│       ├── DVD.java
│       ├── Usuario.java
│       ├── Aluno.java
│       ├── Professor.java
│       ├── Emprestimo.java
│       ├── Biblioteca.java
│       └── Main.java
│
├── exercicio-2-modelagem/
│   └── biblioteca.sql
│
├── exercicio-3-consultas/
│   └── consultas.sql
│
└── README.md
```

## Exercício 1 - Java (POO)

Desenvolvimento de um sistema de biblioteca utilizando:

- Classes abstratas.
- Herança.
- Encapsulamento.
- Polimorfismo.
- Arrays de tamanho fixo.

### Regras de empréstimo

| Tipo | Prazo | Multa por dia |
|---|---:|---:|
| Livro | 14 dias | R$ 0,50 |
| Revista | 7 dias | R$ 1,00 |

### Limites de empréstimos

| Usuário | Limite |
|---|---:|
| Aluno | 3 itens |
| Professor | 5 itens |

O sistema permite cadastrar itens e usuários, realizar
empréstimos, devolver itens e listar o acervo.

Também foi implementada a categoria DVD para demonstrar
a extensibilidade do polimorfismo.

### Como executar

Entre na pasta `exercicio-1-java/src`.

Compile os arquivos:

```bash
javac *.java
```

Execute o programa:

```bash
java Main
```

## Exercício 2 - Modelagem PostgreSQL

Criação de três tabelas relacionais:

- item
- usuario
- emprestimo

Foram utilizados:

- Chaves primárias.
- Chaves estrangeiras.
- GENERATED ALWAYS AS IDENTITY.
- Restrições CHECK.
- Relacionamentos entre tabelas.

O script também contém dados para testes.

### Como executar

Abra o PostgreSQL pelo pgAdmin ou outro cliente SQL.

Execute o arquivo:

`exercicio-2-modelagem/biblioteca.sql`

## Exercício 3 - Consultas SQL

Foram desenvolvidas quatro consultas:

1. Listagem completa do acervo.
2. Listagem dos empréstimos em aberto.
3. Cálculo do total de multas por usuário.
4. Identificação dos itens nunca emprestados.

### Como executar

Após executar o script do exercício 2, execute:

`exercicio-3-consultas/consultas.sql`

## Conclusão

O projeto permitiu aplicar conceitos de programação
orientada a objetos e modelagem de bancos de dados
relacionais, desenvolvendo um sistema simples de
gerenciamento de biblioteca.
