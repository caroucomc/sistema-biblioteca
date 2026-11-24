public abstract class ItemBiblioteca {

    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public abstract int prazoDevolucao();

    public abstract double valorMultaPorDia();

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    void marcarEmprestado() {
        disponivel = false;
    }

    void marcarDisponivel() {
        disponivel = true;
    }

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
