/*
 * Created on @Oct 30, 2012
 * Copyright - Confidential use
 */
package udadevdemo;

import java.util.Map;

/**
 * Interface DataAccessProvider
 *
 * Contrato que encapsula funcionalidades basicas de registro y consulta de
 * informacion de un almacen NOSQL
 */
public interface DataAccessProvider {

    /**
     * Obtiene en forma generica los valores asociados a una familia de columnas
     * o coleccion de datos segun el modelo de base de datos no relacional.
     *
     *
     * @param nombreColeccionColumna nombre de la coleccion o familia de columna
     * a utilizar.
     *
     * @return coleccion de elementos que estan almacenados en la familia de
     * columnas o coleccion de datos utilizada.
     *
     * @throws DataAccessException para representar los errores de interaccion
     * con el modelo de base de datos no relacional.
     */
    Object[][] buscarItems(String nombreColeccionColumna) throws DataAccessException;

    /**
     * Registra una coleccion de elementos representada por una coleccion
     * clave/valor.
     *
     * @param items coleccion clave/valor de elementos que seran registrados
     * en la coleccion o familia de columnas provista como argumento.
     * 
     * @param nombreColeccionColumna nombre de la coleccion o familia de columna
     * a utilizar.
     * 
     * @throws DataAccessException para representar los errores de interaccion
     * con el modelo de base de datos no relacional.
     */
    void registrarDocumento(Map<String, Object> items, String nombreColeccionColumna);

    /**
     * Cierra la conexion actual con el servicio de datos no relacional.
     */
    void closeConnection();
}
