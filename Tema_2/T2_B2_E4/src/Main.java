/* Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
misma, leídos por filas, empezando por los últimos índices: */

void main() {

    int[][] matriz = {
            {28, 7, 64, 91, 35},
            {52, 16, 83, 4, 70},
            {11, 76, 43, 59, 22},
            {97, 31, 68, 14, 85},
            {40, 3, 72, 56, 19}
    };

    for (int i = matriz.length - 1; i >= 0; i--) {
        for (int j = matriz[i].length - 1; j >= 0; j--) {
            System.out.print(matriz[i][j] + " ");
        }
    }


}
