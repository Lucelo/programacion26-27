package es.dam.visualizador;

import org.junit.Test;
import static org.junit.Assert.*;

public class MotorVisualizacionTest {
    @Test public void burbujaModificaOriginalPeroConservaHistoria() {
        int[] a = {8, 3, 6, 2, 5};
        var m = new MotorVisualizacion(a);
        for (int fin = a.length - 1; fin > 0; fin--)
            for (int j = 0; j < fin; j++)
                if (m.comparar(m.indice(j), m.indice(j + 1)) > 0)
                    m.intercambiar(m.indice(j), m.indice(j + 1));
        assertArrayEquals(new int[]{2, 3, 5, 6, 8}, a);
        assertArrayEquals(new int[]{8, 3, 6, 2, 5}, m.paso(0).valores()[0]);
        assertArrayEquals(a, m.paso(m.cantidad() - 1).valores()[0]);
        int[][] copia = m.paso(0).valores(); copia[0][0] = 999;
        assertEquals(8, m.paso(0).valores()[0][0]);
    }
    @Test public void recorridoInversoIrregularYOperacionesDeMatriz() {
        int[][] datos = {{1, 2}, {}, {3}};
        var m = new MotorVisualizacion(datos);
        for (int f = datos.length - 1; f >= 0; f--)
            for (int c = datos[f].length - 1; c >= 0; c--) m.visitar(m.posicion(f, c));
        assertEquals(new MotorVisualizacion.Celda(2, 0), m.paso(1).a());
        assertEquals(new MotorVisualizacion.Celda(0, 0), m.paso(3).a());
        assertTrue(m.comparar(m.posicion(0, 0), m.posicion(2, 0)) < 0);
        m.intercambiar(m.posicion(0, 0), m.posicion(2, 0));
        m.actualizar(m.posicion(0, 1), 9); m.marcar(m.posicion(0, 1));
        assertArrayEquals(new int[]{3, 9}, datos[0]); assertEquals(1, datos[2][0]);
        assertEquals("marcar", m.paso(m.cantidad() - 1).tipo());
    }
    @Test public void rechazaIndicesTiposYNulosSinMutar() {
        var m = new MotorVisualizacion(new int[][]{{1}, {2}});
        assertThrows(IllegalStateException.class, () -> m.indice(0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.posicion(-1, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> m.posicion(0, 1));
        assertThrows(NullPointerException.class, () -> new MotorVisualizacion(new int[][]{null}));
        assertEquals(1, m.cantidad());
    }
    @Test public void vaciosYCapturaDeCambiosDirectos() {
        assertEquals(0, new MotorVisualizacion(new int[0][]).paso(0).valores().length);
        assertEquals(0, new MotorVisualizacion(new int[0]).paso(0).valores()[0].length);
        int[] a = {1}; var m = new MotorVisualizacion(a);
        a[0] = 7; m.visitar(m.indice(0));
        assertEquals(1, m.paso(0).valores()[0][0]); assertEquals(7, m.paso(1).valores()[0][0]);
    }
    @Test public void limiteNoDejaMutacionSinRegistrar() {
        int[] a = {1}; var m = new MotorVisualizacion(a);
        for (int i = 1; i < 10000; i++) m.visitar(m.indice(0));
        assertThrows(IllegalStateException.class, () -> m.actualizar(m.indice(0), 9));
        assertEquals(1, a[0]); assertEquals(10000, m.cantidad());
    }
    @Test public void lectorConcurrenteRecibeInstantaneasCompletas() throws Exception {
        var m = new MotorVisualizacion(new int[]{0});
        var error = new java.util.concurrent.atomic.AtomicReference<Throwable>();
        Thread productor = new Thread(() -> {
            try { for (int i = 1; i <= 500; i++) m.actualizar(m.indice(0), i); }
            catch (Throwable ex) { error.set(ex); }
        });
        productor.start();
        do { int n = m.cantidad(); assertEquals(n - 1, m.paso(n - 1).valores()[0][0]); }
        while (productor.isAlive());
        productor.join(); assertNull(error.get()); assertEquals(501, m.cantidad());
    }
}
