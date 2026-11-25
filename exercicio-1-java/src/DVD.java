public class DVD extends ItemBiblioteca {

    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int prazoDevolucao() {
        return 3;
    }

    @Override
    public double valorMultaPorDia() {
        return 2.00;
    }
}
