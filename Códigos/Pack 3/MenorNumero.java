package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenorNumero {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada dos três números inteiros
            int num1 = lerValorInteiro(scanner, "Digite o primeiro número inteiro: ");
            int num2 = lerValorInteiro(scanner, "Digite o segundo número inteiro: ");
            int num3 = lerValorInteiro(scanner, "Digite o terceiro número inteiro: ");

            // Determinação do menor número
            int menor = encontrarMenor(num1, num2, num3);

            // Exibição do resultado
            exibirResultado(menor);

        } catch (InputMismatchException e) {
            exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar números inteiros.");
        } finally {
            scanner.close();
        }
    }

    // Método para encontrar o menor número entre três valores
    private static int encontrarMenor(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    // Método para exibir o menor número
    private static void exibirResultado(int menor) {
        System.out.printf("O menor número é: %d%n", menor);
    }

    // Método para ler um número inteiro com validação
    private static int lerValorInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número inteiro válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    // Método para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        System.err.println(mensagem);
    }
}
