package revisao1;

import java.util.Scanner;

public class IntercalarVetores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho dos vetores
            int m = lerValorInteiro(scanner, "Digite o tamanho do primeiro vetor (M): ");
            int n = lerValorInteiro(scanner, "Digite o tamanho do segundo vetor (N): ");

            validarTamanhos(m, n);

            // Preenchendo os vetores
            int[] vetor1 = preencherVetor(scanner, m, "primeiro");
            int[] vetor2 = preencherVetor(scanner, n, "segundo");

            // Intercalando os dois vetores
            int[] vetorIntercalado = intercalarVetores(vetor1, vetor2);

            // Exibindo o vetor intercalado
            System.out.println("Vetor intercalado:");
            exibirVetor(vetorIntercalado);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar os tamanhos dos vetores
    private static void validarTamanhos(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Os tamanhos dos vetores devem ser maiores que zero.");
        }
    }

    // Método para preencher um vetor
    private static int[] preencherVetor(Scanner scanner, int tamanho, String nomeVetor) {
        int[] vetor = new int[tamanho];
        System.out.printf("Digite os valores do %s vetor:%n", nomeVetor);
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = lerValorInteiro(scanner, String.format("Valor na posição %d: ", i));
        }
        return vetor;
    }

    // Método para intercalar dois vetores
    private static int[] intercalarVetores(int[] vetor1, int[] vetor2) {
        int[] intercalado = new int[vetor1.length + vetor2.length];
        int i = 0, j = 0, k = 0;

        // Intercalando os elementos dos dois vetores
        while (i < vetor1.length && j < vetor2.length) {
            intercalado[k++] = vetor1[i++];
            intercalado[k++] = vetor2[j++];
        }

        // Copiando os elementos restantes do vetor1, se houver
        while (i < vetor1.length) {
            intercalado[k++] = vetor1[i++];
        }

        // Copiando os elementos restantes do vetor2, se houver
        while (j < vetor2.length) {
            intercalado[k++] = vetor2[j++];
        }

        return intercalado;
    }

    // Método para exibir um vetor
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
