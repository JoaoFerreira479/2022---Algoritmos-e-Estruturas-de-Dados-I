package revisao1;

import java.util.Scanner;

public class PosicoesParesRecursivo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho do vetor
            int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");
            validarTamanhoVetor(n);

            // Preenchendo o vetor com valores do usuário
            int[] vetor = preencherVetor(scanner, n);

            // Exibindo o vetor completo
            System.out.println("Vetor completo:");
            exibirVetor(vetor);

            // Exibindo elementos nas posições pares
            System.out.println("Elementos nas posições pares do vetor:");
            imprimirPosicoesPares(vetor, 0);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar o tamanho do vetor
    private static void validarTamanhoVetor(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("O tamanho do vetor deve ser maior que zero.");
        }
    }

    // Método para preencher o vetor
    private static int[] preencherVetor(Scanner scanner, int tamanho) {
        int[] vetor = new int[tamanho];
        System.out.println("Digite os valores do vetor:");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = lerValorInteiro(scanner, String.format("Valor na posição %d: ", i));
        }
        return vetor;
    }

    // Método para imprimir as posições pares do vetor recursivamente
    private static void imprimirPosicoesPares(int[] vetor, int indice) {
        if (indice >= vetor.length) {
            return; // Caso base: índice fora do tamanho do vetor
        }

        if (indice % 2 == 0) { // Verifica se a posição é par
            System.out.printf("Posição %d: %d%n", indice, vetor[indice]);
        }

        // Chamada recursiva para o próximo índice
        imprimirPosicoesPares(vetor, indice + 1);
    }

    // Método para exibir o vetor completo
    private static void exibirVetor(int[] vetor) {
        for (int valor : vetor) {
            System.out.print(valor + " ");
        }
        System.out.println(); // Quebra de linha
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
