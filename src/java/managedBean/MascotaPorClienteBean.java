package managedBean;

import dao.ClienteDao;
import dao.MascotaDao;
import dao.MascotaPorClienteDao;
import entidades.ClienteHasMascota;
import entidades.ClienteHasMascotaId;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.HibernateException;

/**
 *
 * @author LEO
 */
@ManagedBean
@ViewScoped
public class MascotaPorClienteBean implements Serializable {

    private ArrayList listaclientes;
    private ArrayList listamascotas;
    private ClienteHasMascota mascotaPorCliente;

    private int idCliente;
    private int idMascota;

    final private ClienteHasMascotaId mascotaporClienteId;

    public MascotaPorClienteBean() {
        listaclientes = new ArrayList();
        mascotaPorCliente = new ClienteHasMascota();
        mascotaporClienteId = new ClienteHasMascotaId();
        listarCombos();
    }

    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        MascotaDao mascotadao = new MascotaDao();

        listaclientes = clientedao.listarCliente();
        listamascotas = mascotadao.listarMascotas();
    }

    public String guardarMascotaxCliente() {
        MascotaPorClienteDao mascotaDao = new MascotaPorClienteDao();
        mascotaporClienteId.setClienteIdCliente(idCliente);
        mascotaporClienteId.setMascotaIdMascota(idMascota);
        
        mascotaPorCliente.setId(mascotaporClienteId);
        mascotaDao.guardarMascotaPorCliente(mascotaPorCliente);

        return "/RegistrarMascotaPorCliente";
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

    public ClienteHasMascota getMascotaPorCliente() {
        return mascotaPorCliente;
    }

    public void setMascotaPorCliente(ClienteHasMascota mascotaPorCliente) {
        this.mascotaPorCliente = mascotaPorCliente;
    }
}
