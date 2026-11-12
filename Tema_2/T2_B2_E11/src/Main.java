
//Crea un método que acepte 2 arrays, y devuelva un nuevo array con los elementos
//que ambos arrays tienen en común.

void main() {

    int[][] matriz1 = {
            {12, 45, 78, 23, 91},
            {34, 67, 15, 82, 56},
            {73, 29, 41, 96, 18},
            {52, 84, 37, 61, 10},
            {99, 26, 48, 70, 33}
    };

    int[][] matriz2 = {
            {12, 11, 78, 65, 91},
            {34, 22, 15, 44, 56},
            {19, 29, 41, 13, 18},
            {52, 84, 88, 61, 77},
            {31, 26, 59, 70, 20}
    };

    int[][] matriz3 = new int[5][5];

    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            if (matriz1[i][j] == matriz2[i][j]) {
                matriz3[i][j] = matriz1[i][j];
            }
        }
    }

    System.out.println(Arrays.deepToString(matriz3));


}
