//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();

    Scanner sc = new Scanner(System.in);

    int tamaño = 1000;
    int min = 0;
    int max = 100;

    int[] arr = new int[tamaño];

    for (int i = 0; i < tamaño; i++) {
        // Genera un número aleatorio entre min y max (inclusive)
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;
        arr[i] = numeroAleatorio;
    }

    System.out.println("> ");
    int n = sc.nextInt();

    int encontrado = busqueda(arr, n);


    if (encontrado != -1) {
        System.out.println("Se ha encontrado el numero en la posicion " + encontrado);
    } else {
        System.out.println("No se ha encontrado el numero");
    }
}

private static int busqueda(int[] arr, int n) {

    for (int i = 0; i < arr.length; i++) {

        if (arr[i] == n) {
            return i;
        }

    }

    return -1;
}