package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

public class DepositoMonedas {
    private int x,y, aux;
    private ArrayList<Moneda> dm;
    public DepositoMonedas(int x,int y){
        this.x=x;this.y=y;
        dm=new ArrayList<Moneda>();
    }
    public void addMoneda(Moneda moneda){
        dm.add(moneda);
        moneda.setXY(x+320+aux, y+395);
        aux-=3;
    }
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