
//Crea un array que devuelva un nuevo array donde se hayan eliminado los elementos
//duplicados del primero.

void main() {

    int[][] matrix = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};

    int[] numeros = new int[30];

    int num = 0;

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            numeros[num++] = matrix[i][j];
        }
    }

    for (int i = 0; i < numeros.length; i++) {
        for (int j = 0; j < numeros.length; j++) {
            if (i != j) {
                if (numeros[i] == numeros[j]) {
                    numeros[i] = 0;
                }
            }
        }
    }

    int num2 = 0;

    for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
            matrix[i][j] = numeros[num2++];
        }
    }

    System.out.println(Arrays.deepToString(matrix));

}
