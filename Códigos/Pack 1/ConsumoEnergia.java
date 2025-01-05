package usodeflag;

import java.util.Scanner;

public class ConsumoEnergia {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Inicialização de variáveis para métricas
            int contadorResidencias = 0;
            int contadorComercio = 0;
            double somaResidencias = 0.0;
            double somaComercio = 0.0;
            double somaTotal = 0.0;
            int totalConsumidores = 0;

            // Mensagem inicial
            exibirMensagem("Digite o tipo de consumidor (1 para Residência, 2 para Comércio).\nDigite 0 para encerrar.");

            // Loop principal para entrada de dados
            while (true) {
                int tipo = lerValorInteiro(scanner, "Tipo de consumidor: ");

                if (tipo == 0) {
                    break; // Encerra o loop se o tipo for 0
                }

                if (!validarTipoConsumidor(tipo)) {
                    exibirMensagem("Tipo inválido! Digite 1 (Residência), 2 (Comércio) ou 0 para encerrar.");
                    continue;
                }

                double consumo = lerValorDouble(scanner, "Digite o consumo (kWh): ");
                if (consumo < 0) {
                    exibirMensagem("Consumo inválido! O valor deve ser maior ou igual a zero.");
                    continue;
                }

                // Atualização de métricas
                if (tipo == 1) {
                    contadorResidencias++;
                    somaResidencias += consumo;
                } else {
                    contadorComercio++;
                    somaComercio += consumo;
                }

                somaTotal += consumo;
                totalConsumidores++;
            }

            // Exibição dos resultados
            exibirResultados(contadorResidencias, somaResidencias, contadorComercio, somaComercio, somaTotal, totalConsumidores);

        } catch (Exception e) {
            exibirMensagemErro("Erro inesperado: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar o tipo de consumidor
    private static boolean validarTipoConsumidor(int tipo) {
        return tipo == 1 || tipo == 2;
    }

    // Método para exibir os resultados
    private static void exibirResultados(int contadorResidencias, double somaResidencias, int contadorComercio, double somaComercio, double somaTotal, int totalConsumidores) {
        double mediaResidencias = (contadorResidencias > 0) ? somaResidencias / contadorResidencias : 0;
        double mediaComercio = (contadorComercio > 0) ? somaComercio / contadorComercio : 0;
        double mediaBairro = (totalConsumidores > 0) ? somaTotal / totalConsumidores : 0;

        exibirMensagem("Resultados:");
        exibirMensagem("Quantidade de consumidores do tipo Residência: " + contadorResidencias);
        exibirMensagem("Quantidade de consumidores do tipo Comércio: " + contadorComercio);
        exibirMensagem(String.format("Média de consumo das Residências: %.2f kWh", mediaResidencias));
        exibirMensagem(String.format("Média de consumo do Comércio: %.2f kWh", mediaComercio));
        exibirMensagem(String.format("Média de consumo do Bairro: %.2f kWh", mediaBairro));
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

    // Método para ler um valor double com validação
    private static double lerValorDouble(Scanner scanner, String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextDouble();
            } catch (Exception e) {
                exibirMensagemErro("Entrada inválida. Por favor, digite um número decimal válido.");
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

