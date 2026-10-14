//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
static void main() {
    Scanner sc = new Scanner(System.in);
    int a;

    do {
        System.out.println("Introduce un número positivo (mayor o igual a 1): ");
        a = sc.nextInt();

        if (a < 1) {
            System.out.println("¡Error! Debe ser un número positivo.");
        }

    } while (a < 1);

    if (a >= 1) {

        System.out.println("El resultado de " + a + " seria " + a * (a + 1) / 2);

    }

}
