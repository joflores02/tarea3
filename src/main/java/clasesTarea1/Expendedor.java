package clasesTarea1;

import java.awt.*;
import java.util.ArrayList;

/**
 * La clase representa un expendedor de bebidas que permite comprar, rellenar y administrar depósitos de bebidas y monedas.
 * El expendedor permite comprar bebidas, verificar la disponibilidad, recibir el pago y entregar el vuelto.
 */
public class Expendedor {
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    private DepositoMonedas dm;
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private DepositoVuelto vuelto;
    private DepositoUnico du;
    private int precioBebidas;
    private final int x;
    private final int y;
    private int serieMon100;
    private int numBebidas;
    int serieCoca = 100;
    int serieSprite = 200;
    int serieFanta = 300;

    /**
     * Constructor que inicializa el expendedor con las coordenadas, número de bebidas y precio de las bebidas.
     * También inicializa todos los depósitos.
     *
     * @param numBebidas El número de bebidas en cada depósito.
     * @param precioBebidas El precio de cada bebida.
     * @param x La coordenada x para la ubicación del expendedor en la interfaz gráfica.
     * @param y La coordenada y para la ubicación del expendedor en la interfaz gráfica.
     */
    public Expendedor(int numBebidas, int precioBebidas, int x, int y){
        this.precioBebidas = precioBebidas;
        dm=new DepositoMonedas(x,y);
        du= new DepositoUnico(x,y);
        vuelto = new DepositoVuelto(x-108,y+469);
        coca = new Deposito(x-109,y+19);
        sprite = new Deposito(x+60, y+19);
        fanta = new Deposito(x+230, y+19);
        this.x=x; this.y=y;
        this.numBebidas=numBebidas;
        rellenarCoca();
        rellenarSprite();
        rellenarFanta();
    }

    /**
     * Dibuja la representación gráfica del expendedor y sus depósitos.
     *
     * @param g El objeto graphocs usado para dibujar en la interfaz gráfica.
     */
    public void paint(Graphics g){
        Color lb=new Color(51,153,255);
        g.setColor(Color.white);
        g.drawRect(x-130, y-20, 530, 621);
        g.setColor(lb);
        g.fillRect(x-129, y-19, 529, 620);
        coca.paint(g);
        sprite.paint(g);
        fanta.paint(g);
        dm.paint(g);
        du.paint(g);
        vuelto.paint(g);
    }


    /**
     * Permite comprar una bebida seleccionada por el usuario.
     *
     * @param m Una lista de monedas que el usuario ha insertado en el expendedor.
     * @param cual El identificador de la bebida que el usuario quiere comprar (COCA, SPRITE, o FANTA).
     *
     * @throws PagoIncorrectoException Si el pago realizado es incorrecto.
     * @throws PagoInsuficienteException Si el pago realizado es insuficiente para la compra.
     * @throws NoHayBebidaException Si no hay bebida disponible para la compra.
     */
    public void comprarBebida(ArrayList<Moneda> m, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        int vueltoDep=0;
        if(!m.isEmpty()){
            for(Moneda moneda:m){
                vueltoDep+=moneda.getValor();
                dm.addMoneda(moneda);
            }
        
        if(vueltoDep<precioBebidas){
            throw new PagoInsuficienteException("SALDO INSUFICIENTE PARA COMPRAR BEBIDA");
        }
        
        Bebida cocaColaBebida;
        Bebida spriteBebida;
        Bebida fantaBebida;
        
        if(cual==COCA && vueltoDep>=precioBebidas){
            cocaColaBebida=coca.getBebida();
            if(cocaColaBebida!=null){
                vueltoDep-=precioBebidas;
                du.addBebida(cocaColaBebida);
            }
        }

        if(cual==SPRITE && vueltoDep>=precioBebidas){
            spriteBebida=sprite.getBebida();
            if(spriteBebida!=null){
                vueltoDep-=precioBebidas;
                du.addBebida(spriteBebida);
            }
        }
        
        if(cual==FANTA && vueltoDep>=precioBebidas){
            fantaBebida=fanta.getBebida();
            if(fantaBebida!=null){
                vueltoDep-=precioBebidas;
                du.addBebida(fantaBebida);
            }
        }
        
        while(vueltoDep>0){
            vuelto.addMoneda(new Moneda100(serieMon100,0,0));
            vueltoDep-=100;
            serieMon100++;
        }
    }else{
            throw new PagoInsuficienteException("INGRESE DINERO PARA COMPRAR");
        }
    }


    /**
     * Rellena el depósito de CocaCola asegurandose de no exceder el máximo.
     */
    public void rellenarCoca(){
        if (coca.isEmpty()) {
            for (int i = 0; i < numBebidas; i++) {
                coca.addBebida(new CocaCola(serieCoca++, x, y));
            }
            System.out.println("Depósito Coca Cola rellenado");
        } else {
            System.out.println("No se puede rellenar el depósito de Coca Cola. El depósito no está vacío.");
        }
    }

    /**
     * Rellena el depósito de Sprite asegurandose de no exceder el máximo.
     */
    public void rellenarSprite(){
        if (sprite.isEmpty()) {
            for (int i = 0; i < numBebidas; i++) {
                sprite.addBebida(new Sprite(serieSprite++, x, y));
            }
            System.out.println("Depósito Sprite rellenado");
        } else {
            System.out.println("No se puede rellenar el depósito de Sprite. El depósito no está vacío.");
        }
    }

    /**
     * Rellena el depósito de Fanta asegurandose de no exceder el máximo.
     */
    public void rellenarFanta(){
        if (fanta.isEmpty()) {
            for (int i = 0; i < numBebidas; i++) {
                fanta.addBebida(new Fanta(serieFanta++, x, y));
            }
            System.out.println("Depósito Fanta rellenado");
        } else {
            System.out.println("No se puede rellenar el depósito de Fanta. El depósito no está vacío.");
        }
    }

    /**
     * Obtiene una bebida del depósito único.
     *
     * @return La bebida retirada del depósito único.
     */
    public Bebida getDepUnico(){
        return du.getBebida();
    }

    /**
     * Obtiene una moneda de vuelto del depósito de vuelto.
     *
     * @return La moneda de vuelto retirada, o {@code null} si no hay monedas.
     */
    public Moneda getVuelto(){
        return vuelto.getMoneda();
    }


    /**
     * Verifica si el depósito de CocaCola está vacío.
     *
     * @return true si el depósito de CocaCola está vacío, false de lo contrario.
     */
    public boolean isEmptyCoca(){
        return coca.isEmpty();
    }

    /**
     * Verifica si el depósito de Sprite está vacío.
     *
     * @return true si el depósito de Sprite está vacío, false de lo contrario.
     */
    public boolean isEmptySprite(){
        return sprite.isEmpty();
    }

    /**
     * Verifica si el depósito de Fanta está vacío.
     *
     * @return true si el depósito de Fanta está vacío, false de lo contrario.
     */
    public boolean isEmptyFanta(){
        return fanta.isEmpty();
    }

    /**
     * Obtiene el precio de las bebidas en el expendedor.
     *
     * @return El precio de las bebidas en el expendedor.
     */
    public int getPrecioBebida(){
        return this.precioBebidas;
    }

}