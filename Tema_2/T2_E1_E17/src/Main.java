
//Realiza un programa que copie una matriz en otra.
// Comprueba los tamaños.

void main() {

    int[][] matriz1 = {
            {12, 45, 23, 67, 8},
            {34, 91, 56, 14, 72},
            {5, 83, 29, 61, 40},
            {77, 18, 95, 32, 11},
            {50, 6, 43, 88, 21}
    };

    int[][] matriz2 = {matriz1[0], matriz1[1], matriz1[2], matriz1[3], matriz1[4]};


    System.out.println(Arrays.deepToString(matriz2));
}
