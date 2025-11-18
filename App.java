import src.controlador.ControladorInventario;
import src.modelo.BaseDeDatos;
import src.vista.InventarioVista;

public class App {
    
    public static void main(String[] args) {
        BaseDeDatos baseDatos = new BaseDeDatos();
        InventarioVista vista = new InventarioVista();
        ControladorInventario controlador = new ControladorInventario(baseDatos, vista);
        
        controlador.iniciar();
    }
}