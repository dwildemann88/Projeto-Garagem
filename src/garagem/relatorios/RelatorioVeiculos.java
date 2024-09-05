package garagem.relatorios;

import garagem.veiculos.Veiculo;
import java.util.List;

public class RelatorioVeiculos {

    public static void gerarRelatorio(List<Veiculo> veiculos) {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo na garagem.");
            return;
        }

        System.out.println("---- Relatório de Veículos ----");
        for (Veiculo veiculo : veiculos) {
            veiculo.exibirDetalhes();
        }
        System.out.println("-------------------------------");
    }
}
