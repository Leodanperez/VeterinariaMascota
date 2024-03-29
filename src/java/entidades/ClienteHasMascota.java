package entidades;
// Generated 19/07/2019 12:56:32 AM by Hibernate Tools 4.3.1



/**
 * ClienteHasMascota generated by hbm2java
 */
public class ClienteHasMascota  implements java.io.Serializable {


     private ClienteHasMascotaId id;
     private Cliente cliente;
     private Mascota mascota;
     private Character estado;

    public ClienteHasMascota() {
    }

	
    public ClienteHasMascota(ClienteHasMascotaId id, Cliente cliente, Mascota mascota) {
        this.id = id;
        this.cliente = cliente;
        this.mascota = mascota;
    }
    public ClienteHasMascota(ClienteHasMascotaId id, Cliente cliente, Mascota mascota, Character estado) {
       this.id = id;
       this.cliente = cliente;
       this.mascota = mascota;
       this.estado = estado;
    }
   
    public ClienteHasMascotaId getId() {
        return this.id;
    }
    
    public void setId(ClienteHasMascotaId id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Mascota getMascota() {
        return this.mascota;
    }
    
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public Character getEstado() {
        return this.estado;
    }
    
    public void setEstado(Character estado) {
        this.estado = estado;
    }




}


