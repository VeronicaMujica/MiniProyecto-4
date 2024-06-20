// Clase Producto para representar los productos del inventario
public class Producto {
    //Atributos del producto
    int codigo;
    String nombre;
    int cantidadStock;
    double precio;

    // Constructor por defecto
    public Producto() {
    }

    // Constructor con parámetros
    public Producto(int codigo, String nombre, int cantidadStock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Método para convertir un producto a cadena de texto
    @Override
    public String toString() {
        return codigo + "," + nombre + "," + cantidadStock + "," + precio;
    }

    // Método estatico para convertir una cadena de texto en un objeto Producto
    public static Producto fromString(String cadena) {
        
        // Dividir la cadena en partes usando la coma como delimitador
        String[] partes = cadena.split(",");
        
        // Verificar si la cadena se dividió correctamente en 4 partes
        if (partes.length == 4) {
            try {
                // Obtener cada parte y convertirla al tipo correspondiente
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                int cantidadStock = Integer.parseInt(partes[2]);
                double precio = Double.parseDouble(partes[3]);

                // Crear y devolver un nuevo objeto Producto con los datos obtenidos
                return new Producto(codigo, nombre, cantidadStock, precio);
            } catch (NumberFormatException e) {
                // Capturar cualquier excepción que ocurra durante la conversión de tipos
                System.out.println("Error al parsear el producto: " + e.getMessage());
            }
        }
        // Si la cadena no se dividió en exactamente 4 partes o hubo un error de conversión, retornar null
        return null;
    }
}