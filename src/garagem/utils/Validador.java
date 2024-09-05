package garagem.utils;

public class Validador {

    public static boolean validarAno(int ano) {
        int anoAtual = java.time.Year.now().getValue();
        return ano > 1885 && ano <= anoAtual;  // Considera que o primeiro carro foi criado em 1885.
    }

    public static boolean validarValor(double valor) {
        return valor >= 0;
    }
}
