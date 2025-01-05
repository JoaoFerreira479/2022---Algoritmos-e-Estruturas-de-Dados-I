package revisao2;

import java.util.Scanner;

public class PreencherMatrizComVetor {

    // Tamanho fixo do vetor e da matriz
    private static final int TAMANHO_VETOR = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Preenchendo o vetor
            int[] vetor = new int[TAMANHO_VETOR];
            System.out.println("Preenchendo o vetor de " + TAMANHO_VETOR + " posições:");
            preencherVetor(scanner, vetor);

            // Exibindo o vetor preenchido
            System.out.println("Vetor preenchido:");
            exibirVetor(vetor);

            // Preenchendo a matriz a partir do vetor
            int[][] matriz = preencherMatrizComVetor(vetor);

            // Exibindo a matriz resultante
            System.out.println("Matriz resultante:");
            exibirMatriz(matriz);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para preencher o vetor com valores do usuário
    private static void preencherVetor(Scanner scanner, int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = lerValorInteiro(scanner, String.format("Digite o valor na posição %d: ", i));
        }
    }

    // Método para preencher a matriz com base no vetor
    private static int[][] preencherMatrizComVetor(int[] vetor) {
        int[][] matriz = new int[3][vetor.length];

        // Preenchendo a primeira linha: multiplicação por 2
        preencherLinhaMultiplicacao(vetor, matriz[0], 2);

        // Preenchendo a segunda linha: soma com 3
        preencherLinhaSoma(vetor, matriz[1], 3);

        // Preenchendo a terceira linha: resto da divisão
        preencherLinhaRestoDivisao(matriz[0], matriz[1], matriz[2]);

        return matriz;
    }

    // Método para preencher uma linha da matriz multiplicando os elementos do vetor
    private static void preencherLinhaMultiplicacao(int[] vetor, int[] linha, int multiplicador) {
        for (int i = 0; i < vetor.length; i++) {
            linha[i] = vetor[i] * multiplicador;
        }
    }

    // Método para preencher uma linha da matriz somando os elementos do vetor
    private static void preencherLinhaSoma(int[] vetor, int[] linha, int soma) {
        for (int i = 0; i < vetor.length; i++) {
            linha[i] = vetor[i] + soma;
        }
    }

    // Método para preencher a linha com o resto da divisão
    private static void preencherLinhaRestoDivisao(int[] linha1, int[] linha2, int[] linhaResultado) {
        for (int i = 0; i < linha1.length; i++) {
            linhaResultado[i] = (linha2[i] != 0) ? linha1[i] % linha2[i] : 0; // Evita divisão por zero
        }
    }

    // Método para exibir um vetor
    private static void exibirVetor(int[] vetor) {
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println(); // Quebra de linha
    }

    // Método para exibir uma matriz
    private static void exibirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + "\t");
            }
            System.out.println(); // Quebra de linha após cada linha da matriz
        }
    }

    // Método para ler um valor inteiro com validação
    private static int lerValorInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (Exception e) {
                exibirMensagemErro("Erro: Entrada inválida. Digite um número inteiro válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    // Método para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        System.err.println(mensagem);
    }
}
