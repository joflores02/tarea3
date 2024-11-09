package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;


/**
 * La clase representa un depósito de monedas de vuelto en un expendedor.
 * Almacena monedas de vuelto que pueden ser retiradas por el comprador.
 */
public class DepositoVuelto {
    private int x,y,aux;
    private ArrayList<Moneda> m;

    /**
     * Constructor de la clase.
     * Inicializa las coordenadas donde se ubicará el depósito de vuelto en la interfaz gráfica.
     *
     * @param x La coordenada x en la interfaz gráfica para la ubicación del depósito.
     * @param y La coordenada y en la interfaz gráfica para la ubicación del depósito.
     */
    public DepositoVuelto(int x, int y){
        this.x=x;this.y=y;
        m = new ArrayList<Moneda>();
    }

    /**
     * Agrega una moneda al depósito de vuelto. La moneda se posiciona de acuerdo a las coordenadas
     * y al espacio disponible en el depósito.
     *
     * @param moneda La moneda a agregar al depósito de vuelto.
     */
    public void addMoneda(Moneda moneda){
        m.add(moneda);
        moneda.setXY(x+255+aux, y+15);
        aux-=3;
    }

    /**
     * Dibuja la representación gráfica del depósito de vuelto, así como las monedas almacenadas.
     * Si el depósito contiene monedas, se dibuja un mensaje indicando que el usuario puede retirar el vuelto.
     *
     * @param g El objeto graphics usado para dibujar en la interfaz gráfica.
     */
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawRect(x, y, 310,80);
        g.setColor(Color.white);
        g.fillRect(x+1, y+1, 309, 79);

        for(Moneda moneda:m){
            moneda.paint(g);
        }
        if (!m.isEmpty()) {
            g.setColor(Color.black);
            g.setFont(new Font("SansSerif", Font.BOLD, 12));
            g.drawString("Retire su vuelto", 710, 615);
        }
    }

    /**
     * Retira todas las monedas almacenadas en el depósito y las devuelve como una lista de monedas.
     * El depósito queda vacío después de la operación.
     *
     * @return Una lista que contiene todas las monedas de vuelto.
     */
    public ArrayList<Moneda> retirarTodoElVuelto() {
        ArrayList<Moneda> vueltoCompleto = new ArrayList<>(m);
        m.clear();
        return vueltoCompleto;
    }

    /**
     * Retira una moneda del depósito de vuelto. Si el depósito está vacío, devuelve null.
     *
     * @return La moneda retirada, o null si no hay monedas en el depósito.
     */
    public Moneda getMoneda(){
        if(m.size() < 1){
            return null;
        }
        aux=0;
        return m.remove(0);
    }
}