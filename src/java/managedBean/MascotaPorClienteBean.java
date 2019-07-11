
package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author LEO
 */
@ManagedBean
@ViewScoped
public class MascotaPorClienteBean {

    private ArrayList listaclientes;
    private ArrayList listamascotas;
    
    private int idCliente;
    private int idMascota;

    public MascotaPorClienteBean() {
        listaclientes = new ArrayList();
        listarCombos();
    }
    
    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        MascotaDao mascotadao = new MascotaDao();
        
        listaclientes = clientedao.listarCliente();     
        listamascotas = mascotadao.listarMascotas();
    }
    

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
    
}
