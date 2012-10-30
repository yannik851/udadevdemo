/*
 * Created on @Oct 30, 2012
 * Copyright - Confidential use
 */
package udadevdemo;

/**
 * Exception Class DataAccessException
 * 
 * Clase que permitira encapsular los errores de conexion con los
 * servicios de datos no relacionales.
 */
public class DataAccessException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>DataAccessException</code> without detail message.
     */
    public DataAccessException() {
    }

    /**
     * Constructs an instance of
     * <code>DataAccessException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public DataAccessException(String msg) {
        super(msg);
    }

    /**
     *
     * @param string
     * @param thrwbl
     */
    public DataAccessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
}
