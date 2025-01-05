package revisao1;

import java.util.Scanner;

public class SomaMatrizes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho das matrizes
            int linhas = lerValorInteiro(scanner, "Digite o número de linhas das matrizes: ");
            int colunas = lerValorInteiro(scanner, "Digite o número de colunas das matrizes: ");

            validarDimensoesMatrizes(linhas, colunas);

            // Inicializando e preenchendo as matrizes
            System.out.println("Digite os valores da primeira matriz:");
            int[][] matriz1 = preencherMatriz(scanner, linhas, colunas);

            System.out.println("Digite os valores da segunda matriz:");
            int[][] matriz2 = preencherMatriz(scanner, linhas, colunas);

            // Calculando a soma das matrizes
            int[][] matrizSoma = somarMatrizes(matriz1, matriz2);

            // Exibindo a matriz resultante
            System.out.println("Matriz resultante (soma das duas matrizes):");
            exibirMatriz(matrizSoma);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar as dimensões das matrizes
    private static void validarDimensoesMatrizes(int linhas, int colunas) {
        if (linhas <= 0 || colunas <= 0) {
            throw new IllegalArgumentException("As matrizes devem ter dimensões positivas.");
        }
    }

    // Método para preencher uma matriz
    private static int[][] preencherMatriz(Scanner scanner, int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = lerValorInteiro(scanner, String.format("Valor na posição [%d][%d]: ", i, j));
            }
        }
        return matriz;
    }

    // Método para somar duas matrizes
    private static int[][] somarMatrizes(int[][] matriz1, int[][] matriz2) {
        int linhas = matriz1.length;
        int colunas = matriz1[0].length;
        int[][] matrizSoma = new int[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizSoma[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return matrizSoma;
    }

    // Método para exibir uma matriz
    private static void exibirMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            for (int valor : linha) {
                System.out.print(valor + " ");
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

