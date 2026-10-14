//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Scanner sc = new Scanner(System.in);

    System.out.println("Digame el primer numero");
    System.out.print(">");

    int menor = sc.nextInt();
    boolean salir1 = true;
    boolean salir2 = true;

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    do {

        System.out.println("Digame los sigientes 3 numeros");

        System.out.print(">");
        int num1 = sc.nextInt();

        System.out.print(">");
        int num2 = sc.nextInt();

        System.out.print(">");
        int num3 = sc.nextInt();

        sc.nextLine();

        if (menor > num1 || menor > num2 || menor > num3) {

            if (menor > num1) {
                menor = num1;
            }
            if (menor > num2) {
                menor = num2;
            }
            if (menor > num3) {
                menor = num3;
            }

        }

        String respuesta;

        do {
            System.out.println("Diga ´S´ para continuar y 'N' para salir");
            respuesta = sc.nextLine();


            if (respuesta.equals("N") || respuesta.equals("S")) {
                salir2 = false;
            }


        } while (salir2);

        if (respuesta.equals("N")) {
            salir1 = false;
        }

    } while (salir1);

    System.out.printf("El numero mas pequeño ha sido el %d", menor);

}
