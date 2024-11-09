package InterfazGráfica;

import clasesTarea1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * La clase PanelPrincipal es un panel que representa la interfaz gráfica principal de la máquina expendedora.
 * Maneja la interacción del usuario y gestiona las acciones relacionadas con la compra de bebidas,
 * el depósito de monedas y la recolección de vuelto.
 * Esta clase implementa MouseListener.
 */
public class PanelPrincipal extends JPanel implements MouseListener{
    private Comprador com;
    private Expendedor exp;

    /**
     * Constructor que inicializa la interfaz gráfica y los objetos Expendedor
     * y Comprador.
     *
     * @throws PagoIncorrectoException Excepción que se lanza si el pago es incorrecto.
     * @throws PagoInsuficienteException Excepción que se lanza si el pago es insuficiente.
     * @throws NoHayBebidaException Excepción que se lanza si no hay bebidas disponibles.
     */
    public PanelPrincipal() throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        exp=new Expendedor(10,3000,600,50);
        com=new Comprador(exp,70,50);
        this.setBackground(Color.darkGray);
        this.addMouseListener(this);

    }

    /**
     * Dibuja la interfaz gráfica, incluyendo la máquina expendedora y el comprador.
     *
     * @param g El objeto graphics utilizado para dibujar los componentes gráficos.
     */
    public void paint(Graphics g){
        super.paint(g);
        if(exp!=null)exp.paint(g);
        if(com!=null)com.paint(g);
    }

    /**
     * Maneja los eventos de clic del ratón.
     *
     * @param e El evento de clic del ratón.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 491 && e.getX() <= 491 + 150 &&
                e.getY() >= 69 && e.getY() <= 69 + 350) {
            exp.rellenarCoca();
            repaint();
        }
        if (e.getX() >= 660 && e.getX() <= 660 + 150 &&
                e.getY() >= 69 && e.getY() <= 69 + 350) {
            exp.rellenarSprite();
            repaint();
        }
        if (e.getX() >= 830 && e.getX() <= 830 + 150 &&
                e.getY() >= 69 && e.getY() <= 69 + 350) {
            exp.rellenarFanta();
            repaint();
        }
        /*aquí asignamos la bebida a comprar por el comprador, según su posición en la interfaz
         */
        if(e.getX()>=90 && e.getX()<=90+120 && e.getY()>=255 && e.getY()<=255+25){
            try {
                com.cualBebida(1);
            } catch (PagoIncorrectoException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PagoInsuficienteException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoHayBebidaException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getX()>=90 && e.getX()<=90+120 && e.getY()>=285 && e.getY()<=285+25){
            try {
                com.cualBebida(2);
            } catch (PagoIncorrectoException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PagoInsuficienteException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoHayBebidaException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(e.getX()>=90 && e.getX()<=90+120 && e.getY()>=315 && e.getY()<=315+25){
            try {
                com.cualBebida(3);
            } catch (PagoIncorrectoException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PagoInsuficienteException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoHayBebidaException ex) {
                Logger.getLogger(PanelPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } /*el comprador puede recoger su vuelto tanto con click derecho como izquierdo*/
        if(e.getX()>=492 && e.getX()<=492+310 && e.getY()>=519 && e.getY()<= 519+80){
           if(SwingUtilities.isRightMouseButton(e)){
                while(com.getVuelto()!=null){
                    com.getVuelto();
                }
            }
            if(SwingUtilities.isLeftMouseButton(e)){
                com.getVuelto();
            }
        }
        if(e.getX()>= 830 && e.getX()<= 830+150 && e.getY()>=520 && e.getY()<=520+33){
            com.getBebida();
        }
        if(e.getX()>= 90 && e.getX()<= 90+50 && e.getY()>= 160 && e.getY()<= 160+50){
            com.addMoneda100();
        }
        if(e.getX()>=150 && e.getX()<=150+50 && e.getY()>=160 && e.getY()<= 160+50){
            com.addMoneda500();
        }
        if(e.getX()>=210 && e.getX()<=210+50 && e.getY()>=160 && e.getY()<= 160+50){
            com.addMoneda1000();
        }
        this.repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
