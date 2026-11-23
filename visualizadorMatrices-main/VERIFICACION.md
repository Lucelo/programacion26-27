# Verificación de la entrega

Comprobado el 19 de noviembre de 2026 en Windows con Eclipse Temurin JDK 21.0.13+9 y JavaFX 21.0.6.

- Compilación de todas las clases con JDK 21 y `release 21`: correcta.
- Maven `package`: BUILD SUCCESS.
- JUnit: 6 pruebas ejecutadas, 0 fallos, 0 errores, 0 omitidas.
- Integración con escritorio JavaFX: arranque desde un `main` normal y reutilización de un runtime ya iniciado, ambos correctos en procesos independientes.
- Controles: inicio en pausa, avance, retroceso, reproducción a 4×, pausa y reinicio comprobados mediante acciones sobre los controles JavaFX.
- Nueva captura en la misma ventana con matriz irregular y fila vacía: correcta.
- Reproducción sin alterar los datos finales del alumno y rechazo de reapertura tras cerrar: correctos.
- Lanzador Maven `javafx:run`: BUILD SUCCESS usando la entrada de validación temporalmente en el directorio de compilación. Esa clase no forma parte del JAR de biblioteca.
- JAR inspeccionado: contiene las clases del visualizador y metadatos Maven; no contiene clases de alumno ni pruebas.

Las pruebas del motor cubren burbuja, historial protegido frente a cambios externos, recorrido inverso irregular, operaciones de matriz, índices y tipos incorrectos, nulos, datos vacíos, captura de cambios directos, límite antes de mutar y lectura concurrente.

`ValidacionJavaFX.java` es una prueba de integración opcional con `main` y requiere un escritorio. No se ejecuta durante `mvn test`. Para lanzarla tras `mvn test-compile`, usa JDK 21, los tres JAR nativos de JavaFX 21.0.6 (base, graphics, controls) en el module path y `target/classes` y `target/test-classes` en el classpath:

```shell
java --module-path "RUTA_JAR_JAVAFX" --add-modules javafx.controls -cp "target/classes;target/test-classes" es.dam.visualizador.ValidacionJavaFX
java --module-path "RUTA_JAR_JAVAFX" --add-modules javafx.controls -cp "target/classes;target/test-classes" es.dam.visualizador.ValidacionJavaFX existente
```

En Windows separa los tres archivos del module path con `;`; en Linux/macOS usa `:` también para el classpath. Los JAR se encuentran en el repositorio Maven local bajo `org/openjfx`, usando el clasificador nativo del sistema correspondiente.

La configuración `.run` está incluida y su XML se ha validado. No se ha abierto/importado el proyecto manualmente en IntelliJ. El usuario debe seleccionar su JDK 21 local para proyecto y Maven, tal como indica el README. Las pruebas gráficas se han realizado en Windows; no se ha probado esta entrega en Linux/macOS.
