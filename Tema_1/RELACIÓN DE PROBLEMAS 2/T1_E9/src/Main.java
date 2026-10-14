//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero;

        // 1. VALIDACIÓN: Pedir número positivo obligatoriamente
        do {
            System.out.print("Introduce un número entero positivo: ");
            numero = sc.nextInt();

            if (numero <= 0) {
                System.out.println("¡Dato incorrecto! El número debe ser mayor que 0.");
            }
        } while (numero <= 0);

        // 2. CÁLCULO DE DIVISORES Y SUMA
        int sumaDivisores = 0;

        // Recorremos desde 1 hasta la mitad del número (ningún divisor propio es mayor que la mitad)
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) { // Si 'i' es divisor exacto
                sumaDivisores += i; // Lo acumulamos en la suma
            }
        }

        // 3. COMPROBACIÓN FINAL
        if (sumaDivisores == numero) {
            System.out.println("¡El " + numero + " es un número perfecto!");
        } else {
            System.out.println("El " + numero + " NO es un número perfecto.");
        }

        sc.close();
    }
}
