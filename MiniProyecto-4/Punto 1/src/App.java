import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @file App.java
 * @brief Programa para registrar estudiantes y calcular promedios.
 * 
 * Este programa permite al usuario registrar estudiantes con sus respectivas calificaciones,
 * calcular el promedio de las calificaciones y mostrar aquellos estudiantes cuya calificación
 * es superior al promedio.
 */

public class App {

    static HashMap<String, Double> estudiantes = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * @brief Función para ingresar estudiantes y sus calificaciones.
     * 
     * Permite al usuario ingresar el nombre y la calificación de varios estudiantes.
     * Realiza validación de entradas para asegurar que las calificaciones sean números válidos.
     */
    static void ingresarEstudiantes() {
        try {
            System.out.println("--------------------------------------------");
            System.out.print("Ingrese la cantidad de estudiantes a registrar: ");
            int cantidad = Integer.parseInt(scanner.nextLine());  // Leer como línea completa y luego convertir a entero

            for (int i = 0; i < cantidad; i++) {
                System.out.println("Ingrese el nombre del estudiante:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la calificación del estudiante:");
                double calificacion = Double.parseDouble(scanner.nextLine());  // Leer como línea completa y luego convertir a doble
                estudiantes.put(nombre, calificacion);
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    /**
     * @brief Función para calcular el promedio de las calificaciones de los estudiantes.
     * 
     * Calcula y muestra el promedio de las calificaciones de todos los estudiantes registrados.
     */
    static void calcularPromedio() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        try {
            // Calcular promedio de calificaciones
            double suma = 0;
            for (Double calificacion : estudiantes.values()) {
                suma += calificacion;
            }
            double promedio = suma / estudiantes.size();
            System.out.println("Promedio de calificaciones: " + promedio);
        } catch (Exception e) {
            System.out.println("Ocurrió un error al calcular el promedio: " + e.getMessage());
        }
    }

    /**
     * @brief Función para mostrar estudiantes con calificación superior al promedio.
     * 
     * Calcula el promedio de las calificaciones y muestra aquellos estudiantes cuya calificación
     * es superior a dicho promedio.
     */
    static void promedioSuperior() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        try {
            // Calcular promedio de calificaciones
            double suma = 0;
            for (Double calificacion : estudiantes.values()) {
                suma += calificacion;
            }
            double promedio = suma / estudiantes.size();

            // Mostrar estudiantes con calificación superior al promedio
            System.out.println("Estudiantes con calificación superior al promedio:");
            for (Map.Entry<String, Double> entry : estudiantes.entrySet()) {
                if (entry.getValue() > promedio) {
                    System.out.println(entry.getKey());
                }
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al mostrar los estudiantes: " + e.getMessage());
        }
    }

    /**
     * @brief Función para mostrar el menú principal y gestionar las opciones seleccionadas por el usuario.
     * 
     * Muestra un menú con opciones para ingresar estudiantes, calcular el promedio,
     * mostrar estudiantes con calificación superior al promedio, o salir del programa.
     */
    static void menu() {
        byte opcionByte = 0;

        do {
            System.out.println("--------------------------------------------");
            System.out.println("                Bienvenido");
            System.out.println("--------------------------------------------");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Ingresar estudiantes");
            System.out.println("2. Calcular el promedio");
            System.out.println("3. Mostrar estudiantes con promedio superior");
            System.out.println("4. Salir");
            System.out.println("--------------------------------------------");
            System.out.print("Seleccione una opción: ");
            try {
                opcionByte = Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                continue;
            }

            System.out.println("--------------------------------------------\n");

            switch (opcionByte) {
                case 1:
                    ingresarEstudiantes();
                    break;
                case 2:
                    calcularPromedio();
                    break;
                case 3:
                    promedioSuperior();
                    break;
                case 4:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta, intente de nuevo...\n");
                    break;
            }
        } while (opcionByte != 4);
    }

    /**
     * @brief Función principal del programa.
     * 
     * Inicia la ejecución del programa llamando a la función del menú principal.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        menu();
    }
}
