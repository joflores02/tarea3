package clasesTarea1;

import java.awt.*;


/**
 * Clase abstracta que representa una bebida.
 * CocaCola, Fanta y Sprite extienden esta clase
 */

abstract class Bebida{
    private int serie;
    protected int x,y;

    /**
     * Constructor de la clase Bebida.
     *
     * @param serie Número de serie de la bebida.
     * @param x Coordenada x para la posición gráfica de la bebida.
     * @param y Coordenada y para la posición gráfica de la bebida.
     */
    public Bebida(int serie, int x, int y) {
        this.serie = serie;
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene el número de serie de la bebida.
     *
     * @return El número de serie de la bebida.
     */
    public int getSerie(){
        return this.serie;
    }

    /**
     * Establece las coordenadas de la bebida en la interfaz gráfica.
     *
     * @param x Nueva coordenada x.
     * @param y Nueva coordenada y.
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Método abstracto que define la acción de beber para cada tipo de bebida.
     * Cada bebida específica debe implementar este método para describir cómo se "bebe".
     *
     * @return Una cadena que describe la acción de beber la bebida.
     */
    public abstract String beber();

    /**
     * Método abstracto que define la representación gráfica de la bebida.
     * Cada tipo de bebida debe implementar este método para pintar su propia imagen
     * en la interfaz gráfica.
     *
     * @param g El objeto Graphics utilizado para pintar la bebida.
     */
    public abstract void paint(Graphics g);
}
