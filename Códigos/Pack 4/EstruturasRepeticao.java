package estruturasrepeticao;

public class EstruturasRepeticao {

    public static void main(String[] args) {
        System.out.println("Imprimindo os números de 5 a 15 usando diferentes estruturas de repetição:");

        // Usando while
        System.out.println("\nUsando while:");
        imprimirComWhile(5, 15);

        // Usando do-while
        System.out.println("\nUsando do-while:");
        imprimirComDoWhile(5, 15);

        // Usando for
        System.out.println("\nUsando for:");
        imprimirComFor(5, 15);

        System.out.println(); // Quebra de linha final
    }

    // Método para imprimir números usando while
    private static void imprimirComWhile(int inicio, int fim) {
        int i = inicio;
        while (i <= fim) {
            System.out.print(i + " ");
            i++;
        }
    }

    // Método para imprimir números usando do-while
    private static void imprimirComDoWhile(int inicio, int fim) {
        int i = inicio;
        do {
            System.out.print(i + " ");
            i++;
        } while (i <= fim);
    }

    // Método para imprimir números usando for
    private static void imprimirComFor(int inicio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            System.out.print(i + " ");
        }
    }
}
