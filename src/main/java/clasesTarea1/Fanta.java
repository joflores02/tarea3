package clasesTarea1;

import java.awt.*;

class Fanta extends Bebida{

    public Fanta(int serie, int x,int y){
        super(serie, x, y);
    }
    
    @Override
    public String beber(){
        return "Fanta";
    }
    @Override
    public void paint (Graphics g){
        g.setColor(Color.black);
        g.drawRect(x+3,y+3,143,26);
        Color o=new Color(255,153,0);
        g.setColor(o);
        g.fillRect(x+4, y+4, 142, 25);
        g.setColor(Color.white);
        g.drawString(Integer.toString(getSerie()), x+60, y+21);
    }
}