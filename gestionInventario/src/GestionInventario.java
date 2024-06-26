import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GestionInventario {

    // Estructura de datos para almacenar los productos del inventario
    static HashMap<Integer, Producto> inventario = new HashMap<>();
    
    // Scanner para leer la entrada del usuario
    static Scanner scanner = new Scanner(System.in);

    // Método principal que se ejecuta al iniciar el programa
    public static void main(String[] args) {
        try {
            // Cargar el inventario desde el archivo
            cargarInventarioDesdeArchivo();
            // Mostrar el menú de opciones
            menu();
        } finally {
            // Cerrar el scanner
            scanner.close();
        }
    }

    // Método para cargar el inventario desde un archivo
    public static void cargarInventarioDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventario.txt"))) {
            String lineaActual;
            // Leer cada línea del archivo y convertirla en un objeto Producto
            while ((lineaActual = reader.readLine()) != null) {
                Producto producto = Producto.fromString(lineaActual);
                if (producto != null) {
                    inventario.put(producto.getCodigo(), producto);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el inventario: " + e.getMessage());
        }
    }

    // Método para guardar el inventario en un archivo
    public static void guardarInventarioEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventario.txt"))) {
            // Iterar sobre cada entrada en el inventario y escribirla en el archivo
            for (Map.Entry<Integer, Producto> entry : inventario.entrySet()) {
                writer.write(entry.getValue().toString() + System.lineSeparator());
            }
            System.out.println("...Se guardaron los cambios realizados...");
        } catch (IOException e) {
            System.out.println("Error al guardar el inventario: " + e.getMessage());
        }
    }

    // Método para añadir un nuevo producto al inventario
    public static void inventarioAñadir() {
        try {
            System.out.println("Ingrese el código del producto:");
            int codigo = scanner.nextInt();
            if (codigo < 0) {
                System.out.println("El código no puede ser negativo. Operación cancelada.");
                return;
            }
            scanner.nextLine(); // Descartar el salto de línea

            // Verificar si ya existe un producto con el mismo código en el inventario
            if (inventario.containsKey(codigo)) {
                System.out.println("No se puede añadir ya existe un producto con el mismo código");
            } else {
                // Si el código no existe en el inventario, solicitar y leer los detalles del nuevo producto
                System.out.println("Ingrese el nombre del producto:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la cantidad en stock del producto:");
                int cantidadStock = scanner.nextInt();
                if (cantidadStock < 0) {
                    System.out.println("La cantidad en stock no puede ser negativa. Operación cancelada.");
                    return;
                }
                System.out.println("Ingrese el precio del producto:");
                double precio = scanner.nextDouble();
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo. Operación cancelada.");
                    return;
                }
                scanner.nextLine(); // Consumir el salto de línea
                
                // Crear un nuevo objeto Producto con los detalles ingresados
                Producto producto = new Producto(codigo, nombre, cantidadStock, precio);
                // Agregar el nuevo producto al inventario (almacenar en el HashMap)
                inventario.put(codigo, producto);
                //guardarInventarioEnArchivo(); // Guardar después de añadir
                System.out.println("Producto ha sido añadido");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para actualizar un producto existente en el inventario
    public static void inventarioActualizar() {
        // Verificar si el inventario está vacío
        if (inventario.isEmpty()) {
            System.out.println("...En estos momentos no hay productos registrados...");
            return;
        }

        try {
            System.out.println("Ingrese el código del producto a actualizar:");
            // Leer el código del producto desde la entrada estándar
            int codigo = scanner.nextInt();
            if (codigo < 0) {
                System.out.println("El código no puede ser negativo. Operación cancelada.");
                return;
            }
            scanner.nextLine(); // Descartar el salto de línea

            // Verificar si el inventario contiene el código del producto ingresado
            if (inventario.containsKey(codigo)) {
                // Si el código existe en el inventario, solicitar y leer los nuevos detalles del producto
                System.out.println("Ingrese el nuevo nombre del producto:");
                String nombre = scanner.nextLine();
                System.out.println("Ingrese la nueva cantidad en stock del producto:");
                int cantidadStock = scanner.nextInt();
                if (cantidadStock < 0) {
                    System.out.println("La cantidad en stock no puede ser negativa. Operación cancelada.");
                    return;
                }
                System.out.println("Ingrese el nuevo precio del producto:");
                double precio = scanner.nextDouble();
                if (precio < 0) {
                    System.out.println("El precio no puede ser negativo. Operación cancelada.");
                    return;
                }
                scanner.nextLine(); // Descartar el salto de línea
                
                // Crear un nuevo objeto Producto con los detalles actualizados
                Producto producto = new Producto(codigo, nombre, cantidadStock, precio);
                // Actualizar el producto en el inventario (reemplazar la entrada existente)
                inventario.put(codigo, producto);
                //guardarInventarioEnArchivo(); // Guardar después de actualizar
                System.out.println("Producto ha sido actualizado");
            } else {
                System.out.println("No existe un producto con ese código");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para eliminar un producto del inventario
    public static void inventarioEliminar() {
        // Verificar si el inventario está vacío
        if (inventario.isEmpty()) {
            System.out.println("...En estos momentos no hay productos registrados...");
            return;
        }

        try {
            System.out.println("Ingrese el código del producto que deseas eliminar: ");
            // Leer el código del producto desde la entrada estándar
            int codigo = scanner.nextInt();
            if (codigo < 0) {
                System.out.println("El código no puede ser negativo. Operación cancelada.");
                return;
            }
            scanner.nextLine(); // Descartar el salto de línea

            // Verificar si el inventario contiene el código del producto ingresado
            if (inventario.containsKey(codigo)) {
                // Si el código existe en el inventario, eliminar el producto
                inventario.remove(codigo);
                //guardarInventarioEnArchivo(); // Guardar después de eliminar
                System.out.println("El producto ha sido eliminado");
            } else {
                System.out.println("No existe un producto con ese código");
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese los datos correctamente.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para mostrar todos los productos del inventario
    public static void inventarioMostrar() {
        // Verificar si el inventario está vacío
        if (inventario.isEmpty()) {
            System.out.println("...En estos momentos no hay productos registrados...");
            return;
        }

        // Si el inventario no está vacío, imprimir el encabezado
        System.out.println("    Inventario de productos registrados    ");
        System.out.println("--------------------------------------------");
        System.out.println("-Esta representado de la siguiente forma ");
        System.out.println("CÓDIGO, NOMBRE, CANTIDAD EN STOCK, PRECIO");
        System.out.println("--------------------------------------------");

        // Iterar a través de cada entrada (par clave-valor) en el inventario
        // la clave es un Integer (el código del producto) y el valor es un objeto Producto.
        for (Map.Entry<Integer, Producto> entry : inventario.entrySet()) {
            
            // Obtener el valor (producto) asociado a la clave (código del producto)
            Producto producto = entry.getValue();
            
            // Imprimir la representación en cadena del producto (usando su método toString())
            System.out.println(producto);
        }
    }

    // Método para buscar un producto en el inventario por su código
    public static Producto buscarProducto(int codigo) {
        if (codigo < 0) {
            System.out.println("El código no puede ser negativo.");
            return null;
        }
        return inventario.get(codigo);
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
                    inventarioAñadir();
                    break;
                case 2:
                    inventarioActualizar();
                    break;
                case 3:
                    inventarioEliminar();
                    break;
                case 4:
                    try {
                        System.out.println("Ingrese el código del producto que deseas buscar: ");
                        int codigo = scanner.nextInt();
                        scanner.nextLine(); // Descartar el salto de línea
                        // Realiza la búsqueda
                        Producto producto = buscarProducto(codigo);
                        if (producto != null) {
                            // En caso de encontrarlo, muestra el resultado
                            System.out.println("Producto encontrado: " + producto);
                        } else {
                            System.out.println("Producto no encontrado.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, ingrese un código válido.");
                        scanner.nextLine(); // Limpiar el buffer del scanner
                    }
                    break;
                case 5:
                    inventarioMostrar();
                    break;
                case 6:
                    guardarInventarioEnArchivo();
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
