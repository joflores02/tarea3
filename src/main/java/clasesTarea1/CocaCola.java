package clasesTarea1;

import java.awt.*;

/**
 * Clase que representa una bebida de tipo CocaCola.
 */
class CocaCola extends Bebida{

    /**
     * Constructor de la clase CocaCola.
     *
     * @param serie Número de serie único para identificar esta bebida CocaCola.
     * @param x Coordenada x para la posición gráfica de la bebida.
     * @param y Coordenada y para la posición gráfica de la bebida.
     */
    public CocaCola(int serie, int x, int y) {
        super(serie, x, y);
    }

    /**
     * Acción de beber la CocaCola.
     * Este método devuelve una cadena que representa el nombre de la bebida.
     *
     * @return Un String que indica que la bebida es CocaCola.
     */
    @Override
    public String beber(){
        return "Cocacola";
    }

    /**
     * Dibuja la representación gráfica de la CocaCola en la interfaz.
     * @param g El objeto Graphics que se utiliza para dibujar la CocaCola en la interfaz.
     */
    @Override
    public void paint (Graphics g){
        g.setColor(Color.black);
        g.drawRect(x+3,y+3,143,26);
        g.setColor(Color.red);
        g.fillRect(x+4, y+4, 142, 25);
        g.setColor(Color.white);
        g.drawString(Integer.toString(getSerie()), x+60, y+21);
    }
}