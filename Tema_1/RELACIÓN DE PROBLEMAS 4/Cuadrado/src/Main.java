//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);
    int altura = sc.nextInt();
    int ancho = altura * 2;

    System.out.println(" Cuadrado");
    for (int i = 1; i <= altura; i++) {
        for (int j = 1; j <= altura; j++) {
            System.out.print("  *");
        }
        System.out.println();
    }

    System.out.println("rectangulo");
    for (int i = 1; i <= altura; i++) {
        for (int j = 1; j <= ancho; j++) {
            System.out.print("  *");
        }
        System.out.println();
    }

}
