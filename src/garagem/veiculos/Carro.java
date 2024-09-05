package garagem.veiculos;

public class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String modelo, String marca, int ano, double valor, int numeroDePortas) {
        super(modelo, marca, ano, valor);
        this.numeroDePortas = numeroDePortas;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }

    public void setNumeroDePortas(int numeroDePortas) {
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Carro: " + getMarca() + " " + getModelo() + " - Ano: " + getAno() + " - Valor: R$" + getValor());
    }
}
