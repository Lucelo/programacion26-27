import java.util.Scanner;

public class MiEntradaSalida {

    public static String leerCadena(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        String cadenaEntrada = sc.nextLine();
        return cadenaEntrada;

    }

    public static int leerEntero(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        int numerointroducio = Integer.parseInt(sc.nextLine());
        return numerointroducio;

    }

    public static double leerDouble(String cadena) {
        Scanner sc = new Scanner(cadena);

        System.out.printf("%s: ", cadena);
        double numerointroducio = Double.parseDouble(sc.nextLine());
        return numerointroducio;

    }

    static void main(String[] args) {


        System.out.println(leerCadena("leerCadena"));

        System.out.println(leerEntero("leerEntero"));

        System.out.println(leerDouble("leerDouble"));


    }

}
