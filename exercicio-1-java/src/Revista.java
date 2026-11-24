public class Revista extends ItemBiblioteca {

    private int edicao;

    public Revista(String codigo, String titulo, int edicao) {
        super(codigo, titulo);
        this.edicao = edicao;
    }

    @Override
    public int prazoDevolucao() {
        return 7;
    }

    @Override
    public double valorMultaPorDia() {
        return 1.00;
    }

    public int getEdicao() {
        return edicao;
    }
}
