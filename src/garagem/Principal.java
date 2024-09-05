package garagem;

import garagem.dao.VeiculoDAO;
import garagem.relatorios.RelatorioVeiculos;
import garagem.veiculos.*;
import garagem.utils.Validador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n----- Menu Principal -----");
            System.out.println("1 - Adicionar veículo");
            System.out.println("2 - Ver relatório de veículos");
            System.out.println("3 - Sair");
            System.out.println("---------------------------");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir o newline
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpar entrada inválida
                continue;
            }

            switch (opcao) {
                case 1:
                    // Adicionar veículo
                    try {
                        System.out.println("Digite o tipo de veículo (1 - Carro, 2 - Moto): ");
                        int tipo = scanner.nextInt();
                        scanner.nextLine(); // Consumir o newline

                        System.out.println("Digite o modelo: ");
                        String modelo = scanner.nextLine();

                        System.out.println("Digite a marca: ");
                        String marca = scanner.nextLine();

                        System.out.println("Digite o ano: ");
                        int ano = scanner.nextInt();
                        if (!Validador.validarAno(ano)) {
                            throw new InputMismatchException("Ano inválido.");
                        }

                        System.out.println("Digite o valor: ");
                        double valor = scanner.nextDouble();
                        if (!Validador.validarValor(valor)) {
                            throw new InputMismatchException("Valor inválido.");
                        }

                        if (tipo == 1) {
                            System.out.println("Digite o número de portas: ");
                            int portas = scanner.nextInt();
                            Carro carro = new Carro(modelo, marca, ano, valor, portas);
                            veiculoDAO.adicionarVeiculo(carro);
                        } else if (tipo == 2) {
                            System.out.println("A moto tem partida elétrica? (true/false): ");
                            boolean partidaEletrica = scanner.nextBoolean();
                            Moto moto = new Moto(modelo, marca, ano, valor, partidaEletrica);
                            veiculoDAO.adicionarVeiculo(moto);
                        } else {
                            System.out.println("Tipo de veículo inválido. Tente novamente.");
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: " + e.getMessage());
                        scanner.nextLine(); // Consumir a entrada incorreta
                    }
                    break;

                case 2:
                    // Ver relatório de veículos
                    RelatorioVeiculos.gerarRelatorio(veiculoDAO.listarVeiculos());
                    break;

                case 3:
                    // Sair do programa
                    continuar = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
