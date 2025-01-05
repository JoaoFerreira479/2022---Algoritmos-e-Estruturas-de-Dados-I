package revisao2;

import java.util.Scanner;

public class MatrizComSomaColunas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Dimensões fixas da matriz
            final int LINHAS = 4;
            final int COLUNAS = 4;

            // Inicializando a matriz
            int[][] matriz = new int[LINHAS][COLUNAS];

            // Preenchendo as primeiras 3 linhas da matriz
            System.out.println("Preenchendo a matriz (as 3 primeiras linhas):");
            preencherMatriz(scanner, matriz, LINHAS - 1, COLUNAS);

            // Calculando a soma das colunas e preenchendo a última linha
            calcularSomaColunas(matriz);

            // Exibindo a matriz final
            System.out.println("Matriz final com a soma das colunas na última linha:");
            exibirMatriz(matriz);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para preencher as primeiras linhas da matriz
    private static void preencherMatriz(Scanner scanner, int[][] matriz, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = lerValorInteiro(scanner, String.format("Digite o valor na posição [%d][%d]: ", i, j));
            }
        }
    }

    // Método para calcular a soma das colunas e preencher a última linha
    private static void calcularSomaColunas(int[][] matriz) {
        for (int j = 0; j < matriz[0].length; j++) {
            int soma = 0;
            for (int i = 0; i < matriz.length - 1; i++) {
                soma += matriz[i][j];
            }
            matriz[matriz.length - 1][j] = soma; // Preenche a última linha com a soma
        }
    }

    // Método para exibir a matriz
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
