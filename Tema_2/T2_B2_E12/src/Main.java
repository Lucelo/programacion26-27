
//Crea un método que transforme una matriz CUADRADA (tienes que realizar dicha
//comprobación) que recibe por parámetro, en otra, que debe ser su reflejo en diagonal (de
//arriba a la izquierda a abajo a la derecha):

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
            matriz2[i][j] = matriz1[j][i];
        }
    }

    System.out.println(Arrays.deepToString(matriz1));

    System.out.println(Arrays.deepToString(matriz2));



}
