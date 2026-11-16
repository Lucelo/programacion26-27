//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
