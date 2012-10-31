/*
 * Created on @Oct 31, 2012
 * Copyright - Confidential use
 */
package udadevdemo.mongo;

import java.io.Serializable;

/**
 * Class TipoProblema
 * 
 */
public class TipoProblema implements Serializable {

    private Integer id;
    
    private String nombre;

    public TipoProblema() {
    }

    public TipoProblema(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
    //--------------------------------------------------------------------------
    // Sobreescritura de metodos de la clase Object
    //--------------------------------------------------------------------------
    
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof TipoProblema)) {
            return false;
        }
        
        TipoProblema other = (TipoProblema) o;
        
        return this.getId().equals(other.getId());
    }
    
    @Override
    public String toString() {
        return getClass().getName().concat("[id=" + getId() + ", nombre=" + getNombre() + "]");
    }
}
