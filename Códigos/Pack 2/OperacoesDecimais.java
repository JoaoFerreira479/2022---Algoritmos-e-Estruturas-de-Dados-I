package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OperacoesDecimais {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do número decimal
            double numero = lerValorDouble(scanner, "Digite um número decimal: ");

            // Realização dos cálculos
            double valorAbsoluto = calcularValorAbsoluto(numero);
            double valorTeto = calcularValorTeto(numero);
            double valorPiso = calcularValorPiso(numero);

            // Exibição dos resultados
            exibirResultados(valorAbsoluto, valorTeto, valorPiso);

        } catch (InputMismatchException e) {
            exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número decimal válido.");
        } finally {
            scanner.close();
        }
    }

    // Método para calcular o valor absoluto
    private static double calcularValorAbsoluto(double numero) {
        return Math.abs(numero);
    }

    // Método para calcular o valor de teto
    private static double calcularValorTeto(double numero) {
        return Math.ceil(numero);
    }

    // Método para calcular o valor de piso
    private static double calcularValorPiso(double numero) {
        return Math.floor(numero);
    }

    // Método para exibir os resultados
    private static void exibirResultados(double valorAbsoluto, double valorTeto, double valorPiso) {
        System.out.printf("a) Valor absoluto: %.2f%n", valorAbsoluto);
        System.out.printf("b) Valor de teto (arredondamento para cima): %.0f%n", valorTeto);
        System.out.printf("c) Valor de piso (arredondamento para baixo): %.0f%n", valorPiso);
    }

    // Método para ler um valor double com validação
    private static double lerValorDouble(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                exibirMensagemErro("Erro: Entrada inválida. Por favor, digite um número decimal válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    // Método para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        System.err.println(mensagem);
    }
}
