# Ejemplo MVC en Java — Gestión de Estudiantes

Aplicación de ejemplo que demuestra el patrón de arquitectura **Modelo–Vista–Controlador (MVC)**
usando **Java + Swing**. Es un CRUD simple: permite agregar estudiantes, listarlos en una tabla
y eliminarlos. Está pensada como material didáctico para visualizar cómo se separan las
responsabilidades en una aplicación.

---

## Tecnologías y versiones

| Componente | Versión utilizada |
|------------|-------------------|
| Lenguaje | Java (JDK 21) |
| IDE | IntelliJ IDEA Ultimate 2025.3 (build 253.31033.145) |
| Nivel de lenguaje del proyecto | JDK 21 |
| Interfaz gráfica | Java Swing (incluida en el JDK, sin dependencias externas) |

> El proyecto no usa Maven ni Gradle: se compila directamente con el JDK, por lo que solo
> necesitas tener instalado **Java 21**.

---

## ¿Qué es MVC?

MVC separa la aplicación en tres responsabilidades. La idea central es que **cada capa tiene un
solo trabajo y no se mete en el de las otras**.

| Capa | Carpeta | Responsabilidad | Lo que NO hace |
|------|---------|-----------------|----------------|
| **Modelo** | `modelo/` | Datos y reglas de negocio (validar, guardar, calcular). | No conoce la interfaz gráfica. No importa `javax.swing`. |
| **Vista** | `vista/` | Mostrar la interfaz: ventana, campos, botones, tabla. | No conoce al Modelo. No tiene reglas de negocio. |
| **Controlador** | `controlador/` | Escuchar al usuario, pedir trabajo al Modelo y actualizar la Vista. | No guarda datos ni dibuja la interfaz. |

El flujo es siempre el mismo:

```
Usuario hace clic  ->  VISTA avisa  ->  CONTROLADOR decide  ->  MODELO procesa
                                              |
                                              v
                                    CONTROLADOR actualiza la VISTA
```

---

## Estructura de archivos

```
Ejemplo_MVC_JAVA/
└── src/
    ├── Main.java                       <- punto de entrada (main): arma el MVC
    ├── modelo/
    │   ├── Estudiante.java             <- clase de datos (POJO)
    │   └── Modelo_Estudiante.java      <- lógica: agregar, eliminar, validar
    ├── vista/
    │   └── Vista_Principal.java        <- la ventana Swing (solo interfaz)
    └── controlador/
        └── Controlador.java            <- conecta Vista y Modelo
```

---

## Requisitos previos

- **JDK 21** instalado (no basta con el JRE: se necesita el compilador `javac`).
  Para verificarlo, abre una terminal y ejecuta:

  ```bash
  java -version
  javac -version
  ```

  Ambos comandos deberían mostrar una versión 21.x.

---

## Cómo ejecutar en IntelliJ IDEA

1. Abre IntelliJ IDEA y elige **File > Open**, luego selecciona la carpeta raíz del proyecto
   (la que contiene la carpeta `src` y el archivo `Ejemplo_MVC.iml`).
2. Verifica que el SDK del proyecto sea **Java 21**: ve a **File > Project Structure > Project**
   y confirma que *SDK* y *Language level* estén en 21.
3. Abre el archivo `src/Main.java`.
4. Haz clic en el botón verde de ejecutar (▶) que aparece junto a la clase `Main`,
   o presiona **Shift + F10**.
5. Se abrirá la ventana de la aplicación.

---

## Cómo ejecutar desde la línea de comandos

Desde la carpeta raíz del proyecto (la que contiene `src/`):

```bash
# 1. Compilar: genera los .class dentro de la carpeta out/
javac -d out -encoding UTF-8 src/modelo/*.java src/vista/*.java src/controlador/*.java src/Main.java

# 2. Ejecutar
java -cp out Main
```

---

## Uso de la aplicación

1. Escribe **Nombre**, **Apellido** y **Nota** (un número entre 1.0 y 7.0).
2. Presiona **Agregar**. El estudiante aparece en la tabla.
3. Para eliminar, selecciona una fila de la tabla y presiona **Eliminar seleccionado**.

La aplicación valida que el nombre no esté vacío y que la nota esté entre 1.0 y 7.0;
si algo está mal, muestra un mensaje de error.

---

## Ejercicios sugeridos para los estudiantes

1. Agregar un botón **Editar** que modifique el estudiante seleccionado.
2. Mostrar el **promedio general** del curso (nueva regla en el Modelo).
3. Validar que no se repita el nombre y apellido de un estudiante.
4. Persistir los datos en un archivo de texto o CSV.
5. Reemplazar la Vista de Swing por una **Vista de consola sin tocar el Modelo**,
   para demostrar que la separación de capas realmente funciona.

## Docente 
    Sabina Romero 