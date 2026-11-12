
//Crea un método que acepte un array de enteros y devuelva el mismo array ordenado
//de menor a mayor. Utiliza para ello el método de ordenación de la burbuja.

void main() {

    int[][] matriz1 = {
            {12, 45, 78, 23, 91},
            {34, 67, 15, 82, 56},
            {73, 29, 41, 96, 18},
            {52, 84, 37, 61, 10},
            {99, 26, 48, 70, 33}
    };

    int [] ordenado = new int[25];

    int num =0;

    for (int[] ints : matriz1) {
        for (int anInt : ints) {
            ordenado[num++] = anInt;
        }
    }

    Arrays.sort(ordenado);

    num =0;

    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            matriz1[i][j] = ordenado[num++];
        }
    }

    System.out.println(Arrays.toString(matriz1));

}
