package entidades;
// Generated 18/07/2019 07:38:06 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tiporeserva generated by hbm2java
 */
public class Tiporeserva  implements java.io.Serializable {


     private Integer idTipoReserva;
     private String descripcion;
     private Set reservacitas = new HashSet(0);

    public Tiporeserva() {
    }

    public Tiporeserva(String descripcion, Set reservacitas) {
       this.descripcion = descripcion;
       this.reservacitas = reservacitas;
    }
   
    public Integer getIdTipoReserva() {
        return this.idTipoReserva;
    }
    
    public void setIdTipoReserva(Integer idTipoReserva) {
        this.idTipoReserva = idTipoReserva;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getReservacitas() {
        return this.reservacitas;
    }
    
    public void setReservacitas(Set reservacitas) {
        this.reservacitas = reservacitas;
    }




}


