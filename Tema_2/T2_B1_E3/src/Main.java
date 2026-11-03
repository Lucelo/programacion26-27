//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] arr = new int[n];

    int mayor = 0;
    int menor = 0;
    int repet = 0;
    int media = 0;

    for (int i = 0; i < n; i++) {

        arr[i] = sc.nextInt();

        media += arr[i];

    }

    for (int i = 0; i < n; i++) {
        if (arr[i] > mayor) {
            mayor = arr[i];

            repet = 0;

        } else if (arr[i] == mayor) {
            repet++;
        } else if (arr[i] < menor) {
            menor = arr[i];
        }

    }

    media = media / n;

    System.out.println("el mayor: " + mayor);
    System.out.println("el menor: " + menor);
    System.out.println("el repet: " + repet);
    System.out.println("el media: " + media);

}
