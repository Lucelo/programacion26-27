
//

void main() {

    int[] array1 = {
            37, 4, 19, 42, 8, 25, 11, 49, 2, 33,
            16, 45, 6, 28, 40, 13, 50, 21, 9, 35,
            1, 3
    };

    int[] array2 = new int[array1.length];

    Arrays.sort(array1);

    int inversor = array1.length;


    for (int j : array1) {

        inversor--;

        array2[inversor] = j;

    }
    System.out.println(Arrays.toString(array1));

    System.out.println(Arrays.toString(array2));

}
