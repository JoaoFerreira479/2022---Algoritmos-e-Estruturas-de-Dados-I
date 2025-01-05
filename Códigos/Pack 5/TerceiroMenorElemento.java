package revisao1;

import java.util.Arrays;
import java.util.Scanner;

public class TerceiroMenorElemento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada das dimensões da matriz
            int linhas = lerValorInteiro(scanner, "Digite o número de linhas da matriz: ");
            int colunas = lerValorInteiro(scanner, "Digite o número de colunas da matriz: ");

            validarDimensoesMatriz(linhas, colunas);

            // Preenchendo a matriz
            int[][] matriz = preencherMatriz(scanner, linhas, colunas);

            // Encontrando o terceiro menor elemento
            int terceiroMenor = encontrarTerceiroMenor(matriz);

            // Exibindo o resultado
            exibirResultado(terceiroMenor);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar as dimensões da matriz
    private static void validarDimensoesMatriz(int linhas, int colunas) {
        if (linhas * colunas < 3) {
            throw new IllegalArgumentException("A matriz deve ter pelo menos 3 elementos.");
        }
    }

    // Método para preencher uma matriz
    private static int[][] preencherMatriz(Scanner scanner, int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = lerValorInteiro(scanner, String.format("Valor na posição [%d][%d]: ", i, j));
            }
        }
        return matriz;
    }

    // Método para encontrar o terceiro menor elemento da matriz
    private static int encontrarTerceiroMenor(int[][] matriz) {
        int totalElementos = matriz.length * matriz[0].length;
        int[] vetor = transformarMatrizEmVetor(matriz, totalElementos);

        Arrays.sort(vetor); // Ordenando o vetor

        return vetor[2]; // Retornando o terceiro menor elemento
    }

    // Método para transformar a matriz em um vetor
    private static int[] transformarMatrizEmVetor(int[][] matriz, int totalElementos) {
        int[] vetor = new int[totalElementos];
        int k = 0;

        for (int[] linha : matriz) {
            for (int elemento : linha) {
                vetor[k++] = elemento;
            }
        }
        return vetor;
    }

    // Método para exibir o resultado
    private static void exibirResultado(int terceiroMenor) {
        System.out.printf("O terceiro menor elemento da matriz é: %d%n", terceiroMenor);
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
