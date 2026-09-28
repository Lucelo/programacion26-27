//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
static void main() {
    Scanner sc = new Scanner(System.in);


    System.out.print("Introduce un número positivo: ");


    int a = sc.nextInt();


    if (a >= 1) {


        System.out.println("El resultado de " + a + " seria " + a * (a + 1) / 2);


    }


}
