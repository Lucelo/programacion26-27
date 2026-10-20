//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Scanner sc = new Scanner(System.in);

    int numero = sc.nextInt();


    int invertido = 0;

    while (numero > 0) {
        int ultimoDigito = numero % 10; // Extrae el último dígito [0.1.1]
        invertido = (invertido * 10) + ultimoDigito; // Construye el número invertido [0.1.1]
        numero = numero / 10; // Elimina el último dígito del número original [0.1.1]
    }

    System.out.println("Número invertido: " + invertido);

}
