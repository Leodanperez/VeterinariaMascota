package entidades;
// Generated 18/07/2019 07:38:06 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private Integer idCliente;
     private String nombre;
     private String apellido;
     private Date fechaNac;
     private String direccion;
     private String telefono;
     private String email;
     private Set usuarios = new HashSet(0);
     private Set reservacitas = new HashSet(0);
     private Set clienteHasMascotas = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(String nombre, String apellido, Date fechaNac, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    public Cliente(String nombre, String apellido, Date fechaNac, String direccion, String telefono, String email, Set usuarios, Set reservacitas, Set clienteHasMascotas) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaNac = fechaNac;
       this.direccion = direccion;
       this.telefono = telefono;
       this.email = email;
       this.usuarios = usuarios;
       this.reservacitas = reservacitas;
       this.clienteHasMascotas = clienteHasMascotas;
    }
   
    public Integer getIdCliente() {
        return this.idCliente;
    }
    
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFechaNac() {
        return this.fechaNac;
    }
    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getReservacitas() {
        return this.reservacitas;
    }
    
    public void setReservacitas(Set reservacitas) {
        this.reservacitas = reservacitas;
    }
    public Set getClienteHasMascotas() {
        return this.clienteHasMascotas;
    }
    
    public void setClienteHasMascotas(Set clienteHasMascotas) {
        this.clienteHasMascotas = clienteHasMascotas;
    }




}


