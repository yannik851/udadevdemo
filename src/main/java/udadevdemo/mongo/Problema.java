/*
 * Created on @Oct 31, 2012
 * Copyright - Confidential use
 */
package udadevdemo.mongo;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Problema
 *
 */
public class Problema implements Serializable {

    private Integer id;

    private TipoProblema tipoProblema;

    private Double coordenadaX;

    private Double coordenadaY;

    private String estatus;

    private Date fechaDeRegistro;

    public Problema() {
    }

    public Problema(Integer id, TipoProblema tipoProblema,
            Double coordenadaX, Double coordenadaY,
            String estatus, Date fechaDeRegistro) {

        this.id = id;
        this.tipoProblema = tipoProblema;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.estatus = estatus;
        this.fechaDeRegistro = fechaDeRegistro;
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
     * @return the tipoProblema
     */
    public TipoProblema getTipoProblema() {
        return tipoProblema;
    }

    /**
     * @param tipoProblema the tipoProblema to set
     */
    public void setTipoProblema(TipoProblema tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    /**
     * @return the coordenadaX
     */
    public Double getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * @param coordenadaX the coordenadaX to set
     */
    public void setCoordenadaX(Double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * @return the coordenadaY
     */
    public Double getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * @param coordenadaY the coordenadaY to set
     */
    public void setCoordenadaY(Double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the fechaDeRegistro
     */
    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    /**
     * @param fechaDeRegistro the fechaDeRegistro to set
     */
    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    //--------------------------------------------------------------------------
    // Sobreescritura de metodos de la clase Object
    //--------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Problema)) {
            return false;
        }

        Problema other = (Problema) o;

        return this.getId().equals(other.getId());
    }

    @Override
    public String toString() {
        return getClass().getName().concat("[id=" + getId()
                + ", tipoProblema=" + getTipoProblema() + ""
                + ", fechaDeRegistro= " + getFechaDeRegistro()
                + ", coordenadaX= " + getCoordenadaX()
                + ", coordenadaY= " + getCoordenadaY()
                + ", estatus= " + getEstatus()
                + "]");
    }
}
