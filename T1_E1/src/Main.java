//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
static void main() {


    for (int a = 0; a <= 100; a++) {

        if (a % 7 == 0 && a % 13 == 0) {
            System.out.println("El " + a + " es multiplo de 7 y 13 ");


        } else if (a % 7 == 0) {
            System.out.println("El " + a + " es multiplo de 7");


        } else if (a % 13 == 0) {
            System.out.println("El " + a + " es multiplo de 13");


        } else {
            System.out.println("El " + a + " no es multiplo de 7 o 13 ");
        }


    }
}