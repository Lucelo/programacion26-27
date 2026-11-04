//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    System.out.print("> ");
    int n = sc.nextInt();

    int tamaño = 1000;
    int min = 0;   //
    int max = 100;

    boolean repe = false;

    contieneElemento result = getResult(tamaño, random, max, min, n, repe);

    if (result.repe()) {
        System.out.println("Esta el elemento");

    } else {
        System.out.println("No hay elementos");
    }

    System.out.println("Se encuentra " + result.repeticion());

}

private static contieneElemento getResult(int tamaño, Random random, int max, int min, int n, boolean repe) {
    int[] arr = new int[tamaño];

    for (int i = 0; i < tamaño; i++) {
        // Genera un número aleatorio entre min y max (inclusive)
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;
        arr[i] = numeroAleatorio;
    }

    int repeticion = 0;

    for (int i = 0; i < tamaño; i++) {

        if (arr[i] == n) {
            repeticion++;

            repe = true;

        }


    }
    contieneElemento result = new contieneElemento(repe, repeticion);
    return result;
}

private record contieneElemento(boolean repe, int repeticion) {
}
