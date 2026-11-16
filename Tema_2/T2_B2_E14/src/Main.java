
//Crea un método que transforme una matriz cualquiera, convirtiendo sus filas en
//columnas y viceversa

void main() {

    int[][] matriz1 = {
            {12, 45, 78, 23, 91, 34, 67, 15},
            {82, 56, 73, 29, 41, 96, 18, 52},
            {84, 37, 61, 10, 99, 26, 48, 70},
            {33, 14, 85, 62, 19, 57, 43, 88}
    };

    int[][] matriz2 = new int[8][4];

    for (int i = 0; i < matriz1[0].length; i++) {
        for (int j = 0; j < matriz1.length; j++) {
            matriz2[i][j] = matriz1[j][i];
        }
    }
    for (int[] ints : matriz1) {
        System.out.println(Arrays.toString(ints));
    }

    System.out.println();

    for (int[] ints : matriz2) {
        System.out.println(Arrays.toString(ints));
    }

}
