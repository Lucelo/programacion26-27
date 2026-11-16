
//Crear un método que devuelva el número de casilla a la que corresponden unas
//coordenadas. Es decir, el número de casilla empezando por la casilla [0,0], y recorriendo
//primero por filas y luego por columnas. Por ejemplo, la casilla [1,5] en una matriz de 6x6
//ocuparía el número 12. En la misma matriz, la casilla [4,0] ocuparía el número 25.

void main() {
    Scanner sc = new Scanner(System.in);
    System.out.print(">");
    int n = sc.nextInt();
    System.out.print(">");
    int m = sc.nextInt();

    int [][] matrix = new int[n][m];

    int num=1;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            matrix[i][j] = num++;
        }
    }





}
