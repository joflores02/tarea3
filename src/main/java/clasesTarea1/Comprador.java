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

    }

    public void addMoneda500(){

    }
    public void addMoneda1000(){

    }

    public Moneda getVuelto(){

    }

    public void resetMonedas(){
        Mon100=0;
        Mon500=0;
        Mon1000=0;
        vuelto=0;
    }

    public void cualBebida(int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{

    }

    public void getBebida(){

    }


    public int cuantoVuelto(){
        return vuelto;
    }
}