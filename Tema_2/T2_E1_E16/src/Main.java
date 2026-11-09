
//Crea un programa que cree una matriz de Nx10, donde el usuario introducirá el
//número N por teclado. El sistema creará entonces la tabla de multiplicar de los N
//primeros números e introducirá el resultado en las casillas correspondientes del
//array, como en el siguiente ejemplo:


void main() {

    Scanner sc = new Scanner(System.in);
    System.out.print("> ");
    int n = sc.nextInt();

    int[][] arr = new int[n][10];

    for (int i = 0; i < n; i++) {

        for (int j = 0; j < 10; ++j) {

            arr[i][j] = (i + 1) * (j + 1);
        }

        System.out.println(Arrays.toString(arr[i]));

    }

}
