/*
 * Created on @Oct 29, 2012
 * Copyright - Confidential use
 */
package udadevdemo;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.apache.cassandra.thrift.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * Class CassandraDataAccessProvider
 *
 * Implementacion del contrato de acceso a datos definido en la interfaz
 * {@link DataAccessProvider} que permite interactuar con el motor de base de
 * datos no relacional Apache Cassandra.
 *
 */
public class CassandraDataAccessProvider implements DataAccessProvider {

    private Cassandra.Client client;

    private TFramedTransport conexionCassandraServer;

    /**
     * Establece una conexion con el servicio Cassandra, asignando como KeySpace
     * base el suministrado como argumento.
     *
     * @param databaseName nombre del esquema o base de datos al cual se debe
     * realizar la conexion
     */
    public CassandraDataAccessProvider(String databaseName) throws DataAccessException {

        try {
            TTransport tr = new TSocket("localhost", 9160);

            conexionCassandraServer = new TFramedTransport(tr);

            TProtocol proto = new TBinaryProtocol(conexionCassandraServer);

            client = new Cassandra.Client(proto);

            conexionCassandraServer.open();

            client.set_keyspace(databaseName);

        } catch (InvalidRequestException ex) {
            throw new DataAccessException("Ocurrio un error de conexion "
                    + "con el servicio de Cassandra, verifique el nombre del KeySpace", ex);

        } catch (TException ex) {
            throw new DataAccessException("Ocurrio un error de conexion "
                    + "con el servicio de Cassandra", ex);
        }
    }

    //--------------------------------------------------------------------------
    // Implementacion de Metodos de la Interfaz DataAccessProvider
    //--------------------------------------------------------------------------
    
    /**
     * @see DataAccessProvider#buscarItems(java.lang.String)
     */
    public Object[][] buscarItems(String nombreColeccionColumna) {
        try {

            // Establecer cuantas columnas deseamos obtener en esta consulta
            // actua como un delimitador del total de columnas a retornar
            SliceRange sliceRange = new SliceRange();

            // ejecutado de esta forma retornara todas las columnas de una
            // fila. Si se desea establecer el rango de columnas, deben proveerse
            // los nombres de las columnas que determinan el inicio y fin del rango, ejemplo:
            // sliceRange.setStart("estatus".getBytes());
            // sliceRange.setFinish("id_problema".getBytes());

            sliceRange.setStart("1".getBytes());
            sliceRange.setFinish("".getBytes());

            SlicePredicate predicate = new SlicePredicate();
            predicate.setSlice_range(sliceRange);

            // Establecer cuantas "filas" deseamos obtener en esta consulta
            KeyRange keyrRange = new KeyRange();

            // ejecutado de esta forma se obtienen todas las filas 
            // registradas en la familia, sin embargo si queremos obtener 
            // una familia en particular solo debemos proveer en ambos
            // valores el RowKey especifico que deseamos obtener, Ejemplo:
            // keyrRange.setStart_key("1816".getBytes());
            // keyrRange.setEnd_key("1816".getBytes());            
            keyrRange.setStart_key("1".getBytes());
            keyrRange.setEnd_key("".getBytes());

            // Este valor permite establecer cuantas filas se retornaran en
            // la consulta ejecutada.
            keyrRange.setCount(150);

            ColumnParent parent = new ColumnParent(nombreColeccionColumna);

            // pensemos en los KeySlice como en las filas obtenidas
            List<KeySlice> rowItemsCassandra =
                    client.get_range_slices(parent, predicate, keyrRange, ConsistencyLevel.ONE);

            Object[][] results = new Object[rowItemsCassandra.size()][];

            int fila = 0;

            for (KeySlice row : rowItemsCassandra) {

                Object[] valoresEnColumnas = new Object[row.columns.size()];

                int columna = 0;

                // Por cada fila obtenida, es necesario iterar sobre sus columnas
                for (ColumnOrSuperColumn result : row.columns) {

                    Column column = result.column;

                    // Transformar el arreglo de bytes que representa el nombre/valor de cada columna
                    valoresEnColumnas[columna++] = new String(column.getName()) + " = " + new String(column.getValue());
                }
                results[fila++] = valoresEnColumnas;
            }

            return results;

        } catch (InvalidRequestException ex) {

            throw new DataAccessException("La consulta realizada no es valida: "
                    + ex.getMessage(), ex);

        } catch (UnavailableException ex) {

            throw new DataAccessException("La Consulta no puede "
                    + "ser ejecutada, verifique la consistencia del KeySpace usado", ex);

        } catch (TimedOutException ex) {

            throw new DataAccessException("Ocurrio un error de timeout de conexion "
                    + "con el servicio de Cassandra", ex);

        } catch (TException ex) {

            throw new DataAccessException("Ocurrio un error de interaccion "
                    + "con el servicio de Cassandra", ex);
        }
    }

    /**
     * @see DataAccessProvider#registrarDocumento(java.util.Map,
     * java.lang.String)
     */
    public void registrarDocumento(Map<String, Object> items, String nombreColeccionColumna) {

        //construir la referencia a la Familia de Columna donde se registraran las nuevas columnas
        ColumnParent columnaPadre = new ColumnParent(nombreColeccionColumna);

        // crear un RowKey en funcion del tiempo milisegundos, sugerencia:
        // segun la complejidad de la aplicacion crear un RowKey bajo 
        // otra estrategia
        ByteBuffer wrap = ByteBuffer.wrap(String.valueOf(System.currentTimeMillis()).getBytes());

        for (String nombreColumna : items.keySet()) {

            try {
                // Construir la nueva columna en funcion de la tripleta: nombre/valor/timestamp
                Column columnaId = new Column(ByteBuffer.wrap(nombreColumna.getBytes()));
                columnaId.setValue(items.get(nombreColumna).toString().getBytes());
                columnaId.setTimestamp(System.currentTimeMillis());

                client.insert(wrap, columnaPadre, columnaId, ConsistencyLevel.ONE);

            } catch (InvalidRequestException ex) {

                throw new DataAccessException("La consulta realizada no es valida: "
                        + ex.getMessage(), ex);

            } catch (UnavailableException ex) {

                throw new DataAccessException("La Consulta no puede "
                        + "ser ejecutada, verifique la consistencia del KeySpace usado", ex);

            } catch (TimedOutException ex) {

                throw new DataAccessException("Ocurrio un error de timeout de conexion "
                        + "con el servicio de Cassandra", ex);

            } catch (TException ex) {

                throw new DataAccessException("Ocurrio un error de interaccion "
                        + "con el servicio de Cassandra", ex);
            }
        }
    }

    public void closeConnection() {
        conexionCassandraServer.close();
    }
}