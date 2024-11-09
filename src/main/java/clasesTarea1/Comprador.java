package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

public class Comprador {
    private Expendedor exp;
    private int vuelto;
    private String saborBebida;
    private int x,y;
    private int dinero;
    private int auxB;
    public ArrayList<Moneda> monedero;
    private ArrayList<Bebida> beb;
    public int Mon100, Mon500, Mon1000;
    private int serieMoneda=500;

    public Comprador(Expendedor exp, int x, int y) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        this.x=x; this.y=y;
        this.exp=exp;
        monedero=new ArrayList<>();
        beb= new ArrayList<>();
    }

    public void addMoneda100(){
        Moneda m=new Moneda100(serieMoneda++,0,0);
        m.setXY(x+Mon100+20,y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon100-=2;
        dinero+=m.getValor();
    }

    public void addMoneda500(){
        Moneda m=new Moneda500(serieMoneda++,0,0);
        m.setXY(x+Mon500+35*4, y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon500-=2;
        dinero+=m.getValor();
    }
    public void addMoneda1000(){
        Moneda m=new Moneda1000(serieMoneda++,0,0);
        m.setXY(x+Mon1000+(30*4)*2+30, y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon1000-=2;
        dinero+=m.getValor();
    }

    public Moneda getVuelto(){
        Moneda m=exp.getVuelto();
        if(m!=null){
            dinero+=m.getValor();
            System.out.println("Vuelto: "+m.getValor());
            m.setXY(x+10+vuelto, y+417);
            vuelto+=2;
            monedero.add(m);
        }return m;
    }

    public void resetMonedas(){
        Mon100=0;
        Mon500=0;
        Mon1000=0;
        vuelto=0;
    }

    public void cualBebida(int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        resetMonedas();
        dinero=0;
        exp.comprarBebida(monedero, cual);
        monedero.clear();
    }

    public void getBebida(){
        Bebida b=exp.getDepUnico();
        if(b!=null){
           auxB+=5;
           System.out.println("Bebida: "+b.beber()+ "Serie: "+b.getSerie());
           b.setXY(x+10, y+500+auxB);
           beb.add(b);
        }
    }

    public int cuantoVuelto(){
        return vuelto;
    }
}