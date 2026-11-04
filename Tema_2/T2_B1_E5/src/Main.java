//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    int tamaño = sc.nextInt();

    int min = 0;   // Límite inferior (inclusive)
    int max = 1000;   // Límite superior (inclusive)

    int[] array = new int[tamaño];

    for (int i = 0; i < tamaño; i++) {
        // Genera un número aleatorio entre min y max (inclusive)
        int numeroAleatorio = random.nextInt((max - min) + 1) + min;
        array[i] = numeroAleatorio;
    }

    System.out.println(Arrays.toString(array));


}
