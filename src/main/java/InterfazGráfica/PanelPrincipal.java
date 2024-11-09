package InterfazGráfica;

import clasesTarea1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PanelPrincipal extends JPanel implements MouseListener{
    private Comprador com;
    private Expendedor exp;

    public PanelPrincipal() throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        exp=new Expendedor(10,3000,600,50);
        com=new Comprador(exp,70,50);
        this.setBackground(Color.darkGray);
        this.addMouseListener(this);


    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(exp!=null)exp.paint(g);
        if(com!=null)com.paint(g);
    }


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

        }
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