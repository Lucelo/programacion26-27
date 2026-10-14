//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

void main() {

    Scanner sc = new Scanner(System.in);
    int n = 0;

    int c = 0;

    System.out.println("Cuantos  numeros vas a introducir");

    System.out.printf(">");

    int m = sc.nextInt();

    for (int i = 0; i < m; i++) {

        System.out.printf(">");

        n = sc.nextInt();

        c += n;

    }

    System.out.println("El resultado es " + (c / m));

}
