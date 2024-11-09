package clasesTarea1;

import java.awt.*;

 public abstract class Moneda{
    protected int x,y,serie;
    public Moneda(int serie, int x, int y){
        this.serie=serie;
        this.x=x; this.y=y;
    }
    
    public int getSerie(){
        return serie;
    }
    public abstract void paint (Graphics g);
    public abstract int getValor();
    
    public void setXY(int x, int y){
        this.x=x;this.y=y;
    }
}