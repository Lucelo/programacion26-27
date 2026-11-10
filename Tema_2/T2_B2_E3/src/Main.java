/*Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
misma, leídos por filas:*/

void main() {

    int[][] matriz = {
            {17, 42, 83, 26, 51},
            {34, 69, 12, 95, 48},
            {72, 5, 38, 61, 24},
            {89, 31, 56, 14, 77},
            {43, 98, 21, 65, 10}
    };

    imprimir(matriz);


}

private static void imprimir(int[][] matriz) {
    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[i][j] + " ");
        }
    }
}
