package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> bebs;
    private int x,y,aux;
    public Deposito(int x,int y){
        this.x=x;this.y=y;
        bebs = new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida bebida){
        bebs.add(bebida);
        bebida.setXY(x, y+315+aux);
        aux-=35;
    }
    public boolean isEmpty(){
        return bebs.isEmpty();
    }   
    
    public Bebida getBebida(){
        if(bebs.size() == 0){
            System.out.println("Depósito vacío");
            return null;
        }
        aux=0;
        return bebs.remove(0);
    }
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