
//Crea un método que transforme una matriz CUADRADA (tienes que realizar dicha
//comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal (de
//abajo a la derecha a arriba a la izquierda):

void main() {



    int[][] matriz1 = {
            {12, 45, 78, 23, 91},
            {34, 67, 15, 82, 56},
            {73, 29, 41, 96, 18},
            {52, 84, 37, 61, 10},
            {99, 26, 48, 70, 33}
    };

    int[][] matriz2 = new int[matriz1.length][matriz1.length];

    for (int i = 0; i < matriz1.length; i++) {
        for (int j = 0; j < matriz1[i].length; j++) {
            matriz2[i][j] = matriz1[i][(matriz1[i].length-1)-j];
        }
    }

    for (int i = 0; i < matriz2.length; i++) {
        System.out.println(Arrays.toString(Arrays.stream(matriz1[i]).toArray()));
    }

    System.out.println();

    for (int[] ints : matriz2) {
        System.out.println(Arrays.toString(Arrays.stream(ints).toArray()));
    }

}
