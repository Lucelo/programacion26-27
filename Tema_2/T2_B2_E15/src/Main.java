
//Crear un método que devuelva el número de casilla a la que corresponden unas
//coordenadas. Es decir, el número de casilla empezando por la casilla [0,0], y recorriendo
//primero por filas y luego por columnas. Por ejemplo, la casilla [1,5] en una matriz de 6x6
//ocuparía el número 12. En la misma matriz, la casilla [4,0] ocuparía el número 25
void main() {


    Scanner sc = new Scanner(System.in);
    int[][] matrix = new int[10][10];

    int num = 0;

    System.out.print("> ");
    int bus = sc.nextInt();

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            matrix[i][j] = num++;
        }
    }

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (matrix[i][j] == bus) {

                System.out.println("El numero se encuentra en la casilla [" + i + ", " + j + "]");
                break;
            }
        }
    }


}
