package clasesTarea1;

/**
 * Excepción para manejar la falta de productos.
 */
public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(String mensaje) {
        super(mensaje);
    }
}
