# Ejemplo MVC en Java - Gestion de Estudiantes

Ejemplo didactico del patron **Modelo - Vista - Controlador (MVC)** usando Java + Swing.
Es una pequena aplicacion CRUD: permite agregar estudiantes, verlos en una tabla y eliminarlos.

## Que es MVC

MVC separa una aplicacion en tres responsabilidades. La idea central: **cada capa tiene un solo
trabajo y no se mete en el de las otras.**

| Capa | Carpeta | Responsabilidad | Que NO hace |
|------|---------|-----------------|-------------|
| **Modelo** | `modelo/` | Datos y reglas de negocio (validar, guardar, calcular). | No conoce la interfaz grafica. No importa `javax.swing`. |
| **Vista** | `vista/` | Mostrar la interfaz: ventana, campos, botones, tabla. | No conoce al Modelo. No tiene reglas de negocio. |
| **Controlador** | `controlador/` | Escuchar al usuario, pedir trabajo al Modelo y actualizar la Vista. | No guarda datos ni dibuja interfaz. |

El flujo es siempre el mismo:

```
Usuario hace click  ->  VISTA avisa  ->  CONTROLADOR decide  ->  MODELO procesa
                                              |
                                              v
                                    CONTROLADOR actualiza la VISTA
```

## Estructura de archivos

```
src/
├── App.java                        <- punto de entrada (main): arma el MVC
├── modelo/
│   ├── Estudiante.java             <- clase de datos (POJO)
│   └── ModeloEstudiantes.java      <- logica: agregar, eliminar, validar
├── vista/
│   └── VistaPrincipal.java         <- la ventana Swing (solo interfaz)
└── controlador/
    └── Controlador.java            <- conecta Vista y Modelo
```

## Como compilar y ejecutar

Desde la carpeta del proyecto (la que contiene `src/`):

```bash
# 1. Compilar (genera los .class dentro de bin/)
javac -d bin -encoding UTF-8 src/modelo/*.java src/vista/*.java src/controlador/*.java src/App.java

# 2. Ejecutar
java -cp bin App
```

> Necesitas tener instalado un **JDK** (no solo el JRE), porque `javac` es el compilador.
> Para verificarlo: `javac -version`.

Si usas un IDE (IntelliJ, Eclipse, NetBeans, VS Code), basta con marcar `src/` como carpeta
de fuentes y ejecutar `App.java`.

## Por que enseniar asi

- **Mantenibilidad:** si manana cambias la interfaz (de Swing a consola o web), el Modelo
  no se toca.
- **Pruebas:** el Modelo se puede probar sin abrir la ventana (la logica esta aislada).
- **Trabajo en equipo:** una persona puede trabajar la Vista y otra el Modelo en paralelo.

## Ejercicios sugeridos para los alumnos

1. Agregar un boton "Editar" que modifique el estudiante seleccionado.
2. Mostrar al final de la tabla el **promedio general** del curso (nueva regla en el Modelo).
3. Validar que no se repita el nombre del estudiante.
4. Persistir los datos en un archivo de texto o CSV al cerrar la aplicacion.
5. Reemplazar la Vista Swing por una Vista de consola **sin tocar el Modelo**, para
   demostrar que la separacion funciona.# Ejemplo_MVC_JAVA
