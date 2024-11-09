package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

/**
 * La clase representa a un comprador que interactúa con un expendedor
 * para seleccionar y comprar bebidas, manejar monedas y recibir vuelto. También
 * gestiona la representación gráfica de sus acciones en la interfaz.
 */
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

    /**
     * Constructor de la clase Comprador.
     * Inicializa las coordenadas, el expendedor y las colecciones de monedas y bebidas.
     *
     * @param exp El expendedor con el que interactúa el comprador.
     * @param x Coordenada x en la interfaz gráfica del comprador.
     * @param y Coordenada y en la interfaz gráfica del comprador.
     * @throws PagoIncorrectoException Si el pago realizado es incorrecto.
     * @throws PagoInsuficienteException Si el pago realizado es insuficiente.
     * @throws NoHayBebidaException Si no hay bebidas disponibles en el expendedor.
     */
    public Comprador(Expendedor exp, int x, int y) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        this.x=x; this.y=y;
        this.exp=exp;
        monedero=new ArrayList<>();
        beb= new ArrayList<>();
    }

    /**
     * Agrega una moneda de 100 al monedero del comprador.
     * La moneda se agrega al listado y se actualiza el valor total de dinero.
     */
    public void addMoneda100(){
        Moneda m=new Moneda100(serieMoneda++,0,0);
        m.setXY(x+Mon100+20,y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon100-=2;
        dinero+=m.getValor();
    }

    /**
     * Agrega una moneda de 500 al monedero del comprador.
     * La moneda se agrega al listado y se actualiza el valor total de dinero.
     */
    public void addMoneda500(){
        Moneda m=new Moneda500(serieMoneda++,0,0);
        m.setXY(x+Mon500+35*4, y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon500-=2;
        dinero+=m.getValor();
    }

    /**
     * Agrega una moneda de 1000 al monedero del comprador.
     * La moneda se agrega al listado y se actualiza el valor total de dinero.
     */
    public void addMoneda1000(){
        Moneda m=new Moneda1000(serieMoneda++,0,0);
        m.setXY(x+Mon1000+(30*4)*2+30, y+320);
        System.out.println("Serie: "+m.getSerie());
        monedero.add(m);
        Mon1000-=2;
        dinero+=m.getValor();
    }

    /**
     * Obtiene el vuelto del expendedor y lo agrega al monedero del comprador.
     * El vuelto también se dibuja en la interfaz gráfica.
     *
     * @return La moneda que representa el vuelto.
     */
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

    /**
     * Resetea las monedas del comprador y el vuelto.
     */
    public void resetMonedas(){
        Mon100=0;
        Mon500=0;
        Mon1000=0;
        vuelto=0;
    }

    /**
     * Realiza la compra de una bebida seleccionada y resetea el estado de las monedas.
     *
     * @param cual El índice que indica qué bebida comprar.
     * @throws PagoIncorrectoException Si el pago realizado es incorrecto.
     * @throws PagoInsuficienteException Si el pago realizado es insuficiente.
     * @throws NoHayBebidaException Si no hay bebidas disponibles en el expendedor.
     */
    public void cualBebida(int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        resetMonedas();
        dinero=0;
        exp.comprarBebida(monedero, cual);
        monedero.clear();
    }

    /**
     * Obtiene la bebida comprada del expendedor y la agrega al listado de bebidas del comprador.
     * Y establece las coordenadas gráficas para la bebida.
     */
    public void getBebida(){
        Bebida b=exp.getDepUnico();
        if(b!=null){
           auxB+=5;
           System.out.println("Bebida: "+b.beber()+ "Serie: "+b.getSerie());
           b.setXY(x+10, y+500+auxB);
           beb.add(b);
        }
    }

    /**
     * Dibuja la representación gráfica del comprador, incluyendo el contorno del área
     * de selección de monedas, el área de selección de bebidas y las bebidas compradas.
     *
     * @param g El objeto Graphics usado para dibujar en la interfaz gráfica.
     */
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.drawRect(x, y, 350, 600);
        Color color = new Color(102, 40, 153);
        g.setColor(color);
        g.fillRect(x + 1, y + 1, 349, 599);

        //Recuadro del precio
        g.setColor(Color.white);
        g.drawRect(x+17, y+20,  150, 40);
        g.setColor(Color.black);
        g.fillRect(x+17,y+20,149,39);
        int precioBebida = exp.getPrecioBebida();
        String precioTexto = "Precio: $" + precioBebida;
        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.drawString(precioTexto,x+26,y+47);

        //Recuadro para ingresar el dinero.
        g.setColor(Color.white);
        g.setFont(new Font("Dialog", Font.PLAIN, 14));
        g.drawString("Seleccionar monedas",x+20,y+90);

        Color brown=new Color(153,102,0);
        g.setColor(brown);
        g.fillOval(x+20, y+110, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x+20, y+110, 50, 50);
        g.setColor(Color.white);
        g.drawString("100", x+34, y+139);

        Color grey=new Color(204,204,204);
        g.setColor(grey);
        g.fillOval(x+80, y+110, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x+80, y+110, 50, 50);
        g.setColor(Color.white);
        g.drawString("500", x+95, y+139);

        Color gold=new Color(255,204,51);
        g.setColor(gold);
        g.fillOval(x+140, y+110, 50, 50);
        g.setColor(Color.black);
        g.drawOval(x+140, y+110, 50, 50);
        g.setColor(Color.white);
        g.drawString("1000", x+151, y+139);


        //Selección bebida
        g.setColor(Color.white);
        g.drawString("Elija sabor de la bebida", x+20,y+192);
        g.setColor(Color.black);
        g.drawRect(x+20,y+205,120,25);
        g.setColor(Color.red);
        g.fillRect(x+20, y+205, 120, 25);
        g.setColor(Color.white);
        g.drawString("Coca Cola", x+50, y+223);

        g.setColor(Color.black);
        g.drawRect(x+20,y+235,120,25);
        g.setColor(Color.green);
        g.fillRect(x+20, y+235, 120, 25);
        g.setColor(Color.white);
        g.drawString("Sprite", x+60, y+253);

        g.setColor(Color.black);
        g.drawRect(x+20,y+265,120,25);
        Color o=new Color(255,153,0);
        g.setColor(o);
        g.fillRect(x+20, y+265, 120, 25);
        g.setColor(Color.white);
        g.drawString("Fanta", x+60, y+283);

        for(Bebida bebida:beb){
            bebida.paint(g);
        }



        g.setColor(Color.white);
        g.drawString("Dinero a ingresar", x+20,y+315);
        g.drawString("Vuelto", x+20,y+270+(270-140));
        g.drawString("Bebida Comprada", x+20,y+260+2*(260-140));

        for(Moneda moneda:monedero){
            moneda.paint(g);
        }

    }

    /**
     * Obtiene la cantidad de vuelto acumulado por el comprador.
     *
     * @return El monto total de vuelto recibido.
     */
    public int cuantoVuelto(){
        return vuelto;
    }
}