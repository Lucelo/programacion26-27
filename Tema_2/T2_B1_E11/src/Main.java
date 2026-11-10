//

void main() {

    int[] array1 = {
            4, 12, 25, 38, 41, 53, 67, 72, 86, 99,
            10, 15, 22, 31, 46, 58, 63, 75, 81, 94
    };

    int[] array2 = {
            4, 12, 25, 38, 41, 53, 67, 72, 86, 99,
            3, 18, 27, 35, 49, 56, 64, 77, 83, 91
    };

    int[] array3 = new int[array1.length + array2.length];

    int posicion = 0;

    for (int i = 0; i < array1.length; i++) {

        for (int j = 0; j < array2.length; j++) {

            if (array1[i] == array2[j]) {

                array3[posicion] = array1[i];

                posicion++;

            }
        }


    }

    int[] resultado = Arrays.copyOf(array3, posicion);

    System.out.println(Arrays.toString(resultado));

}

