package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que representa un depósito de bebidas en un expendedor.
 * Se encarga de almacenar, gestionar y dibujar las bebidas disponibles en el depósito.
 */
public class Deposito {
    private ArrayList<Bebida> bebs;
    private int x,y,aux;

    /**
     * Constructor de la clase Depósito.
     * Inicializa el depósito con las coordenadas proporcionadas y crea una lista vacía de bebidas.
     *
     * @param x La coordenada x en la interfaz gráfica para la ubicación del depósito.
     * @param y La coordenada y en la interfaz gráfica para la ubicación del depósito.
     */
    public Deposito(int x,int y){
        this.x=x;this.y=y;
        bebs = new ArrayList<Bebida>();
    }

    /**
     * Agrega una bebida al depósito. La bebida se coloca en la posición correspondiente
     * en la interfaz gráfica.
     *
     * @param bebida La bebida a agregar al depósito.
     */
    public void addBebida(Bebida bebida){
        bebs.add(bebida);
        bebida.setXY(x, y+315+aux);
        aux-=35;
    }

    /**
     * Verifica si el depósito está vacío.
     *
     * @return true si el depósito está vacío y false si está lleno.
     */
    public boolean isEmpty(){
        return bebs.isEmpty();
    }


    /**
     * Obtiene una bebida del depósito. Si el depósito está vacío, se imprime un mensaje
     * y se retorna null.
     *
     * @return La bebida obtenida del depósito o null si el depósito está vacío.
     */
    public Bebida getBebida(){
        if(bebs.size() == 0){
            System.out.println("Depósito vacío");
            return null;
        }
        aux=0;
        return bebs.remove(0);
    }

    /**
     * Dibuja la representación gráfica del depósito y las bebidas almacenadas en él.
     *
     * @param g El objeto graphics usado para dibujar en la interfaz gráfica.
     */
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawRect(x, y, 150,350);
        g.setColor(Color.white);
        g.fillRect(x+1, y+1, 149, 349);
        for (int i = bebs.size() - 1; i >= 0; i--) {
            Bebida p = bebs.get(i);
            p.paint(g);
        }
    }
}