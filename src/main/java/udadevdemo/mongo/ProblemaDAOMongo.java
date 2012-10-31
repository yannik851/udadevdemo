/*
 * Created on @Oct 29, 2012
 * Copyright - Confidential use
 */
package udadevdemo.mongo;

import com.mongodb.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import udadevdemo.DataAccessException;

/**
 * Class ProblemaDAOMongo
 *
 * Implementacion del contrato de acceso a datos definido en las colecciones
 * Problema y TipoProblemaque permite interactuar con el motor de base de datos
 * no relacional MongoDB.
 */
public class ProblemaDAOMongo {

    private DB driverClient;

    private Mongo mongoConexion;

    /**
     * Establece una conexion con el servicio MongoDB, asignando como schema
     * base el suministrado como argumento.
     *
     * @param databaseName nombre del esquema al cual se debe realizar la
     * conexion
     */
    public ProblemaDAOMongo(String databaseName) throws DataAccessException {
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

    public List<TipoProblema> listarTipoProblemas() {

        DBCollection collection = driverClient.getCollection("tipoProblema");

        DBCursor documentosDeLaColeccion = collection.find();

        ArrayList<TipoProblema> problemas = new ArrayList<TipoProblema>();

        while (documentosDeLaColeccion.hasNext()) {

            // cada documento se representa por medio de la Interfaz DBObject
            // la cual ofrece un API para acceder por medio del nombre de 
            // cadaa atributo a su valor correspondiente.
            DBObject documento = documentosDeLaColeccion.next();

            TipoProblema problema = new TipoProblema();
            problema.setId(((Double) documento.get("id_tipo_problema")).intValue());
            problema.setNombre((String) documento.get("nombre"));

            problemas.add(problema);
        }

        return problemas;
    }

    /**
     * 
     * @param criteriosDeConsulta
     * @return 
     */
    public List<Problema> listarProblemasPorCriterio(Map<String, Object> criteriosDeConsulta) {

        DBCollection collection = driverClient.getCollection("problema");

        BasicDBObject criterioDeBusqueda = new BasicDBObject(criteriosDeConsulta);

        // ejecutar una consulta a partir de un criterio de busqueda definido
        DBCursor documentosDeLaColeccion = collection.find(criterioDeBusqueda);

        ArrayList<Problema> problemas = new ArrayList<Problema>();

        List<TipoProblema> tipoProblemas = listarTipoProblemas();

        while (documentosDeLaColeccion.hasNext()) {

            // cada documento se representa por medio de la Interfaz DBObject
            // la cual ofrece un API para acceder por medio del nombre de 
            // cadaa atributo a su valor correspondiente.
            DBObject documento = documentosDeLaColeccion.next();

            // transformar el documento de mongo a un objeto de dominio de nuestro negocio
            Problema problema = new Problema();
            problema.setId((Integer) documento.get("id_problema"));
            problema.setCoordenadaX((Double) documento.get("coordx"));
            problema.setCoordenadaY((Double) documento.get("coordy"));
            problema.setEstatus((String) documento.get("estatus"));
            problema.setFechaDeRegistro((Date) documento.get("fecha_registro"));

            TipoProblema tipoProblema = new TipoProblema();
            tipoProblema.setId((Integer) documento.get("id_tipo_problema"));

            problema.setTipoProblema(tipoProblemas.get(tipoProblemas.indexOf(tipoProblema)));

            problemas.add(problema);
        }

        return problemas;
    }
}
