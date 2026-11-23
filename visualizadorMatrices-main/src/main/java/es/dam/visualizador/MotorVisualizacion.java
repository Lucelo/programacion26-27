package es.dam.visualizador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Modelo sin dependencias de JavaFX ni de los ejercicios. */
final class MotorVisualizacion {
    record Celda(int fila, int columna) {}
    record Paso(int[][] valores, boolean matriz, Celda a, Celda b, String tipo, String mensaje) {
        Paso { valores = copiar(valores); }
        @Override public int[][] valores() { return copiar(valores); }
    }
    private final int[][] datos;
    private final boolean matriz;
    private final List<Paso> pasos = new ArrayList<>();
    private final long celdas;

    MotorVisualizacion(int[] array) { this(new int[][] {Objects.requireNonNull(array, "Array nulo")}, false); }
    MotorVisualizacion(int[][] matriz) { this(matriz, true); }
    private MotorVisualizacion(int[][] datos, boolean matriz) {
        Objects.requireNonNull(datos, "Matriz nula");
        long total = 0;
        for (int[] fila : datos) total += Objects.requireNonNull(fila, "Fila nula").length;
        if (datos.length > 1000 || total > 1000) throw new IllegalArgumentException("Máximo 1000 filas y 1000 celdas");
        // Conserva las filas del alumno, pero evita cambios estructurales posteriores.
        this.datos = datos.clone();
        this.matriz = matriz;
        celdas = Math.max(1, total + datos.length);
        registrar(null, null, "inicio", "Estado inicial");
    }
    private static int[][] copiar(int[][] datos) {
        int[][] copia = new int[datos.length][];
        for (int i = 0; i < datos.length; i++) copia[i] = datos[i].clone();
        return copia;
    }
    synchronized Celda indice(int i) {
        if (matriz) throw new IllegalStateException("Para matrices usa fila y columna");
        return posicion(0, i);
    }
    synchronized Celda posicion(int f, int c) {
        if (f < 0 || f >= datos.length || c < 0 || c >= datos[f].length)
            throw new IndexOutOfBoundsException("Posición (" + f + "," + c + ") fuera de rango");
        return new Celda(f, c);
    }
    private void capacidad() {
        if (pasos.size() >= 10000 || (pasos.size() + 1L) * celdas > 2_000_000)
            throw new IllegalStateException("Límite de captura alcanzado: reduce datos o pasos");
    }
    private int valor(Celda p) { return datos[p.fila()][p.columna()]; }
    private void poner(Celda p, int valor) { datos[p.fila()][p.columna()] = valor; }
    private void registrar(Celda a, Celda b, String tipo, String mensaje) {
        capacidad();
        pasos.add(new Paso(datos, matriz, a, b, tipo, mensaje));
    }
    synchronized void visitar(Celda a) { registrar(a, null, "visita", "Visitando " + a + " = " + valor(a)); }
    synchronized int comparar(Celda a, Celda b) {
        int resultado = Integer.compare(valor(a), valor(b));
        registrar(a, b, "comparar", "Comparando " + valor(a) + " y " + valor(b));
        return resultado;
    }
    synchronized void intercambiar(Celda a, Celda b) {
        capacidad(); // Nunca modifica el array si ya no puede registrar el paso.
        int temporal = valor(a); poner(a, valor(b)); poner(b, temporal);
        registrar(a, b, "intercambiar", "Intercambio de " + a + " y " + b);
    }
    synchronized void actualizar(Celda a, int valor) {
        capacidad(); poner(a, valor);
        registrar(a, null, "actualizar", "Actualizado " + a + " a " + valor);
    }
    synchronized void marcar(Celda a) { registrar(a, null, "marcar", "Marcado " + a + " = " + valor(a)); }
    synchronized int cantidad() { return pasos.size(); }
    synchronized Paso paso(int i) { return pasos.get(i); }
}
