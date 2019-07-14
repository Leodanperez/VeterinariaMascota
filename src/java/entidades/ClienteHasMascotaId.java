package entidades;
// Generated 13/07/2019 10:24:01 PM by Hibernate Tools 4.3.1



/**
 * ClienteHasMascotaId generated by hbm2java
 */
public class ClienteHasMascotaId  implements java.io.Serializable {


     private int clienteIdCliente;
     private int mascotaIdMascota;

    public ClienteHasMascotaId() {
    }

    public ClienteHasMascotaId(int clienteIdCliente, int mascotaIdMascota) {
       this.clienteIdCliente = clienteIdCliente;
       this.mascotaIdMascota = mascotaIdMascota;
    }
   
    public int getClienteIdCliente() {
        return this.clienteIdCliente;
    }
    
    public void setClienteIdCliente(int clienteIdCliente) {
        this.clienteIdCliente = clienteIdCliente;
    }
    public int getMascotaIdMascota() {
        return this.mascotaIdMascota;
    }
    
    public void setMascotaIdMascota(int mascotaIdMascota) {
        this.mascotaIdMascota = mascotaIdMascota;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ClienteHasMascotaId) ) return false;
		 ClienteHasMascotaId castOther = ( ClienteHasMascotaId ) other; 
         
		 return (this.getClienteIdCliente()==castOther.getClienteIdCliente())
 && (this.getMascotaIdMascota()==castOther.getMascotaIdMascota());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getClienteIdCliente();
         result = 37 * result + this.getMascotaIdMascota();
         return result;
   }   


}


