
-- ============================================
-- SISTEMA DE BIBLIOTECA
-- EXERCICIO 2 - MODELAGEM DO BANCO DE DADOS
-- PostgreSQL
-- ============================================

-- 1. TABELA ITEM

CREATE TABLE item (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(120),
    edicao INTEGER,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_item_tipo
        CHECK (tipo IN ('livro', 'revista')),

    CONSTRAINT chk_item_edicao
        CHECK (edicao IS NULL OR edicao > 0)
);

-- 2. TABELA USUARIO

CREATE TABLE usuario (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(120) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,

    CONSTRAINT chk_usuario_tipo
        CHECK (tipo IN ('aluno', 'professor')),

    CONSTRAINT chk_usuario_limite
        CHECK (
            (tipo = 'aluno' AND limite_itens = 3)
            OR
            (tipo = 'professor' AND limite_itens = 5)
        )
);

-- 3. TABELA EMPRESTIMO

CREATE TABLE emprestimo (
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id INTEGER NOT NULL,
    usuario_id INTEGER NOT NULL,
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id) REFERENCES item(id),

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id) REFERENCES usuario(id),

    CONSTRAINT chk_valor_multa
        CHECK (valor_multa >= 0),

    CONSTRAINT chk_datas
        CHECK (
            data_devolucao IS NULL
            OR data_devolucao >= data_retirada
        )
);

-- ============================================
-- INSERCAO DOS ITENS
-- ============================================

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
('L001', 'Dom Casmurro', 'livro', 'Machado de Assis', NULL, FALSE),
('L002', 'O Pequeno Principe', 'livro', 'Antoine de Saint-Exupery', NULL, TRUE),
('R001', 'Ciencia Hoje', 'revista', NULL, 150, TRUE),
('R002', 'National Geographic', 'revista', NULL, 200, TRUE),
('L003', 'A Hora da Estrela', 'livro', 'Clarice Lispector', NULL, TRUE);

-- ============================================
-- INSERCAO DOS USUARIOS
-- ============================================

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
('Carlos Silva', 'aluno', 3),
('Mariana Souza', 'professor', 5);

-- ============================================
-- INSERCAO DOS EMPRESTIMOS
-- ============================================

-- Emprestimo ja devolvido

INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES (
    1,
    1,
    CURRENT_DATE - 20,
    CURRENT_DATE - 6,
    CURRENT_DATE - 4,
    1.00
);

-- Emprestimo em aberto

INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES (
    2,
    2,
    CURRENT_DATE - 3,
    CURRENT_DATE + 11,
    NULL,
    0.00
);

-- ============================================
-- FIM DOS DADOS DE TESTE
-- ============================================

-- Conferir os itens cadastrados
SELECT * FROM item;

-- Conferir os usuarios cadastrados
SELECT * FROM usuario;

-- Conferir os emprestimos cadastrados
SELECT * FROM emprestimo;
