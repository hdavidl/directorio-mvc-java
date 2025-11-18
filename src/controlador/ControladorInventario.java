package src.controlador;

import src.modelo.BaseDeDatos;
import src.modelo.Producto;
import src.vista.InventarioVista;
import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        
        vista.mostrarMensaje("\n¡Bienvenido al Sistema de Inventario de DevSolutions!");
        
        while (!salir) {
            try {
                int opcion = vista.mostrarMenu();
                
                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        mostrarTodosLosProductos();
                        break;
                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        salir = true;
                        vista.mostrarMensaje("\nCerrando el sistema. ¡Hasta pronto!");
                        break;
                    default:
                        vista.mostrarMensaje("\nOpción inválida. Por favor, seleccione una opción del 1 al 5.");
                }
            } catch (Exception e) {
                vista.mostrarMensaje("\nError: Entrada inválida. Intente nuevamente.");
            }
        }
        
        vista.cerrar();
    }

    private void agregarProducto() {
        Producto nuevoProducto = vista.pedirDatosProducto();
        baseDatos.agregarProducto(nuevoProducto);
        vista.mostrarMensaje("\nProducto agregado correctamente.");
    }

    private void buscarProducto() {
        String sku = vista.pedirSku();
        Producto producto = baseDatos.buscarProductoPorSku(sku);
        vista.mostrarProducto(producto);
    }

    private void mostrarTodosLosProductos() {
        List<Producto> productos = baseDatos.buscarTodos();
        vista.mostrarProductos(productos);
    }

    private void eliminarProducto() {
        String sku = vista.pedirSku();
        boolean eliminado = baseDatos.eliminarProducto(sku);
        
        if (eliminado) {
            vista.mostrarMensaje("\nProducto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("\nNo se pudo eliminar. Producto no encontrado.");
        }
    }
}