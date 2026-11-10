/* Crea un método que sume todas las posiciones de una matriz y devuelva dicho número.
 */
void main() {

    int[][] matriz = {
            {14, 32, -7, 81, 25},
            {63, 19, 44, 5, 92},
            {8, -35, 71, 26, 13},
            {47, 56, 90, 12, 38},
            {21, 76, 3, 64, 59}
    };

    int sumatotal = 0;

    sumatotal = getSumatotal(matriz, sumatotal);

    System.out.println(sumatotal);
}

private static int getSumatotal(int[][] matriz, int sumatotal) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            sumatotal += matriz[i][j];
        }
    }
    return sumatotal;
}
