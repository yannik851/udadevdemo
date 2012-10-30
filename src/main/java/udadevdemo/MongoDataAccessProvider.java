/*
 * Created on @Oct 29, 2012
 * Copyright - Confidential use
 */
package udadevdemo;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Set;

/**
 * Class MongoDataAccessProvider
 *
 * Implementacion del contrato de acceso a datos definido en la interfaz
 * {@link DataAccessProvider} que permite interactuar con el motor de base de
 * datos no relacional MongoDB.
 */
public class MongoDataAccessProvider implements DataAccessProvider {

    private DB driverClient;

    private Mongo mongoConexion;

    /**
     * Establece una conexion con el servicio MongoDB, asignando como schema
     * base el suministrado como argumento.
     *
     * @param databaseName nombre del esquema al cual se debe realizar la
     * conexion
     */
    public MongoDataAccessProvider(String databaseName) throws DataAccessException {
        try {
            mongoConexion = new Mongo("localhost");

            driverClient = mongoConexion.getDB(databaseName);

            // ejecutar la conexion con autenticacion, si el servidor
            // esta configurado para tal fin
            driverClient.authenticate("root", "root".toCharArray());

        } catch (UnknownHostException uhe) {
            throw new DataAccessException("El host del servicio MongoDB es invalido");
        }
    }

    //--------------------------------------------------------------------------
    // Implementacion de metodos de la interfaz DataAccessProvider
    //--------------------------------------------------------------------------
    /**
     * @see DataAccessProvider#buscarItems(java.lang.String)
     */
    @Override
    public Object[][] buscarItems(String nombreColeccionColumna) {

        DBCollection collection = driverClient.getCollection(nombreColeccionColumna);

        // El objeto del tipo DBCursor nos permitira iterar sobre todos los
        // documentos obtenidos al momento de realizar la consulta.
        // Ejecutado de la siguiente forma:
        // collection.find().skip(20).limit(50);
        // podriamos realizar un esquema de paginacion sobre los documentos a obtener o
        // en otro caso limitar el total de elementos a retornar.
        //
        // Para ejecutar una consulta segun un criterio pre-establecido
        // solo bastaria realizar la sigueinte invocacion:
        //
//        BasicDBObject bObject = new BasicDBObject();
//        bObject.append("estatus", 1); // filtrar los documentos de la coleccion, por el estatus = 1
//        collection.find(bObject);
        DBCursor documentosDeLaColeccion = collection.find();

        Object[][] results = new Object[documentosDeLaColeccion.size()][];

        int rowIndex = 0;

        while (documentosDeLaColeccion.hasNext()) {

            // cada documento se representa por medio de la Interfaz DBObject
            // la cual ofrece un API para acceder por medio del nombre de 
            // cadaa atributo a su valor correspondiente.
            DBObject documento = documentosDeLaColeccion.next();

            Set nombreDeLasColumnas = documento.keySet();

            Object[] valores = new Object[nombreDeLasColumnas.size()];

            int index = 0;

            for (Object columna : nombreDeLasColumnas) {
                valores[index++] = columna.toString() + " = " + documento.get(columna.toString()).toString();
            }

            results[rowIndex++] = valores;
        }
        return results;
    }

    /**
     * @see DataAccessProvider#registrarDocumento(java.util.Map,
     * java.lang.String)
     */
    @Override
    public void registrarDocumento(Map<String, Object> items, String nombreColeccionColumna) {

        DBCollection collection = driverClient.getCollection(nombreColeccionColumna);

        // la forma mas simple de crear un nuevo documento, es cosntruir una
        // instancia del tipo BasicDBObject a partir de un mapa de clave/valor
        // De forma manual, seria algo similar a esto:
        // 
        // BasicDBObject bObject = new BasicDBObject();
        // bObject.append("estatus", "NO SOLUCIONADO");
        // bObject.append("id_problema", 12212);
        // bObject.append("id_tipo_problema", 121211);
        // collection.insert(bObject);        
        collection.insert(new BasicDBObject(items));
    }

    /**
     * @see DataAccessProvider#closeConnection()
     */
    public void closeConnection() {
        mongoConexion.close();
    }
}
