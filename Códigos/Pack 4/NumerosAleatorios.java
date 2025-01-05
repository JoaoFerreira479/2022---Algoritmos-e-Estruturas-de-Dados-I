package estruturasrepeticao;

import java.util.Random;

public class NumerosAleatorios {

    public static void main(String[] args) {
        // Instância do gerador de números aleatórios
        Random gerador = new Random();

        System.out.println("Gerando 10 números aleatórios e classificando como PAR ou ÍMPAR:");

        // Laço para gerar e classificar 10 números
        for (int i = 0; i < 10; i++) {
            int num = gerarNumeroAleatorio(gerador);
            String classificacao = classificarNumero(num);
            exibirResultado(num, classificacao);
        }
    }

    // Método para gerar um número aleatório entre 0 e 99
    private static int gerarNumeroAleatorio(Random gerador) {
        return gerador.nextInt(100);
    }

    // Método para classificar um número como PAR ou ÍMPAR
    private static String classificarNumero(int numero) {
        return (numero % 2 == 0) ? "PAR" : "ÍMPAR";
    }

    // Método para exibir o resultado
    private static void exibirResultado(int numero, String classificacao) {
        System.out.printf("Número gerado: %d -> %s%n", numero, classificacao);
    }
}
