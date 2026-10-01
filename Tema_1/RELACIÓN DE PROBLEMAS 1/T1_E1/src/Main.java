//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escribe dos numeros por teclado");

    System.out.print("> ");
    int n1 = sc.nextInt();

    System.out.print("> ");
    int n2 = sc.nextInt();

    if (n1 > n2) {
        System.out.printf("El %d es mayor a el %d", n1, n2);

    } else if (n1 < n2) {
        System.out.printf("El %d es menor a el %d", n1, n2);

    } else {
        System.out.println("El primer numero es igual a el segundo");

    }

}
