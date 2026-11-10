/*Crea un método que compruebe si en una matriz hay algún valor negativo, y devuelva un
valor booleano*/

void main() {

    int[][] matriz = {
            {12, 45, 23, 67, 8},
            {34, 91, -56, 14, 72},
            {5, 83, 29, 61, 40},
            {77, 18, 95, 32, 11},
            {50, 6, 43, 88, 21}
    };

    boolean negativo = false;

    for (int[] ints : matriz) {
        for (int anInt : ints) {

            if (anInt <= -1) {
                negativo = true;
                break;
            }

        }
    }

    if (negativo) {
        System.out.println("El negativo esta presente en la matriz");

    } else {
        System.out.println("No esta presente en la matriz");
    }


}
