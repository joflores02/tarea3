package clasesTarea1;

import java.awt.*;

class Moneda1000 extends Moneda{
    private Color gold=new Color(255,204,51);
    public Moneda1000(int serie, int x, int y){
        super(serie,x,y);

    }
    
    @Override
    public int getValor(){
        return 1000;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(gold);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(Integer.toString(1000), x + 10, y+30);
    }
}