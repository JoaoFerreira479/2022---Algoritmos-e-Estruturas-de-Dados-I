package conceitosbasicosprogramacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversaoTempo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada da quantidade de minutos
            int minutos = lerValorInteiro(scanner, "Digite a quantidade de minutos: ");

            // Validação do valor
            validarMinutos(minutos);

            // Conversão para o formato horas:minutos:segundos
            String resultado = converterMinutosParaHorasMinutosSegundos(minutos);

            // Exibição do resultado
            exibirResultado(resultado);

        } catch (IllegalArgumentException e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } catch (InputMismatchException e) {
            exibirMensagemErro("Erro: Entrada inválida. Certifique-se de digitar um número inteiro.");
        } finally {
            scanner.close();
        }
    }

    // Método para validar os minutos
    private static void validarMinutos(int minutos) {
        if (minutos < 0) {
            throw new IllegalArgumentException("A quantidade de minutos não pode ser negativa.");
        }
    }

    // Método para converter minutos no formato horas:minutos:segundos
    private static String converterMinutosParaHorasMinutosSegundos(int totalMinutos) {
        int horas = totalMinutos / 60; // Calcula o número de horas
        int minutos = totalMinutos % 60; // Calcula os minutos restantes
        int segundos = 0; // Segundos fixos em 0, pois a entrada é em minutos completos

        // Retorna o tempo formatado como HH:MM:SS
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    // Método para exibir o resultado
    private static void exibirResultado(String resultado) {
        System.out.printf("O tempo convertido é: %s%n", resultado);
    }

    // Método para ler um valor inteiro com validação
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
