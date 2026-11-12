
//Modifica el método anterior y acepta un parámetro “reverse”, que indique si el array
//debe devolverse ordenado de menor a mayor o al revés

void main() {

    Scanner sc = new Scanner(System.in);

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

    int[] ordenar = new int[25];

    sumaDeMatrices(matriz1, matriz3, matriz2);

    System.out.println("Defina con numeros: 1 ordenar la matriz de menor a mayor, " +
            "2 ordenar la matriz de mayor a menor, 3 dejar como esta ");

    int opcNum = sc.nextInt();

    almacenar(ordenar, matriz3);

    switch (opcNum) {
        case 1: {

            int num = 0;

            for (int i = 0; i < matriz3.length; i++) {
                for (int j = 0; j < matriz3[i].length; j++) {
                    matriz3[i][j] = ordenar[num++];
                }
            }
            break;
        }

        case 2: {

            int num = ordenar.length;

            for (int i = 0; i < matriz3.length; i++) {
                for (int j = 0; j < matriz3[i].length; j++) {
                    matriz3[i][j] = ordenar[--num];
                }
            }

            break;
        }


        case 3:
            break;

        default:
            System.out.println("No se ha introducido la opcion correctamente");

    }


    System.out.println(Arrays.deepToString(matriz3));

}

private static void almacenar(int[] ordenar, int[][] matriz3) {
    int num = 0;

    for (int[] ints : matriz3) {
        for (int anInt : ints) {
            ordenar[num++] = anInt;
        }
    }

    Arrays.sort(ordenar);

}

private static void sumaDeMatrices(int[][] matriz1, int[][] matriz3, int[][] matriz2) {
    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
        }
    }

}


