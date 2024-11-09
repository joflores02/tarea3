package clasesTarea1;

/**
 * Excepción para manejar pagos incorrectos.
 */
public class NoHayBebidaException extends Exception {
    public NoHayBebidaException(String mensaje) {
        super(mensaje);
    }
}
