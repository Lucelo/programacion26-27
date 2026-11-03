//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();

    int cantidad = 6000;
    int min = 0;   // Límite inferior (inclusive)
    int max = 100;   // Límite superior (inclusive)

    int[] array = new int[cantidad];

    int n0 = 0;
    int n1 = 0;
    int n2 = 0;
    int n3 = 0;
    int n4 = 0;
    int n5 = 0;
    int n6 = 0;
    int n7 = 0;
    int n8 = 0;
    int n9 = 0;

    for (int i = 0; i < cantidad; i++) {
        // Genera un número aleatorio entre min y max (inclusive)
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;
        array[i] = numeroAleatorio;
    }

    for (int i = 0; i < cantidad; i++) {

        int ultimoDigito = array[i] % 10;


        if (ultimoDigito == 0)
            n0++;
        else if (ultimoDigito == 1)
            n1++;
        else if (ultimoDigito == 2)
            n2++;
        else if (ultimoDigito == 3)
            n3++;
        else if (ultimoDigito == 4)
            n4++;
        else if (ultimoDigito == 5)
            n5++;
        else if (ultimoDigito == 6)
            n6++;
        else if (ultimoDigito == 7)
            n7++;
        else if (ultimoDigito == 8)
            n8++;
        else if (ultimoDigito == 9)
            n9++;


    }

    System.out.println(Arrays.toString(array));

    double porcentajeN0 = ((double) n0 / cantidad) * 100;
    double porcentajeN1 = ((double) n1 / cantidad) * 100;
    double porcentajeN2 = ((double) n2 / cantidad) * 100;
    double porcentajeN3 = ((double) n3 / cantidad) * 100;
    double porcentajeN4 = ((double) n4 / cantidad) * 100;
    double porcentajeN5 = ((double) n5 / cantidad) * 100;
    double porcentajeN6 = ((double) n6 / cantidad) * 100;
    double porcentajeN7 = ((double) n7 / cantidad) * 100;
    double porcentajeN8 = ((double) n8 / cantidad) * 100;
    double porcentajeN9 = ((double) n9 / cantidad) * 100;

    double sumaPorcentaje = porcentajeN0 + porcentajeN1 + porcentajeN2 + porcentajeN3 + porcentajeN4 + porcentajeN5 + porcentajeN6 + porcentajeN7 + porcentajeN8 + porcentajeN9;
    double mediaPorcentaje = (porcentajeN0 + porcentajeN1 + porcentajeN2 + porcentajeN3 + porcentajeN4 + porcentajeN5 + porcentajeN6 + porcentajeN7 + porcentajeN8 + porcentajeN9) / 10;


    System.out.printf("El nº 0 se ha repetido %d el porcentaje es %.2f %%", n0, porcentajeN0);
    System.out.println();
    System.out.printf("El nº 1 se ha repetido %d el porcentaje es %.2f %%", n1, porcentajeN1);
    System.out.println();
    System.out.printf("El nº 2 se ha repetido %d el porcentaje es %.2f %%", n2, porcentajeN2);
    System.out.println();
    System.out.printf("El nº 3 se ha repetido %d el porcentaje es %.2f %%", n3, porcentajeN3);
    System.out.println();
    System.out.printf("El nº 4 se ha repetido %d el porcentaje es %.2f %%", n4, porcentajeN4);
    System.out.println();
    System.out.printf("El nº 5 se ha repetido %d el porcentaje es %.2f %%", n5, porcentajeN5);
    System.out.println();
    System.out.printf("El nº 6 se ha repetido %d el porcentaje es %.2f %%", n6, porcentajeN6);
    System.out.println();
    System.out.printf("El nº 7 se ha repetido %d el porcentaje es %.2f %%", n7, porcentajeN7);
    System.out.println();
    System.out.printf("El nº 8 se ha repetido %d el porcentaje es %.2f %%", n8, porcentajeN8);
    System.out.println();
    System.out.printf("El nº 9 se ha repetido %d el porcentaje es %.2f %%", n9, porcentajeN9);

    System.out.println();
    System.out.printf("La suma de todos los porcentajes es equivalente al %.2f", sumaPorcentaje);
    System.out.println();
    System.out.printf("La media de todos los porcentajes es equivalente al %.2f", mediaPorcentaje);


}
