package es.dam.visualizador;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/** Prueba de integración opcional; ejecutar en un proceso propio con escritorio disponible. */
public class ValidacionJavaFX {
    private static final CompletableFuture<Void> resultado = new CompletableFuture<>();
    public static void main(String[] args) throws Exception {
        if (args.length > 0 && args[0].equals("existente")) Platform.startup(() -> {});
        int[] datos = {3, 2, 1};
        Visualizador.mostrar(datos);
        Visualizador.visitar(0); Visualizador.comparar(0, 1);
        Visualizador.intercambiar(0, 2); Visualizador.actualizar(1, 7); Visualizador.marcar(2);
        Platform.runLater(() -> comprobar(() -> {
            Stage ventana = (Stage) Window.getWindows().get(0);
            Parent root = ventana.getScene().getRoot();
            exigir(texto(root, "Paso 0 de 5"), "Inicio en pausa");
            boton(root, "Siguiente").fire(); exigir(texto(root, "Paso 1 de 5"), "Avance");
            boton(root, "Anterior").fire(); exigir(texto(root, "Paso 0 de 5"), "Retroceso");
            root.lookupAll(".slider").stream().map(Slider.class::cast).forEach(s -> s.setValue(4));
            boton(root, "Reproducir").fire();
            PauseTransition esperar = new PauseTransition(Duration.millis(550));
            esperar.setOnFinished(e -> comprobar(() -> {
                boton(root, "Pausar").fire();
                exigir(!texto(root, "Paso 0 de 5"), "Reproducción a 4x");
                boton(root, "Reiniciar").fire(); exigir(texto(root, "Paso 0 de 5"), "Reinicio");
                exigir(datos[0] == 1 && datos[1] == 7 && datos[2] == 3, "Reproducir no altera datos");
                Visualizador.mostrar(new int[][]{{9}, {}, {8, 7}});
                exigir(texto(root, "Paso 0 de 0"), "Nueva captura");
                exigir(texto(root, "Fila 1 vacía"), "Matriz irregular");
                ventana.close();
                try { Visualizador.mostrar(new int[]{1}); throw new AssertionError("Debe rechazar reapertura"); }
                catch (IllegalStateException esperado) { /* JavaFX no se reinicia. */ }
                resultado.complete(null);
            }));
            esperar.play();
        }));
        try { resultado.get(15, TimeUnit.SECONDS); }
        finally { Platform.exit(); }
        System.out.println("Integración JavaFX correcta");
    }
    private static void comprobar(Runnable prueba) {
        try { prueba.run(); } catch (Throwable error) { resultado.completeExceptionally(error); }
    }
    private static boolean texto(Parent root, String inicio) {
        return root.lookupAll(".label").stream().map(Label.class::cast).anyMatch(l -> l.getText().startsWith(inicio));
    }
    private static Button boton(Parent root, String fragmento) {
        return root.lookupAll(".button").stream().map(Button.class::cast)
                .filter(b -> b.getText().contains(fragmento)).findFirst().orElseThrow();
    }
    private static void exigir(boolean condicion, String mensaje) {
        if (!condicion) throw new AssertionError(mensaje);
    }
}
