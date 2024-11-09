package clasesTarea1;

import java.awt.*;

class Moneda100 extends Moneda{
    private Color brown=new Color(153,102,0);
    public Moneda100(int serie, int x, int y){
        super(serie,x,y);

    }
    
    @Override
    public int getValor(){
        return 100;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(brown);
        g.fillOval(x, y, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x, y, 50, 50);
        g.setColor(Color.white);
        g.drawString(Integer.toString(100), x + 15, y+30);
    }
}