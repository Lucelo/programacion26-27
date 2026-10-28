//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    int[] arrayDeNum = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    int sumaDePares = 0;
    int sumaDeImpares = 0;
    for (int i = 0; i < arrayDeNum.length; i++) {

        if (i % 2 == 0) {
            sumaDePares += arrayDeNum[i];
        }
        if (i % 2 == 1) {
            sumaDeImpares += arrayDeNum[i];
        }


    }

    System.out.println("El resultadod de los pares es " + sumaDePares);

    System.out.println("El resultadod de los impares es " + sumaDeImpares);
}
