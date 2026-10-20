//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Scanner sc = new Scanner(System.in);

    //Creamos la variable del numero
    long num;

    //solicitamos el numero si el numero no se positivo no sale
    do {
        System.out.print("> ");
        num = sc.nextInt();

    } while (num <= 0 || num >= 21);

    //La segunda variable para el resultado
    long fact = 1;

    //creamos un bucle con el for para llegar a la solucion
    for (int i = 1; i <= num; i++) {

        fact = fact * i;

    }

    //Monstramos el factol al usuario
    System.out.println("El factorial de " + num + " es " + fact);

    sc.close();
}
