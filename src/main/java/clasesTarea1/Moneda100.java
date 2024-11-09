package clasesTarea1;

import java.awt.*;

/**
 * Esta clase se encarga de dibujar una moneda con un valor de 100 en la interfaz gráfica
 * y proporcionar la funcionalidad asociada a este tipo de moneda.
 */
class Moneda100 extends Moneda{
    private Color brown=new Color(153,102,0);

    /**
     * Constructor que inicializa una moneda de valor 100 con su número de serie y posición.
     *
     * @param serie El número de serie de la moneda.
     * @param x La coordenada x para la ubicación de la moneda.
     * @param y La coordenada y para la ubicación de la moneda.
     */

    public Moneda100(int serie, int x, int y){
        super(serie,x,y);

    }

    /**
     * Obtiene el valor de la moneda. En el caso de la moneda 100, este valor es 100.
     *
     * @return El valor de la moneda, que es 100.
     */
    @Override
    public int getValor(){
        return 100;
    }

    /**
     * Dibuja la representación gráfica de la moneda de 100 en la interfaz gráfica.
     * La moneda se dibuja como un círculo con el número 100 en su interior.
     *
     * @param g El objeto graphics utilizado para dibujar la moneda en la interfaz gráfica.
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(brown);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(Integer.toString(100), x + 15, y+30);
    }
}