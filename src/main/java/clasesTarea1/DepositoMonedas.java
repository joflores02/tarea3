package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

/**
 * La clase representa un depósito de monedas en un expendedor.
 * Se encarga de almacenar y dibujar las monedas disponibles en el depósito.
 */
public class DepositoMonedas {
    private int x,y, aux, posicionInicialX;
    private ArrayList<Moneda> dm;
    private static final int MAX_MONEDAS = 140;

    /**
     * Constructor de la clase.
     * Inicializa el depósito con las coordenadas proporcionadas y crea una lista vacía de monedas.
     *
     * @param x La coordenada x en la interfaz gráfica para la ubicación del depósito de monedas.
     * @param y La coordenada y en la interfaz gráfica para la ubicación del depósito de monedas.
     */
    public DepositoMonedas(int x,int y){
        this.x=x;this.y=y;
        dm=new ArrayList<Moneda>();
        this.posicionInicialX = x + 320;
    }

    /**
     * Agrega una moneda al depósito. La moneda se coloca en la posición correspondiente
     * en la interfaz gráfica, desplazándose hacia la izquierda de acuerdo con el número
     * de monedas ya almacenadas. Si se alcanza el máximo de 140 monedas, el ciclo
     * de posiciones se reinicia, pero el desplazamiento continúa.
     *
     * @param moneda La moneda a agregar al depósito.
     */
    public void addMoneda(Moneda moneda){
        if (dm.size() % MAX_MONEDAS == 0) { // Cada vez que llega al máximo vuelve a la posición inicial
            aux = 0;
        }
        dm.add(moneda);

        moneda.setXY(posicionInicialX + aux, y + 395); // Establecer la posición de la moneda con el desplazamiento actual

        aux -= 3; // Desplazar la posición para la próxima moneda
    }

    /**
     * Dibuja la representación gráfica del depósito de monedas y las monedas almacenadas en él.
     *
     * @param g El objeto {@code Graphics} usado para dibujar en la interfaz gráfica.
     */
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawRect(x-108, y+384, 487,70);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x-107, y+385, 486, 69);
        for(Moneda m:dm){
            m.paint(g);
        }
    }
}