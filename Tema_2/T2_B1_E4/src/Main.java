//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();

    int cantidad = 6000;
    int min = 0;   // Límite inferior (inclusive)
    int max = 100;   // Límite superior (inclusive)

    int[] array = new int[cantidad];

    int[] contador = new int[10];

    for (int i = 0; i < cantidad; i++) {
        // Genera un número aleatorio entre min y max (inclusive)
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;
        array[i] = numeroAleatorio;
    }

    for (int i = 0; i < array.length; i++) {

        int ultimoDigito = array[i] % 10;

        contador[ultimoDigito]++;

    }

    System.out.println(Arrays.toString(array));

    double sumaPorcentaje = 0;

    for (int i = 0; i < contador.length; i++) {
        double porcentaje = ((double) contador[i] / cantidad) * 100;

        sumaPorcentaje += porcentaje;

        System.out.printf("El nº %d se ha repetido %d veces. Equivale a %.2f %%\n", i, contador[i], porcentaje);

    }

    double mediaPorcentaje = sumaPorcentaje / contador.length;

    System.out.println();
    System.out.printf("La suma de todos los porcentajes es equivalente al %.2f", sumaPorcentaje);
    System.out.println();
    System.out.printf("La media de todos los porcentajes es equivalente al %.2f", mediaPorcentaje);

}
