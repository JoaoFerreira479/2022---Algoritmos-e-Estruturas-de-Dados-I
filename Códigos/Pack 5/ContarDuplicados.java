package revisao1;

import java.util.HashMap;
import java.util.Scanner;

public class ContarDuplicados {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Entrada do tamanho do vetor
            int n = lerValorInteiro(scanner, "Digite o tamanho do vetor: ");
            validarTamanhoVetor(n);

            // Preenchendo o vetor com valores do usuário
            int[] vetor = preencherVetor(scanner, n);

            // Contando os elementos duplicados
            int numDuplicados = contarDuplicados(vetor);

            // Exibindo o resultado
            exibirResultado(numDuplicados);

        } catch (Exception e) {
            exibirMensagemErro("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para validar o tamanho do vetor
    private static void validarTamanhoVetor(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O vetor deve ter pelo menos 1 elemento.");
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

    // Método para contar o número de elementos duplicados em um vetor
    private static int contarDuplicados(int[] vetor) {
        HashMap<Integer, Integer> frequencia = new HashMap<>();
        int contadorDuplicados = 0;

        // Contando a frequência de cada elemento
        for (int elemento : vetor) {
            frequencia.put(elemento, frequencia.getOrDefault(elemento, 0) + 1);
        }

        // Verificando os elementos duplicados
        for (int valor : frequencia.values()) {
            if (valor > 1) {
                contadorDuplicados++;
            }
        }

        return contadorDuplicados;
    }

    // Método para exibir o resultado
    private static void exibirResultado(int numDuplicados) {
        System.out.printf("O número de elementos duplicados no vetor é: %d%n", numDuplicados);
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
