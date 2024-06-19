/**
 * @file App.java
 * @brief Programa para registrar estudiantes y calcular promedios.
 * Este programa permite al usuario registrar estudiantes con sus respectivas calificaciones,
 * calcular el promedio de las calificaciones y mostrar aquellos estudiantes cuya calificación
 * es superior al promedio.
 * @author
 *         - Sebastian Castro - 2359435
 *         - Karol Burbano - 2359305
 *         -Veronica Mujica - 2359406
 *         -Jeidy Murillo - 2359310 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        
    }

    /**
     * @brief Función para calcular el promedio de las calificaciones de los estudiantes.
     * 
     * Calcula y muestra el promedio de las calificaciones de todos los estudiantes registrados.
     */
    static void calcularPromedio() {
    
    }

    /**
     * @brief Función para mostrar estudiantes con calificación superior al promedio.
     * 
     * Calcula el promedio de las calificaciones y muestra aquellos estudiantes cuya calificación
     * es superior a dicho promedio.
     */
    static void promedioSuperior() {
        
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
