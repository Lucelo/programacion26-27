// Rehacer mas tarde
void main() {

    int[] arrayDuplicado = {4, 4, 4, 5, 3, 6, 7, 453, 543, 453, 34, 32, 63, 6, 23, 6537, 25, 65, 76, 26, 5};

    int[] arraySinDuplicado = new int[arrayDuplicado.length];

    for (int i = 0; i < arrayDuplicado.length; i++) {

        for (int j = i + 1; j < arraySinDuplicado.length; j++) {

            if (arrayDuplicado[i] != arraySinDuplicado[j]) {

                arraySinDuplicado[j] = arrayDuplicado[i];

            }

        }

    }

    System.out.println(Arrays.toString(arrayDuplicado));

    System.out.println(Arrays.toString(arraySinDuplicado));

}
