# Visualizador JavaFX genérico

Java 21 · JavaFX 21.0.6 · Maven. La biblioteca no importa ni ejecuta clases de alumnos y no contiene un catálogo de ejercicios.

## Abrir y ejecutar en IntelliJ IDEA

1. Descomprime el ZIP y abre la carpeta `VisualizadorJavaFX` (contiene `pom.xml`).
2. Selecciona un **JDK 21** en File → Project Structure → Project. Instálalo desde Download JDK si hace falta.
3. En Settings → Build, Execution, Deployment → Build Tools → Maven, selecciona también JDK 21 para **Runner** e **Importing**. Son preferencias locales: el archivo compartido no instala ni garantiza el JDK.
4. Espera la sincronización de Maven; requiere Internet en la primera descarga.
5. Selecciona **Visualizador JavaFX** y pulsa ▶. La configuración compartida está en `.run/` y ejecuta `compile javafx:run`.

Edita `src/main/java/es/dam/alumno/Ejercicio.java` y vuelve a ejecutar para probar otro algoritmo. La entrada es su `main`; no hace falta heredar de Application ni conocer JavaFX. Utiliza la configuración Maven para que JavaFX esté en el module path.

También puedes ejecutar, con Maven 3.9+ y JDK 21:

```shell
mvn clean test package
mvn compile javafx:run
```

Comprueba `mvn -version`: `maven.compiler.release=21` fija el destino de compilación, pero no cambia el JDK que ejecuta Maven. No se añaden opciones para ocultar advertencias de JDK posteriores.

## Escribir cualquier algoritmo

El ejemplo de `Ejercicio.main` recorre una matriz al revés. Puede sustituirse entero por búsqueda, ordenación, recorrido diagonal, etc. Por ejemplo:

```java
int[] a = {8, 3, 6, 2, 5};
Visualizador.mostrar(a);
for (int fin = a.length - 1; fin > 0; fin--) {
    for (int j = 0; j < fin; j++) {
        if (Visualizador.comparar(j, j + 1) > 0) {
            Visualizador.intercambiar(j, j + 1);
        }
    }
}
Visualizador.marcar(0);
```

Importa `es.dam.visualizador.Visualizador`.

| Operación | Array | Matriz |
| --- | --- | --- |
| Mostrar datos y reiniciar captura | `mostrar(a)` | `mostrar(m)` |
| Visitar | `visitar(i)` | `visitar(f, c)` |
| Comparar dos valores | `comparar(i, j)` | `comparar(f1, c1, f2, c2)` |
| Intercambiar | `intercambiar(i, j)` | `intercambiar(f1, c1, f2, c2)` |
| Asignar valor | `actualizar(i, valor)` | `actualizar(f, c, valor)` |
| Resaltar una posición | `marcar(i)` | `marcar(f, c)` |

`comparar` devuelve un entero negativo, cero o positivo como `Integer.compare`; también puedes ignorar el resultado y escribir tu condición Java normal. Las versiones de un índice exigen un array. Las de fila/columna funcionan también con la fila 0 de un array. Se validan todos los índices antes de modificar los datos. `iniciar` se conserva como alias obsoleto de `mostrar` para facilitar la migración.

**`intercambiar` y `actualizar` modifican el array/matriz original inmediatamente.** No repitas la misma modificación manualmente. Cada llamada guarda una copia del estado; reproducir, retroceder y reiniciar solo cambian la pantalla, nunca vuelven a ejecutar el algoritmo ni alteran el resultado real.

Las modificaciones directas, como `a[i] = 7`, aparecerán en el próximo paso registrado. Para capturar cada asignación, usa `actualizar`. No reemplaces las filas de una matriz después de `mostrar`: se conservan sus referencias originales. Se permiten matrices irregulares, filas vacías y datos vacíos; se rechazan referencias nulas.

`marcar` resalta en verde únicamente su propio paso. No acumula marcas. Visitas, comparaciones y cambios resaltan en amarillo.

## Reproducción y ciclos de vida

`mostrar` abre una ventana sin bloquear el algoritmo. Empieza **en pausa**, en el estado inicial. Usa Reproducir, Pausar, Anterior, Siguiente o Reiniciar; la velocidad (0,25×–4×) se aplica durante la reproducción. Al llegar al último paso disponible se pausa; si todavía se están registrando pasos, puedes reanudar después. El contador muestra los pasos capturados hasta ese momento.

Una nueva llamada a `mostrar` sustituye la captura activa y reinicia la misma ventana. Hay una sola captura global; las llamadas están sincronizadas, pero no debes entrelazar algoritmos independientes ni escribir directamente en los datos desde varios hilos. Programa el algoritmo en `main` o en un hilo de trabajo; no ejecutes bucles largos en el hilo JavaFX.

La ventana se mantiene abierta tras terminar `main`. Al cerrarla se detienen sus temporizadores y JavaFX termina cuando no quedan ventanas (comportamiento estándar). JavaFX no permite reiniciar su runtime: vuelve a ejecutar el programa para abrirlo de nuevo. Si tu algoritmo sigue trabajando al cerrar la ventana, debe terminar por sí mismo; no se interrumpe ni se llama a `System.exit`.

El arranque JavaFX se realiza una sola vez; todos los controles se crean en el hilo FX. El modelo guarda las instantáneas bajo sincronización y la ventana consulta el contador cada 100 ms, sin encolar una tarea por operación. También puede integrarse en una aplicación con JavaFX ya iniciado. Consulta la documentación oficial de [Platform](https://openjfx.io/javadoc/21/javafx.graphics/javafx/application/Platform.html) para el ciclo de vida.

## Biblioteca reutilizable

`mvn package` genera `target/visualizador-javafx-2.0.0.jar`: contiene únicamente `es.dam.visualizador`, excluyendo `es.dam.alumno`. No es un JAR ejecutable autónomo: necesita JavaFX y sus bibliotecas nativas.

El ZIP incluye también una copia compilada con JDK 21 en `biblioteca/`. El proyecto se puede recompilar desde sus fuentes sin usar esa copia. Los resultados y el alcance de las comprobaciones están en `VERIFICACION.md`.

Para usarla desde otro proyecto Maven, ejecuta `mvn install` y añade:

```xml
<dependency>
    <groupId>es.dam</groupId>
    <artifactId>visualizador-javafx</artifactId>
    <version>2.0.0</version>
</dependency>
```

La dependencia JavaFX se resuelve de forma transitiva. Configura el plugin `javafx-maven-plugin` con el `main` de tu propio proyecto, como en este `pom.xml`. En la plantilla puedes cambiar la entrada sin tocar la biblioteca: `mvn compile javafx:run -Dexec.mainClass=tu.paquete.OtroEjercicio`.

## Estructura, pruebas y límites

- `Visualizador`: API pública y captura activa.
- `MotorVisualizacion`: datos, validación e instantáneas; sin JavaFX.
- `VentanaJavaFX`: arranque, dibujo y reproducción; sin referencias a alumnos.
- `Ejercicio`: único ejemplo editable, entrada principal.
- `src/test`: pruebas del motor, incluyendo ordenación, recorrido inverso irregular, aislamiento de estados, validaciones, límites y lectura concurrente.

Herramienta para tamaños docentes: máximo 1000 filas y 1000 celdas iniciales; máximo 10 000 estados y 2 000 000 unidades de almacenamiento (celdas + filas por estado). Al superar un límite se lanza una excepción descriptiva antes de aplicar una actualización o intercambio. Las instantáneas consumen memoria proporcional al tamaño de datos por número de pasos. Evita bucles infinitos; cerrar la ventana no detiene un algoritmo del alumno.
