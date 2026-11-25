public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        System.out.println("===== CADASTRO DE ITENS =====");

        Livro livro1 = new Livro(
                "L001", "Dom Casmurro", "Machado de Assis"
        );

        Livro livro2 = new Livro(
                "L002", "O Pequeno Principe", "Antoine de Saint-Exupery"
        );

        Revista revista1 = new Revista(
                "R001", "Revista Ciencia Hoje", 150
        );

        Revista revista2 = new Revista(
                "R002", "Revista National Geographic", 200
        );

        DVD dvd = new DVD(
                "D001", "Interestelar"
        );

        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);
        biblioteca.cadastrarItem(dvd);

        System.out.println("\n===== CADASTRO DE USUARIOS =====");

        Aluno aluno = new Aluno("Carlos");
        Professor professor = new Professor("Mariana");

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        System.out.println("\n===== TESTES DE EMPRESTIMO =====");

        biblioteca.emprestar("L001", aluno);
        biblioteca.emprestar("L002", aluno);
        biblioteca.emprestar("R001", aluno);

        // Tentativa recusada: aluno ja possui 3 itens.
        biblioteca.emprestar("R002", aluno);

        System.out.println("\n===== TESTE DE DEVOLUCAO =====");

        biblioteca.devolver("L001", aluno);

        System.out.println("\n===== TESTE DO PROFESSOR =====");

        biblioteca.emprestar("D001", professor);

        System.out.println("\n===== LISTAGEM DO ACERVO =====");

        biblioteca.listarAcervo();

        System.out.println("\n===== FIM DOS TESTES =====");
    }
}
