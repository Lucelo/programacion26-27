/*  Crea un método que reciba dos matrices, que deben ser de igual tamaño, y sume el
contenido de las posiciones en una tercera matriz, que será la que devuelva: */

void main() {

    int[][] matriz1 = {
            {17, 42, 83, 26, 51},
            {34, 69, 12, 95, 48},
            {72, 5, 38, 61, 24},
            {89, 31, 56, 14, 77},
            {43, 98, 21, 65, 10}
    };

    int[][] matriz2 = {
            {28, 7, 64, 91, 35},
            {52, 16, 83, 4, 70},
            {11, 76, 43, 59, 22},
            {97, 31, 68, 14, 85},
            {40, 3, 72, 56, 19}
    };

    int[][] matriz3 = new int[5][5];

    sumaDeMatrices(matriz1, matriz3, matriz2);

    System.out.println(Arrays.deepToString(matriz3));

}

private static void sumaDeMatrices(int[][] matriz1, int[][] matriz3, int[][] matriz2) {
    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }
}
