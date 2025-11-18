package src.vista;

import src.modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n----------------------------------------");
        System.out.println("    SISTEMA DE INVENTARIO - DevSolutions");
        System.out.println("----------------------------------------");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.println("----------------------------------------");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }

    public Producto pedirDatosProducto() {
        System.out.println("\n--- Agregar Nuevo Producto ---");
        
        System.out.print("Nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Código SKU: ");
        String sku = scanner.nextLine();
        
        System.out.print("Cantidad en stock: ");
        int cantidad = scanner.nextInt();
        
        System.out.print("Precio unitario: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        return new Producto(nombre, sku, cantidad, precio);
    }

    public String pedirSku() {
        System.out.print("\nIngrese el código SKU: ");
        return scanner.nextLine();
    }

    public void mostrarProducto(Producto producto) {
        System.out.println("\n--- Resultado de la Búsqueda ---");
        if (producto != null) {
            System.out.println(producto.toString());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        System.out.println("\n--- Lista de Productos ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("Total de productos: " + productos.size());
            System.out.println("----------------------------------------");
            for (Producto producto : productos) {
                System.out.println(producto.toString());
            }
            System.out.println("----------------------------------------");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrar() {
        scanner.close();
    }
}