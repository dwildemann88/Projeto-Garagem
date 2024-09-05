package garagem.dao;

import garagem.veiculos.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
    private List<Veiculo> veiculos;

    public VeiculoDAO() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return veiculos;
    }

    public Veiculo buscarVeiculoPorModelo(String modelo) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modelo)) {
                return veiculo;
            }
        }
        return null ;
    }
}
