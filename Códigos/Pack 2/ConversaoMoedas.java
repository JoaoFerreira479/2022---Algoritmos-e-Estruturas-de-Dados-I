package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoMoedas {

    // Constantes para as taxas de conversão
    private static final double TAXA_EURO = 5.21; // Taxa de conversão para euro
    private static final double TAXA_DOLAR = 4.74; // Taxa de conversão para dólar

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do valor em reais
            double valorReais = lerValorDouble(scanner, "Digite o valor em reais (R$): ");

            // Validação do valor
            validarValor(valorReais);

            // Conversões
            double valorEmEuros = converterMoeda(valorReais, TAXA_EURO);
            double valorEmDolares = converterMoeda(valorReais, TAXA_DOLAR);

            // Exibição dos resultados
            exibirResultados(valorEmEuros, valorEmDolares);

        } catch (IllegalArgumentException e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número decimal válido.");
        } finally {
            scanner.close();
        }
    }

    // Método para validar o valor em reais
    private static void validarValor(double valorReais) {
        if (valorReais < 0) {
            throw new IllegalArgumentException("O valor em reais não pode ser negativo.");
        }
    }

    // Método genérico para converter moeda com base em uma taxa
    private static double converterMoeda(double valorReais, double taxa) {
        return valorReais / taxa;
    }

    // Método para exibir os resultados
    private static void exibirResultados(double valorEmEuros, double valorEmDolares) {
        System.out.printf("O valor em euros é: € %.2f%n", valorEmEuros);
        System.out.printf("O valor em dólares é: $ %.2f%n", valorEmDolares);
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
