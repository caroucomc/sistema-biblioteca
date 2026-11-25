import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {

    private ItemBiblioteca item;
    private Usuario usuario;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucao;
    private double valorMulta;

    public Emprestimo(ItemBiblioteca item, Usuario usuario) {

        this.item = item;
        this.usuario = usuario;

        this.dataRetirada = LocalDate.now();

        this.dataDevolucaoPrevista =
                dataRetirada.plusDays(item.prazoDevolucao());

        this.valorMulta = 0;
    }

    public double devolver(LocalDate data) {

        this.dataDevolucao = data;

        long diasAtraso = Math.max(
                0,
                ChronoUnit.DAYS.between(
                        dataDevolucaoPrevista,
                        dataDevolucao
                )
        );

        valorMulta = diasAtraso * item.valorMultaPorDia();

        return valorMulta;
    }

    public ItemBiblioteca getItem() {
        return item;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean estaAberto() {
        return dataDevolucao == null;
    }

    public double getValorMulta() {
        return valorMulta;
    }
}
