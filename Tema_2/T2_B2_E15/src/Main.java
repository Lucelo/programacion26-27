
//Crea un método que compruebe, sobre una matriz de enteros, cuántas casillas
//adyacentes tienen valores pares. Se considera adyacente todas las posiciones
//colindantes, incluidas las diagonales. En el siguiente ejemplo, el 7 (en rojo) tiene 4
//casillas colindantes con números pares. El resultado se deberá guardar en otra matriz,
//que contendrá dichos números. Para este ejercicio, consideraremos que el 0 es par.

void main() {


    int[][] matrix1 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 0},
            {3, 2, 1, 4, 5},
            {9, 5, 8, 6, 7},
            {0, 9, 8, 5, 4}
    };

    int[][] matrix2 = new int[matrix1.length][matrix1[0].length];

    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1[0].length; j++) {
            matrix2[i][j] = matrix1[i][j];
        }
    }

    for (int i = 0; i < matrix1.length; i++) {
        for (int j = 0; j < matrix1[i].length; j++) {
            int num = 0;
            for (int i1 = -1; i1 <= 1; i1++) {
                for (int k1 = -1; k1 <= 1; k1++) {
                    if (i + i1 >= 0 && i + i1 < matrix1.length && j + k1 >= 0 && j + k1 < matrix1[i].length) {
                        if (!(i1 == 0 && k1 == 0) && matrix1[i + i1][j + k1] % 2 == 0) {
                            num++;
                        }
                    }
                }
            }
            matrix2[i][j] = num;
        }
    }

    for (int[] ints : matrix2) {
        System.out.println(Arrays.toString(ints));
    }

}
