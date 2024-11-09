package clasesTarea1;

import java.awt.*;

/**
 * Esta clase se encarga de dibujar una moneda con un valor de 500 en la interfaz gráfica
 * y proporcionar la funcionalidad asociada a este tipo de moneda.
 */
class Moneda500 extends Moneda{
    private Color grey=new Color(204,204,204);

    /**
     * Constructor que inicializa una moneda de valor 500 con su número de serie y posición.
     *
     * @param serie El número de serie de la moneda.
     * @param x La coordenada x para la ubicación de la moneda.
     * @param y La coordenada y para la ubicación de la moneda.
     */
    public Moneda500(int serie, int x, int y){
        super(serie,x,y);

    }

    /**
     * Obtiene el valor de la moneda. En el caso de la moneda 500, este valor es 500.
     *
     * @return El valor de la moneda, que es 500.
     */
    @Override
    public int getValor(){
        return 500;
    }


    /**
     * Dibuja la representación gráfica de la moneda de 500 en la interfaz gráfica.
     * La moneda se dibuja como un círculo con el número 500 en su interior.
     *
     * @param g El objeto graphics utilizado para dibujar la moneda en la interfaz gráfica.
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(grey);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(Integer.toString(500), x + 15, y+30);
    }
}