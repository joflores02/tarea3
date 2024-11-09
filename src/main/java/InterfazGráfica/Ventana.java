
package InterfazGráfica;

import clasesTarea1.NoHayBebidaException;
import clasesTarea1.PagoIncorrectoException;
import clasesTarea1.PagoInsuficienteException;

import javax.swing.*;
import java.awt.*;

/**
 * La clase Ventana representa la ventana principal de la aplicación de la máquina expendedora.
 * Extiende JFrame y se encarga de inicializar y mostrar la interfaz gráfica del sistema.
 */
public class Ventana extends JFrame{

    /**
     * Constructor que inicializa la ventana y crea PanelPrincipal.
     * Configura el tamaño de la ventana y la operación de cierre, y la hace visible.
     *
     * @throws PagoIncorrectoException Excepción lanzada si el pago realizado es incorrecto.
     * @throws PagoInsuficienteException Excepción lanzada si el pago realizado es insuficiente.
     * @throws NoHayBebidaException Excepción lanzada si no hay bebidas disponibles en la máquina expendedora.
     */
    public Ventana() throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        super();
        PanelPrincipal pp=new PanelPrincipal();
        this.setLayout(new BorderLayout());
        this.setTitle("Expendedor-Comprador");
        this.add(pp);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1100,900); 
        this.setVisible(true); 
    }
}
