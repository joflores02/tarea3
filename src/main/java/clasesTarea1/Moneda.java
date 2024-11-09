package clasesTarea1;

import java.awt.*;

/**
 * La clase abstracta define las propiedades para diferentes tipos de monedas.
 * Cada moneda tiene una serie única y se pueden representar gráficamente.
 * Además, las monedas tienen un valor asociado que debe ser implementado por las clases concretas que la extienden.
 */
 public abstract class Moneda{
    protected int x,y,serie;

    /**
     * Constructor que inicializa una moneda con su número de serie y sus coordenadas de ubicación.
     *
     * @param serie El número de serie de la moneda.
     * @param x La coordenada x de la ubicación de la moneda en la interfaz gráfica.
     * @param y La coordenada y de la ubicación de la moneda en la interfaz gráfica.
     */
    public Moneda(int serie, int x, int y){
        this.serie=serie;
        this.x=x; this.y=y;
    }

    /**
     * Obtiene el número de serie de la moneda.
     *
     * @return El número de serie de la moneda.
     */
    public int getSerie(){
        return serie;
    }

    /**
     * Método abstracto para pintar la representación gráfica de la moneda.
     * Este método debe ser implementado por las clases concretas que extienden a Moneda,
     * para dibujar cada tipo de moneda según su propio diseño.
     *
     * @param g El objeto graphics utilizado para dibujar la moneda en la interfaz gráfica.
     */
    public abstract void paint (Graphics g);
    public abstract int getValor();
    
    public void setXY(int x, int y){
        this.x=x;this.y=y;
    }
}