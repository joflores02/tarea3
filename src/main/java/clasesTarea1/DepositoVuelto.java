package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

public class DepositoVuelto {
    private int x,y,aux;
    private ArrayList<Moneda> m;
    
    public DepositoVuelto(int x, int y){
        this.x=x;this.y=y;
        m = new ArrayList<Moneda>();
    }
    
    public void addMoneda(Moneda moneda){
        m.add(moneda);
        moneda.setXY(x+255+aux, y+15);
        aux-=3;
    }
    
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

    public ArrayList<Moneda> retirarTodoElVuelto() {
        ArrayList<Moneda> vueltoCompleto = new ArrayList<>(m);
        m.clear();
        return vueltoCompleto;
    }
    
    public Moneda getMoneda(){
        if(m.size() < 1){
            return null;
        }
        aux=0;
        return m.remove(0);
    }
}