package es.dam.alumno;

import es.dam.visualizador.Visualizador;

/** Escribe aquí cualquier algoritmo. El visualizador no conoce esta clase. */
public class Ejercicio {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Visualizador.mostrar(matriz);
        for (int fila = matriz.length - 1; fila >= 0; fila--) {
            for (int columna = matriz[fila].length - 1; columna >= 0; columna--) {
                Visualizador.visitar(fila, columna);
            }
        }
        Visualizador.marcar(0, 0);
    }
}
