import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    // Preparación de la tanda
    int vuelta = 0;
    int vueltaRealizada = 0;
    int vueltaMejorada = 0;

    double tiempo = 0;
    double tiempoAnterior = 0;
    double tiempoTotal = 0;

    boolean mejorPrimeravuelta = true;
    double mejorTiempo = 0;
    double mejortiempoobjetivo = 0;
    int mejorVuelta = 0;

    System.out.println("Ingrese el nombre del piloto: ");
    String piloto = sc.nextLine();

    // El usuario ha de introducir el numero de vueltas
    do {

        System.out.println("Numero de vueltas que se va a realizar entre 3 y 10: ");
        vuelta = sc.nextInt();

    } while (vuelta <= 2 || vuelta >= 11);

    //El usuario ha de introducir el tiempo objetivo hasta que no lo hace no continua
    do {

        System.out.println("Cual a de ser el tiempo objetibo: ");
        mejortiempoobjetivo = sc.nextDouble();

    } while (mejortiempoobjetivo <= 0);

    //Registro de las vueltas
    for (int i = 0; i < vuelta; i++) {

        //El usuario a de introducir el tiempo de la vuelta
        do {
            System.out.println("Marca de tiempo ");
            tiempo = sc.nextDouble();

        } while (tiempo <= 0);

        //Compara los marcadores aun que hay que corregir lo de mejor vuelta ya que siempre introducira la primera
        if (tiempo < tiempoAnterior) {
            System.out.println("«Objetivo mejorado»");
            tiempoAnterior = tiempo;
            tiempoTotal += tiempo;
            vueltaRealizada++;
            vueltaMejorada++;

            if (mejorPrimeravuelta) {
                mejorPrimeravuelta = false;

                mejorTiempo = tiempo;
                mejorVuelta = i;

            }

        } else if (tiempo == tiempoAnterior) {
            System.out.println("«Objetivo igualado»");

            tiempoAnterior = tiempo;
            tiempoTotal += tiempo;
            vueltaRealizada++;
        } else if (tiempo > tiempoAnterior) {
            System.out.println("«Por encima del objetivo»");

            tiempoAnterior = tiempo;
            tiempoTotal += tiempo;
            vueltaRealizada++;
        }


    }

    //hace los calculos del tiempo medio
    double tiempoMedio = tiempoTotal / vueltaRealizada;

    //Informe de la tanda

    System.out.println("Nombre del piloto: " + piloto);
    System.out.println("Tiempo total de la tanda: " + tiempoTotal);
    System.out.println("Tiempo medio por vuelta: " + tiempoMedio);
    System.out.println("Mejor tiempo conseguido y  vuelta en la que se consiguió: " + mejorTiempo + " Fue en la vuelta " + mejorVuelta);
    System.out.println("Cantidad de vueltas que mejoraron estrictamente el tiempo objetivo: " + vueltaMejorada);

    //Decisión del equipo
    /*
     *
     * No conseguido por falta de tiempo
     *
     * */


}
