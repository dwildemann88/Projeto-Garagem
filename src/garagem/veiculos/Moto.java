package garagem.veiculos;

public class Moto extends Veiculo {
    private boolean temPartidaEletrica;

    public Moto(String modelo, String marca, int ano, double valor, boolean temPartidaEletrica) {
        super(modelo, marca, ano, valor);
        this.temPartidaEletrica = temPartidaEletrica;
    }

    public boolean isTemPartidaEletrica() {
        return temPartidaEletrica;
    }

    public void setTemPartidaEletrica(boolean temPartidaEletrica) {
        this.temPartidaEletrica = temPartidaEletrica;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Moto: " + getMarca() + " " + getModelo() + " - Ano: " + getAno() + " - Valor: R$" + getValor());
    }
}
