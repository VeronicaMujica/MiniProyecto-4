
import java.util.InputMismatchException;

import java.util.Scanner;

public class GestionInventario {


    
    // Scanner para leer la entrada del usuario
    static Scanner scanner = new Scanner(System.in);

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        try {
            
            // Mostrar el menú de opciones
            menu();
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }



    // Método para mostrar el menú de opciones y gestionar la interacción con el usuario
    public static void menu() {
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("--------------------------------------------");
            System.out.println("  Bienvenido a su control de inventario  ");
            System.out.println("--------------------------------------------");
            System.out.println("¿Qué deseas realizar el día de hoy?");
            System.out.println("1. Añadir producto");
            System.out.println("2. Actualizar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Buscar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Guardar cambios en el archivo");
            System.out.println("7. Salir");
            System.out.println("--------------------------------------------");
            System.out.println("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Descartar el salto de línea
            } catch (InputMismatchException e) {
                System.out.println("...Entrada inválida: Por favor, ingrese un número de selección del menú válido...");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue;
            }

            System.out.println("--------------------------------------------");

            switch (opcion) {
                case 1:
                    //inventarioAñadir();
                    break;
                case 2:
                    //inventarioActualizar();
                    break;
                case 3:
                    //inventarioEliminar();
                    break;
                case 4:
                
                    break;
                case 5:
                    //inventarioMostrar();
                    break;
                case 6:
                    //guardarInventarioEnArchivo();
                    break;
                case 7:
                    System.out.println("...Saliendo del inventario...");
                    break;
                default:
                    System.out.println("...Opción incorrecta, debe ser un número, intente de nuevo...");
                    break;
            }
        }
    }
}
