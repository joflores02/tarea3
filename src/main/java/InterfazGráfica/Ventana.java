
package InterfazGráfica;

import clasesTarea1.NoHayBebidaException;
import clasesTarea1.PagoIncorrectoException;
import clasesTarea1.PagoInsuficienteException;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
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
