package revisao1;

import java.util.Scanner;

public class SegundoMaiorElemento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho do vetor
            int n = lerValorInteiro(scanner, "Digite o tamanho do vetor (N): ");
            validarTamanhoVetor(n);

            // Preenchendo o vetor com valores do usuário
            int[] vetor = preencherVetor(scanner, n);

            // Encontrando o segundo maior elemento
            int segundoMaior = encontrarSegundoMaior(vetor);

            // Exibindo o resultado
            exibirResultado(segundoMaior);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar o tamanho do vetor
    private static void validarTamanhoVetor(int tamanho) {
        if (tamanho < 2) {
            throw new IllegalArgumentException("O vetor deve ter pelo menos 2 elementos.");
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

    // Método para encontrar o segundo maior elemento do vetor
    private static int encontrarSegundoMaior(int[] vetor) {
        int maior = Integer.MIN_VALUE;
        int segundoMaior = Integer.MIN_VALUE;

        for (int valor : vetor) {
            if (valor > maior) {
                segundoMaior = maior; // Atualiza o segundo maior
                maior = valor;       // Atualiza o maior
            } else if (valor > segundoMaior && valor != maior) {
                segundoMaior = valor; // Atualiza o segundo maior, se aplicável
            }
        }

        if (segundoMaior == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Não foi possível encontrar um segundo maior elemento.");
        }

        return segundoMaior;
    }

    // Método para exibir o resultado
    private static void exibirResultado(int segundoMaior) {
        System.out.printf("O segundo maior elemento do vetor é: %d%n", segundoMaior);
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
