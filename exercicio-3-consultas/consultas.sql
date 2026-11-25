
-- ============================================
-- SISTEMA DE BIBLIOTECA
-- EXERCICIO 3 - CONSULTAS SQL
-- ============================================

-- 1. LISTAR TODO O ACERVO
-- Codigo, titulo, tipo e disponibilidade.

SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY codigo;


-- 2. LISTAR EMPRESTIMOS EM ABERTO
-- Mostrar nome do usuario e titulo do item.

SELECT
    u.nome AS usuario,
    i.titulo AS item,
    e.data_retirada,
    e.data_devolucao_prevista
FROM emprestimo e
INNER JOIN usuario u
    ON e.usuario_id = u.id
INNER JOIN item i
    ON e.item_id = i.id
WHERE e.data_devolucao IS NULL
ORDER BY e.data_retirada;


-- 3. TOTAL DE MULTAS ACUMULADAS POR USUARIO

SELECT
    u.id,
    u.nome AS usuario,
    COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e
    ON u.id = e.usuario_id
GROUP BY u.id, u.nome
ORDER BY u.nome;


-- 4. ITENS QUE NUNCA FORAM EMPRESTADOS

SELECT
    i.id,
    i.codigo,
    i.titulo,
    i.tipo
FROM item i
LEFT JOIN emprestimo e
    ON i.id = e.item_id
WHERE e.item_id IS NULL
ORDER BY i.codigo;
