//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    int[] arrayConNegativos = {17, -42, 83, 6, -15, 29, 54, -7, 91, 0, -63, 38, 12, -24, 76, 5, -89, 43, 21, -36, 68, -3, 97, 14, -51, 32, 8, -72, 59, 26, -18, 84, -45, 11, 63, -9, 47, -31, 2, 79, -56, 35, 19, -94, 71, -12, 50, 4, -67, 88};

    int numDeNegativos = 0;

    for (int arrayConNegativo : arrayConNegativos) {

        if (arrayConNegativo <= -1) {

            numDeNegativos++;

        }

    }

    System.out.println("La cantidad de numeros negativos es " + numDeNegativos);

}
