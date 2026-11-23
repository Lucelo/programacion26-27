package es.dam.visualizador;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/** Todos los nodos y temporizadores se crean y modifican exclusivamente en el hilo FX. */
final class VentanaJavaFX {
    private static boolean iniciado;
    private static volatile boolean cerrada;
    private static VentanaJavaFX ventana; // Solo hilo FX.
    private final Stage stage = new Stage();
    private final VBox tablero = new VBox(12);
    private final Label estado = new Label();
    private final Label contador = new Label();
    private final Slider velocidad = new Slider(0.25, 4, 1);
    private final Button anterior = new Button("◀ Anterior");
    private final Button siguiente = new Button("Siguiente ▶");
    private final Button play = new Button("▶ Reproducir");
    private final Button pausa = new Button("Pausar");
    private final Timeline reloj;
    private final Timeline refresco;
    private MotorVisualizacion motor;
    private int indice;

    static synchronized void abrir(MotorVisualizacion motor) {
        if (cerrada) throw new IllegalStateException("La ventana se ha cerrado. Vuelve a ejecutar Ejercicio.main");
        Runnable mostrar = () -> {
            if (cerrada) return;
            if (ventana == null) ventana = new VentanaJavaFX();
            ventana.cargar(motor);
        };
        if (!iniciado) {
            // Si el anfitrión ya inició JavaFX, reutiliza su runtime.
            try { Platform.startup(mostrar); }
            catch (IllegalStateException yaIniciado) { Platform.runLater(mostrar); }
            iniciado = true;
        } else if (Platform.isFxApplicationThread()) mostrar.run();
        else Platform.runLater(mostrar);
    }

    private VentanaJavaFX() {
        reloj = new Timeline(new KeyFrame(Duration.millis(750), e -> {
            if (indice < motor.cantidad() - 1) representar(indice + 1);
            else parar();
        }));
        reloj.setCycleCount(Animation.INDEFINITE);
        reloj.rateProperty().bind(velocidad.valueProperty());
        // Una consulta acotada evita encolar un runLater por cada operación del alumno.
        refresco = new Timeline(new KeyFrame(Duration.millis(100), e -> actualizarControles()));
        refresco.setCycleCount(Animation.INDEFINITE);
        anterior.setOnAction(e -> { parar(); representar(indice - 1); });
        siguiente.setOnAction(e -> { parar(); representar(indice + 1); });
        play.setOnAction(e -> {
            if (indice == motor.cantidad() - 1) representar(0);
            reloj.play(); actualizarControles();
        });
        pausa.setOnAction(e -> parar());
        Button reiniciar = new Button("↺ Reiniciar");
        reiniciar.setOnAction(e -> { parar(); representar(0); });
        velocidad.setShowTickLabels(true); velocidad.setShowTickMarks(true);
        velocidad.setPrefWidth(150);
        FlowPane controles = new FlowPane(10, 10, anterior, play, pausa, siguiente, reiniciar,
                new Label("Velocidad (×)"), velocidad);
        controles.setPadding(new Insets(18));
        VBox cabecera = new VBox(10, new Label("Visualizador de arrays y matrices"), estado, contador,
                new Label("Amarillo: operación actual · Verde: marca del paso actual"));
        cabecera.setPadding(new Insets(18)); estado.setWrapText(true);
        tablero.setPadding(new Insets(24)); tablero.setAlignment(Pos.TOP_LEFT);
        ScrollPane scroll = new ScrollPane(tablero); scroll.setPannable(true);
        BorderPane root = new BorderPane(scroll, cabecera, null, controles, null);
        root.setStyle("-fx-background-color:#f4f6fb; -fx-font-size:14px;");
        stage.setScene(new Scene(root, 1000, 590));
        stage.setTitle("DAM · Visualizador JavaFX");
        stage.setOnHidden(e -> {
            cerrada = true; reloj.stop(); refresco.stop();
            reloj.rateProperty().unbind();
        });
    }
    private void cargar(MotorVisualizacion nuevo) {
        parar(); motor = nuevo; representar(0); refresco.play(); stage.show();
    }
    private void parar() { reloj.stop(); if (motor != null) actualizarControles(); }
    private void actualizarControles() {
        int total = motor.cantidad() - 1;
        contador.setText("Paso " + indice + " de " + total + " · Pasos registrados hasta ahora");
        anterior.setDisable(indice == 0);
        siguiente.setDisable(indice >= total);
        play.setDisable(total == 0 || reloj.getStatus() == Animation.Status.RUNNING);
        pausa.setDisable(reloj.getStatus() != Animation.Status.RUNNING);
    }
    private void representar(int n) {
        indice = Math.max(0, Math.min(n, motor.cantidad() - 1));
        var paso = motor.paso(indice);
        int[][] valores = paso.valores();
        tablero.getChildren().clear();
        if (valores.length == 0) tablero.getChildren().add(new Label("Matriz vacía"));
        for (int f = 0; f < valores.length; f++) {
            HBox fila = new HBox(8); fila.setAlignment(Pos.CENTER_LEFT);
            if (valores[f].length == 0) fila.getChildren().add(new Label(paso.matriz() ? "Fila " + f + " vacía" : "Array vacío"));
            for (int c = 0; c < valores[f].length; c++) {
                var posicion = new MotorVisualizacion.Celda(f, c);
                boolean activa = posicion.equals(paso.a()) || posicion.equals(paso.b());
                String color = activa ? (paso.tipo().equals("marcar") ? "#7cdbad" : "#ffd16b") : "#e1e9f5";
                Label celda = new Label(Integer.toString(valores[f][c]));
                celda.setMinSize(90, 64); celda.setAlignment(Pos.CENTER);
                celda.setStyle("-fx-font-size:20px;-fx-background-radius:8;-fx-background-color:" + color + ";");
                Label etiqueta = new Label(paso.matriz() ? "[" + f + "][" + c + "]" : "[" + c + "]");
                VBox columna = new VBox(5, celda, etiqueta); columna.setAlignment(Pos.CENTER);
                fila.getChildren().add(columna);
            }
            tablero.getChildren().add(fila);
        }
        estado.setText(paso.mensaje()); actualizarControles();
    }
}
