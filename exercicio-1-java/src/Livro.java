public class Livro extends ItemBiblioteca {

    private String autor;

    public Livro(String codigo, String titulo, String autor) {
        super(codigo, titulo);
        this.autor = autor;
    }

    @Override
    public int prazoDevolucao() {
        return 14;
    }

    @Override
    public double valorMultaPorDia() {
        return 0.50;
    }

    public String getAutor() {
        return autor;
    }
}
