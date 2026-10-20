//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la altura del árbol (n): ");
        int n = sc.nextInt();
        int m = n / 2;

        // Hojas del árbol
        for (int i = 0; i < n; i++) {

            // Espacios en blanco (decrecen a medida que baja la fila)
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // Asteriscos (crecen en número impar por cada fila: 1, 3, 5...)
            for (int k = 1; k <= (2 * i) + 1; k++) {
                System.out.print("*");
            }

            // Salto de línea al terminar cada fila
            System.out.println();
        }

        // Tronco del árbol
        for (int i = 0; i < m; i++) {

            // Espacios en blanco para centrar el tronco debajo de las hojas
            for (int j = 1; j <= n - 1; j++) {
                System.out.print(" ");
            }

            // Asteriscos del tronco (ancho constante de 3)
            for (int k = 1; k <= (n/4); k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        sc.close();
    }
}
