/* Crea un método que reciba una matriz e imprima, en una sola línea, los elementos de la
misma, pero leídos por columnas: */
void main() {

    int[][] matriz = {
            {62, 15, 89, 34, 71},
            {6, 48, 93, 27, 55},
            {81, 20, 43, 76, 12},
            {37, 95, 8, 64, 29},
            {50, 17, 72, 3, 86}
    };

    for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
            System.out.print(matriz[j][i] + " ");
        }
    }
}
