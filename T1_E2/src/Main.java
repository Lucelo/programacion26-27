//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
static void main() {
    Scanner sc = new Scanner(System.in);


    System.out.print("Un numero entre 0 a 10 que se desee ver su tabla: ");


    int b = sc.nextInt();


    if (b >= 0 && b <= 10) {
        for (int a = 1; a <= 10; a++) {
            System.out.println(a + " * " + b + " = " + a * b);
        }
    } else {
        System.out.println("El numero no cumple con las condiciones deseadas");
    }


}
