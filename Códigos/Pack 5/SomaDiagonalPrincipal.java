package revisao1;

import java.util.Scanner;

public class SomaDiagonalPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho da matriz quadrada
            int n = lerValorInteiro(scanner, "Digite o tamanho da matriz quadrada (N x N): ");
            validarTamanhoMatriz(n);

            // Inicializando e preenchendo a matriz
            int[][] matriz = preencherMatriz(scanner, n);

            // Calculando a soma da diagonal principal
            int somaDiagonal = calcularSomaDiagonalPrincipal(matriz);

            // Exibindo o resultado
            exibirResultado(somaDiagonal);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar o tamanho da matriz
    private static void validarTamanhoMatriz(int tamanho) {
        if (tamanho <= 0) {
            throw new IllegalArgumentException("O tamanho da matriz deve ser maior que zero.");
        }
    }

    // Método para preencher uma matriz
    private static int[][] preencherMatriz(Scanner scanner, int tamanho) {
        int[][] matriz = new int[tamanho][tamanho];
        System.out.println("Digite os valores da matriz:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = lerValorInteiro(scanner, String.format("Valor na posição [%d][%d]: ", i, j));
            }
        }
        return matriz;
    }

    // Método para calcular a soma da diagonal principal
    private static int calcularSomaDiagonalPrincipal(int[][] matriz) {
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            soma += matriz[i][i];
        }
        return soma;
    }

    // Método para exibir o resultado
    private static void exibirResultado(int somaDiagonal) {
        System.out.printf("A soma da diagonal principal é: %d%n", somaDiagonal);
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
