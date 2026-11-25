import java.time.LocalDate;

public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;
    private Emprestimo[] emprestimos;

    private int totalItens;
    private int totalUsuarios;
    private int totalEmprestimos;

    public Biblioteca() {

        acervo = new ItemBiblioteca[100];
        usuarios = new Usuario[50];
        emprestimos = new Emprestimo[200];

        totalItens = 0;
        totalUsuarios = 0;
        totalEmprestimos = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {

        if (totalItens < acervo.length) {
            acervo[totalItens++] = item;
            System.out.println("Item cadastrado: " + item.getTitulo());
        } else {
            System.out.println("Acervo cheio!");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {

        if (totalUsuarios < usuarios.length) {
            usuarios[totalUsuarios++] = usuario;
            System.out.println("Usuario cadastrado: " + usuario.getNome());
        } else {
            System.out.println("Limite de usuarios atingido!");
        }
    }

    private ItemBiblioteca buscarItem(String codigo) {

        for (int i = 0; i < totalItens; i++) {

            if (acervo[i].getCodigo().equals(codigo)) {
                return acervo[i];
            }
        }

        return null;
    }

    private boolean usuarioCadastrado(Usuario usuario) {

        for (int i = 0; i < totalUsuarios; i++) {

            if (usuarios[i] == usuario) {
                return true;
            }
        }

        return false;
    }

    public void emprestar(String codigo, Usuario usuario) {

        if (!usuarioCadastrado(usuario)) {
            System.out.println("Usuario nao cadastrado!");
            return;
        }

        ItemBiblioteca item = buscarItem(codigo);

        if (item == null) {
            System.out.println("Item nao encontrado!");
            return;
        }

        if (!item.isDisponivel()) {
            System.out.println("Item indisponivel!");
            return;
        }

        if (!usuario.podeEmprestar()) {
            System.out.println("Emprestimo recusado! Limite atingido para "
                    + usuario.getNome());
            return;
        }

        if (totalEmprestimos >= emprestimos.length) {
            System.out.println("Limite de emprestimos atingido!");
            return;
        }

        item.marcarEmprestado();
        usuario.adicionarEmprestimo();

        emprestimos[totalEmprestimos++] =
                new Emprestimo(item, usuario);

        System.out.println("Emprestimo realizado com sucesso!");
        System.out.println("Item: " + item.getTitulo());
        System.out.println("Prazo: " + item.prazoDevolucao() + " dias");
    }

    public void devolver(String codigo, Usuario usuario) {

        for (int i = 0; i < totalEmprestimos; i++) {

            Emprestimo emprestimo = emprestimos[i];

            if (emprestimo.estaAberto()
                    && emprestimo.getItem().getCodigo().equals(codigo)
                    && emprestimo.getUsuario() == usuario) {

                double multa = emprestimo.devolver(LocalDate.now());

                emprestimo.getItem().marcarDisponivel();
                usuario.removerEmprestimo();

                System.out.println("Devolucao realizada com sucesso!");

                System.out.printf("Multa: R$ %.2f%n", multa);

                return;
            }
        }

        System.out.println("Emprestimo em aberto nao encontrado!");
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        for (int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i]);
        }
    }
}
