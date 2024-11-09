package clasesTarea1;

/**
 * Excepción para manejar pagos insuficientes.
 */
public class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
