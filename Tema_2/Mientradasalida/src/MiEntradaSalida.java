import java.util.Scanner;


public class MiEntradaSalida {


    public static String leerCadena(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        return sc.nextLine();

    }

    public static int leerEntero(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        return Integer.parseInt(sc.nextLine());

    }

    public static double leerDouble(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        return Double.parseDouble(sc.nextLine());

    }

    public static int leerEnteroRfango(String cadena, int min, int max) {
        Scanner sc = new Scanner(cadena);
        System.out.printf("%s: ", cadena);
        int numerointroducio;
        do {
            numerointroducio = Integer.parseInt(sc.nextLine());
            if (numerointroducio < min || numerointroducio > max) {
                System.out.printf("%s: ", cadena);
            }

        } while (numerointroducio > min || numerointroducio < max);

        return numerointroducio;

    }

    public static char leerCaracter(String cadena) {
        Scanner sc = new Scanner(cadena);
        System.out.printf("%s: ", cadena);
        char caracter = sc.nextLine().charAt(0);
        return caracter;

    }

    public static String leerSiNO() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("%s: ", sc.nextLine());
        return sc.nextLine();

    }

    static void main(String[] args) {

        System.out.println(leerCadena("leerCadena"));

        System.out.println(leerEntero("leerEntero"));

        System.out.println(leerDouble("leerDouble"));

        System.out.println(leerCaracter("leerCaracter"));

        System.out.println(leerSiNO());

    }

}
