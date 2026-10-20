
//Realizar un programa que solicite 3 números cualesquiera y los muestre por
//pantalla ordenados de menor a mayor.
void main() {
    Scanner sc = new Scanner(System.in);

    int n1 = sc.nextInt();
    int n2 = sc.nextInt();
    int n3 = sc.nextInt();

    if (n1 > n2 && n1 > n3) {
        if (n2 > n3) {
            System.out.println(n1 + " " + n2 + " " + n3);
        }
        if (n3 > n2) {
            System.out.println(n2 + " " + n3 + " " + n1);
        }
    }else if (n2 > n1 && n2 > n3) {
        if (n3 > n1) {
            System.out.println(n1 + " " + n2 + " " + n3);
        }

        if (n3 > n2) {
            System.out.println(n2 + " " + n3 + " " + n1);
        }

    } else  {
        if (n1 > n2) {}
        if (n1 > n3) {}
        if (n2 > n3) {}
    }

}
