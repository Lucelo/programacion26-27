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
        }


    }

    System.out.println("Se encuentra " + repeticion);

}
