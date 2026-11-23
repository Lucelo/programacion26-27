package es.dam.visualizador;

/** Fachada estática: una captura activa, cualquier algoritmo Java en el hilo del alumno. */
public final class Visualizador {
    private static MotorVisualizacion motor;
    private Visualizador() {}

    /** Abre la ventana sin bloquear y registra una copia del estado inicial. */
    public static synchronized void mostrar(int[] datos) { abrir(new MotorVisualizacion(datos)); }
    public static synchronized void mostrar(int[][] datos) { abrir(new MotorVisualizacion(datos)); }
    private static void abrir(MotorVisualizacion nuevo) {
        VentanaJavaFX.abrir(nuevo);
        motor = nuevo;
    }
    private static MotorVisualizacion motor() {
        if (motor == null) throw new IllegalStateException("Llama primero a Visualizador.mostrar(datos)");
        return motor;
    }
    public static synchronized void visitar(int i) { var m = motor(); m.visitar(m.indice(i)); }
    public static synchronized void visitar(int f, int c) { var m = motor(); m.visitar(m.posicion(f, c)); }
    /** Registra la comparación y devuelve negativo, cero o positivo, como Integer.compare. */
    public static synchronized int comparar(int i, int j) {
        var m = motor(); return m.comparar(m.indice(i), m.indice(j));
    }
    public static synchronized int comparar(int f1, int c1, int f2, int c2) {
        var m = motor(); return m.comparar(m.posicion(f1, c1), m.posicion(f2, c2));
    }
    /** Modifica los datos originales y registra el resultado. No repetir el intercambio a mano. */
    public static synchronized void intercambiar(int i, int j) {
        var m = motor(); m.intercambiar(m.indice(i), m.indice(j));
    }
    public static synchronized void intercambiar(int f1, int c1, int f2, int c2) {
        var m = motor(); m.intercambiar(m.posicion(f1, c1), m.posicion(f2, c2));
    }
    public static synchronized void actualizar(int i, int valor) { var m = motor(); m.actualizar(m.indice(i), valor); }
    public static synchronized void actualizar(int f, int c, int valor) { var m = motor(); m.actualizar(m.posicion(f, c), valor); }
    public static synchronized void marcar(int i) { var m = motor(); m.marcar(m.indice(i)); }
    public static synchronized void marcar(int f, int c) { var m = motor(); m.marcar(m.posicion(f, c)); }

    /** Alias para código antiguo; ahora también abre la ventana. */
    @Deprecated public static void iniciar(int[] datos) { mostrar(datos); }
    @Deprecated public static void iniciar(int[][] datos) { mostrar(datos); }
}
