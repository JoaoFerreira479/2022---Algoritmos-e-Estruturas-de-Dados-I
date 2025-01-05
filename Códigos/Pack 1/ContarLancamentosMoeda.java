package usodeflag;

import java.util.Scanner;

public class ContarLancamentosMoeda {

    // Constantes para as opções
    private static final int CARA = 1;
    private static final int COROA = 2;
    private static final int ENCERRAR = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Inicialização dos contadores
            int contadorCara = 0;
            int contadorCoroa = 0;

            // Mensagem inicial
            exibirMensagem("Digite os lançamentos da moeda:");
            exibirMensagem(CARA + " para Cara, " + COROA + " para Coroa, " + ENCERRAR + " para encerrar.");

            // Loop principal
            while (true) {
                int entrada = lerValorInteiro(scanner, "Lançamento: ");

                if (entrada == ENCERRAR) {
                    break; // Encerra o loop
                }

                // Validação e atualização de contadores
                if (entrada == CARA) {
                    contadorCara++;
                } else if (entrada == COROA) {
                    contadorCoroa++;
                } else {
                    exibirMensagem("Entrada inválida! Digite " + CARA + " (Cara), " + COROA + " (Coroa) ou " + ENCERRAR + " para encerrar.");
                }
            }

            // Exibição dos resultados
            exibirResultados(contadorCara, contadorCoroa);

        } catch (Exception e) {
            exibirMensagemErro("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para exibir os resultados
    private static void exibirResultados(int contadorCara, int contadorCoroa) {
        exibirMensagem("Resultados dos lançamentos:");
        exibirMensagem("Cara: " + contadorCara + " ocorrência(s)");
        exibirMensagem("Coroa: " + contadorCoroa + " ocorrência(s)");
    }

    // Método para ler um valor inteiro com validação
    private static int lerValorInteiro(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (Exception e) {
                exibirMensagemErro("Entrada inválida. Por favor, digite um número inteiro válido.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    // Método para exibir mensagens gerais
    private static void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    // Método para exibir mensagens de erro
    private static void exibirMensagemErro(String mensagem) {
        System.err.println(mensagem);
    }
}

