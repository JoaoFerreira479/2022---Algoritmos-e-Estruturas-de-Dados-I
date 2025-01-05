package revisao1;

import java.util.Scanner;

public class VerificarMatrizesIguais {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada das dimensões das matrizes
            int linhas = lerValorInteiro(scanner, "Digite o número de linhas das matrizes: ");
            int colunas = lerValorInteiro(scanner, "Digite o número de colunas das matrizes: ");

            validarDimensoesMatriz(linhas, colunas);

            // Inicializando e preenchendo as matrizes
            System.out.println("Digite os valores da primeira matriz:");
            int[][] matriz1 = preencherMatriz(scanner, linhas, colunas);

            System.out.println("Digite os valores da segunda matriz:");
            int[][] matriz2 = preencherMatriz(scanner, linhas, colunas);

            // Verificando se as matrizes são iguais
            boolean iguais = verificarMatrizesIguais(matriz1, matriz2);

            // Exibindo o resultado
            exibirResultado(iguais);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar as dimensões das matrizes
    private static void validarDimensoesMatriz(int linhas, int colunas) {
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

    // Método para verificar se duas matrizes são iguais
    private static boolean verificarMatrizesIguais(int[][] matriz1, int[][] matriz2) {
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false; // Matrizes diferentes
                }
            }
        }
        return true; // Matrizes iguais
    }

    // Método para exibir o resultado
    private static void exibirResultado(boolean iguais) {
        if (iguais) {
            System.out.println("As matrizes são iguais.");
        } else {
            System.out.println("As matrizes são diferentes.");
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
