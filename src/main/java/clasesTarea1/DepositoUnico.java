package clasesTarea1;

import java.awt.*;

/**
 * La clase representa un depósito que almacena una bebida a la vez.
 *  Esta clase permite agregar una bebida,
 * retirarla y dibujar su representación gráfica.
 */
public class DepositoUnico {
   Bebida be;
   private int x,y;

    /**
     * Constructor
     * Inicializa las coordenadas donde se ubicará el depósito de bebida en la interfaz gráfica.
     *
     * @param x La coordenada x en la interfaz gráfica para la ubicación del depósito.
     * @param y La coordenada y en la interfaz gráfica para la ubicación del depósito.
     */
   public DepositoUnico(int x, int y){
       this.x=x; this.y=y;
   }

    /**
     * Agrega una bebida al depósito único. Si ya hay una bebida en el depósito,
     * esta será reemplazada por la nueva bebida.
     *
     * @param b La bebida a agregar al depósito.
     */
   public void addBebida(Bebida b){
       be = b;
   }

    /**
     * Retira la bebida del depósito único. Si no hay bebida en el depósito,
     * devuelve null.
     *
     * @return La bebida almacenada en el depósito o null si no hay bebida.
     */
   public Bebida getBebida(){
       Bebida b = be;
       be = null;
       return b;
   }

    /**
     * Dibuja la representación gráfica del depósito único y de la bebida almacenada.
     * Si hay una bebida, también se dibuja un mensaje que indica que puede ser retirada.
     *
     * @param g El objeto graphics usado para dibujar en la interfaz gráfica.
     */
   public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawRect(x+230, y+470, 150,33);
        g.setColor(Color.black);
        g.fillRect(x+231, y+471, 149, 32);

       if (be != null) {
           be.setXY(x + 231, y + 470);
           be.paint(g);


           g.setColor(Color.black);
           g.setFont(new Font("SansSerif", Font.BOLD, 12));
           g.drawString("Retire aquí", 870, 570);
       }
    }
}
