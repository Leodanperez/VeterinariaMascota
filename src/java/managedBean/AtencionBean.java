package managedBean;

import dao.AtencionDao;
import dao.ClienteDao;
import dao.MascotaDao;
import dao.PersonalDao;
import dao.TipoAtencionDao;
import entidades.Atencion;
import entidades.Cliente;
import entidades.ClienteHasMascota;
import entidades.ClienteHasMascotaId;
import entidades.Mascota;
import entidades.Personal;
import entidades.Tipoatencion;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AtencionBean implements Serializable {

    private ArrayList listaClientes;
    private ArrayList listamascotas;
    private ArrayList listapersonal;
    private ArrayList listatipoatencion;
    
    private int idCliente;
    private int idMascota;
    private int idPersonal;
    private int idTipoAtencion;
    
    private Atencion atencion;
    private Mascota mascota;
    private Cliente cliente;
    private Personal personal;
    private Tipoatencion tipoatencion;
    
    private ClienteHasMascota mascotaPorcliente;
    private ClienteHasMascotaId mascotaporClienteId;
    
    private boolean banderaSelected = false;
    
    private Date date = new Date();

    //final private Personal personalId;
    //final private Tipoatencion tipoatencionId;

    public AtencionBean() {
        this.atencion = new Atencion();
        listaClientes = new ArrayList();
        listamascotas = new ArrayList();
        listapersonal = new ArrayList();
        listatipoatencion = new ArrayList();

        mascota = new Mascota();
        cliente = new Cliente();
        personal = new Personal();
        tipoatencion = new Tipoatencion();
        //mascotaporClienteId = new ClienteHasMascotaId();

        listarCombos();

    }

    public void listarCombos() {
        MascotaDao masctdao = new MascotaDao();
        ClienteDao clientedao = new ClienteDao();
        PersonalDao personadao = new PersonalDao();
        TipoAtencionDao tipoatedao = new TipoAtencionDao();

        listaClientes = clientedao.listarCliente();
        listamascotas = masctdao.listarMascotas();
        listapersonal = personadao.listarPersonal();
        listatipoatencion = tipoatedao.listarTipoAtencion();
    }

    public String guardarAtencion() {
        try {
            if(idMascota != 0 && idCliente != 0 && idPersonal != 0 && idTipoAtencion != 0){
                AtencionDao atenciondao = new AtencionDao();
                mascotaporClienteId.setMascotaIdMascota(idMascota);
                mascotaporClienteId.setClienteIdCliente(idCliente);
                mascotaPorcliente.setId(mascotaporClienteId);
                System.out.println("trae los dos id "+idMascota + "++" + idCliente);
                System.out.println("setId" + mascotaporClienteId);
                personal.setIdpersonal(idPersonal);
                tipoatencion.setIdTipoAtencion(idTipoAtencion);
                
                atencion.setClienteHasMascota(mascotaPorcliente);
                atencion.setPersonal(personal);
                atencion.setTipoatencion(tipoatencion);
                
                try {
                    DateFormat format = new SimpleDateFormat("HH:mm:ss");
                    String hora = format.format(date);
                    Date convert = format.parse(hora);
                    System.out.println("Convertido fecha "+convert);
                    atencion.setHoraAtencion(convert);
                } catch (ParseException e) {
                    System.out.println("Error: "+e.getMessage());
                }
                boolean respuesta = atenciondao.guardarAtencion(atencion);
                if (respuesta) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
                }
            }else{
                System.out.println("Error grave");
            }
        } catch (Exception e) {
            System.out.println("Error::: NO SE GUARDO: "+e.getMessage());
        }
        return "/IAtencion";
    }
    
    public String actualizarAtencion(){
        try {
            AtencionDao atenciondao = new AtencionDao();
            boolean respuesta = atenciondao.actualizarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Actualizo correctamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Actualizar"));
            }
        } catch (HibernateException e) {
            System.out.println("Error:: "+e.getMessage());
        }
        return "/IAtencion";
    }
    
    public ArrayList<Atencion> listarAtencion() {
        ArrayList<Atencion> lista = new ArrayList<>();
        AtencionDao atencionDao = new AtencionDao();
        lista = atencionDao.listarAtencions();
        return lista;
    }
    
    public String eliminar() {
        AtencionDao atencionDao = new AtencionDao();
        boolean respuesta = atencionDao.eliminarAtencion(atencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/IAtencion";
    }
    
    public String limpiar() {
        return "/Atencion";
    }

    public void selectBandera() {
        banderaSelected = true;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList getListamascotas() {
        return listamascotas;
    }

    public void setListamascotas(ArrayList listamascotas) {
        this.listamascotas = listamascotas;
    }

    public ArrayList getListapersonal() {
        return listapersonal;
    }

    public void setListapersonal(ArrayList listapersonal) {
        this.listapersonal = listapersonal;
    }

    public ArrayList getListatipoatencion() {
        return listatipoatencion;
    }

    public void setListatipoatencion(ArrayList listatipoatencion) {
        this.listatipoatencion = listatipoatencion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdTipoAtencion() {
        return idTipoAtencion;
    }

    public void setIdTipoAtencion(int idTipoAtencion) {
        this.idTipoAtencion = idTipoAtencion;
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public ClienteHasMascota getMascotaPorcliente() {
        return mascotaPorcliente;
    }

    public void setMascotaPorcliente(ClienteHasMascota mascotaPorcliente) {
        this.mascotaPorcliente = mascotaPorcliente;
    }

    public ClienteHasMascotaId getMascotaporClienteId() {
        return mascotaporClienteId;
    }

    public void setMascotaporClienteId(ClienteHasMascotaId mascotaporClienteId) {
        this.mascotaporClienteId = mascotaporClienteId;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }
    
    
}
