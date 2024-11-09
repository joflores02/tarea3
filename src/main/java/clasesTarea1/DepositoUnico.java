package clasesTarea1;

import java.awt.*;

public class DepositoUnico {
   Bebida be;
   private int x,y;

   public DepositoUnico(int x, int y){
       this.x=x; this.y=y;
   } 
   public void addBebida(Bebida b){
       be = b;
   }
   public Bebida getBebida(){
       Bebida b = be;
       be = null;
       return b;
   }
   
   public void paint(Graphics g){
        g.setColor(Color.white);
        g.drawRect(x+230, y+470, 150,33);
        g.setColor(Color.black);
        g.fillRect(x+231, y+471, 149, 32);

       if (be != null) {
           be.setXY(x + 231, y + 470);
           be.paint(g);


           g.setColor(Color.black);
           g.setFont(new Font("SansSerif", Font.BOLD, 12));
           g.drawString("Retire aquí", 870, 570);
       }
    }
}
