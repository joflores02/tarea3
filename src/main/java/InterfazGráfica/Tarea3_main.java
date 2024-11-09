package InterfazGráfica;

import clasesTarea1.NoHayBebidaException;
import clasesTarea1.PagoIncorrectoException;
import clasesTarea1.PagoInsuficienteException;


/**
 * Clase que contiene el método principal que inicia la aplicación de la máquina expendedora.
 *
 */
public class Tarea3_main {

    /**
     * Muestra las instrucciones iniciales en la consola
     * y crea una ventana, que representa la interfaz gráfica de la máquina expendedora.
     *
     * @throws PagoIncorrectoException Excepción lanzada si el pago realizado es incorrecto.
     * @throws PagoInsuficienteException Excepción lanzada si el pago realizado es insuficiente.
     * @throws NoHayBebidaException Excepción lanzada si no hay bebidas disponibles en la máquina expendedora.
     */
    public static void main(String[] args) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException {
        // Imprime las instrucciones iniciales para el usuario
        System.out.println("INSTRUCCIONES");
        System.out.print("Debes elegir primero la cantidad de dinero que quieras y posteriormente la bebida\n(Asegúrate que la cantidad de dinero sea mayor al precio de las bebidas, el cual es 3000 pesos)\n");
        System.out.println("Depósitos:\nMonedas-Gris-NO INTERACCION\nBlanco-Vuelto-INTERACCION CLICK DERECHO E IZQUIERDO\nNegro-Retirar-INTERACCION CLICK IZQUIERDO\n");

        // Crea una nueva instancia de Ventana, que inicia la interfaz gráfica
        Ventana v= new Ventana();
    }
}
