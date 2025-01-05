package estruturascondicionais;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CategoriaNatacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada da idade
            int idade = lerIdade(scanner, "Digite a idade da pessoa: ");

            // Determinação da categoria
            String categoria = determinarCategoria(idade);

            // Exibição do resultado
            exibirCategoria(idade, categoria);

        } catch (IllegalArgumentException e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número inteiro.");
        } finally {
            scanner.close();
        }
    }

    // Método para determinar a categoria com base na idade
    private static String determinarCategoria(int idade) {
        if (idade < 8) {
            return "INFANTIL";
        } else if (idade < 11) {
            return "JUVENIL";
        } else if (idade < 16) {
            return "ADOLESCENTE";
        } else if (idade < 30) {
            return "ADULTO";
        } else {
            return "SÊNIOR";
        }
    }

    // Método para ler a idade com validação
    private static int lerIdade(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                int idade = scanner.nextInt();
                if (idade < 0) {
                    throw new IllegalArgumentException("A idade deve ser um valor positivo.");
                }
                return idade;
            } catch (InputMismatchException e) {
                exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número inteiro válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    // Método para exibir a categoria
    private static void exibirCategoria(int idade, String categoria) {
        System.out.printf("A categoria para a idade %d é: %s%n", idade, categoria);
    }

    // Método para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        System.err.println(mensagem);
    }
}
