package clasesTarea1;

import java.awt.*;


/**
 * La clase representa una bebida de tipo Fanta.
 */
class Fanta extends Bebida{

    /**
     * Constructor que inicializa una bebida de tipo Fanta con una serie y coordenadas de ubicación.
     *
     * @param serie El número de serie de la bebida Fanta.
     * @param x La coordenada x de la ubicación de la bebida en la interfaz gráfica.
     * @param y La coordenada y de la ubicación de la bebida en la interfaz gráfica.
     */
    public Fanta(int serie, int x,int y){
        super(serie, x, y);
    }

    /**
     * Representa el comportamiento de beber la bebida Fanta.
     *
     * @return El nombre de la bebida, en este caso "Fanta".
     */
    @Override
    public String beber(){
        return "Fanta";
    }

    /**
     * Dibuja la representación gráfica de la bebida Fanta en el expendedor.
     * La bebida se representa mediante un rectángulo de color naranja con el número de serie escrito en el centro.
     *
     * @param g El objeto graphics usado para dibujar en la interfaz gráfica.
     */
    @Override
    public void paint (Graphics g){
        g.setColor(Color.black);
        g.drawRect(x+3,y+3,143,26);
        Color o=new Color(255,153,0);
        g.setColor(o);
        g.fillRect(x+4, y+4, 142, 25);
        g.setColor(Color.white);
        g.drawString(Integer.toString(getSerie()), x+60, y+21);
    }
}