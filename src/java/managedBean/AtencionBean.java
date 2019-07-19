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
    
    final private Mascota mascotaId;
    final private Cliente clienteId;
    final private Personal personalId;
    final private Tipoatencion tipoatencionId;

    private boolean banderaSelected = false;

    Date date = new Date();

    public AtencionBean() {
        //this.atencion = new Atencion();
        listaClientes = new ArrayList();
        listamascotas = new ArrayList();
        listapersonal = new ArrayList();
        listatipoatencion = new ArrayList();

        atencion = new Atencion();
        mascotaId = new Mascota();
        clienteId = new Cliente();
        personalId = new Personal();
        tipoatencionId = new Tipoatencion();

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
        /*try {
            //if(idMascota != 0 && idCliente != 0 && idPersonal != 0 && idTipoAtencion != 0){
            AtencionDao atenciondao = new AtencionDao();
            personal.setIdpersonal(idPersonal);
            cliente.setIdCliente(idCliente);
            mascota.setIdMascota(idMascota);
            tipoatencion.setIdTipoAtencion(idTipoAtencion);

            atencion.setPersonal(personal);
            atencion.setCliente(cliente);
            atencion.setMascota(mascota);
            atencion.setTipoatencion(tipoatencion);
            try {
                DateFormat format = new SimpleDateFormat("HH:mm:ss");
                String hora = format.format(date);
                Date convert = format.parse(hora);
                System.out.println("Convertido fecha " + convert);
                atencion.setHoraAtencion(convert);
            } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
            }
            boolean respuesta = atenciondao.guardarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
            }
            System.out.println("Error");
            /*}else{
                System.out.println("Error grave");
            }*/
        /*} catch (Exception e) {
            System.out.println("Error::: NO SE GUARDO: " + e.getMessage());
        }*/
        return "/IAtencion";
    }

    public String saveAtencion() {
        try {
            AtencionDao atenciondao = new AtencionDao();
            personalId.setIdpersonal(idPersonal);
            clienteId.setIdCliente(idCliente);
            mascotaId.setIdMascota(idMascota);
            tipoatencionId.setIdTipoAtencion(idTipoAtencion);

            atencion.setPersonal(personalId);
            atencion.setCliente(clienteId);
            atencion.setMascota(mascotaId);
            atencion.setTipoatencion(tipoatencionId);

            DateFormat format = new SimpleDateFormat("HH:mm:ss");
            String hora = format.format(date);
            Date convert = format.parse(hora);
            System.out.println("Convertido fecha " + convert);
            atencion.setHoraAtencion(convert);

            boolean respuesta = atenciondao.guardarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo registrar"));
            }
        } catch (ParseException e) {
            System.out.println("Error al insertar xd: " + e.getMessage());
        }
        return "/IAtencion";
    }

    public String actualizarAtencion() {
        try {
            AtencionDao atenciondao = new AtencionDao();
            boolean respuesta = atenciondao.actualizarAtencion(atencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se pudo Actualizar"));
            }
        } catch (HibernateException e) {
            System.out.println("Error:: " + e.getMessage());
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
        return "/IAtencion";
    }

    public void selectBandera() {
        banderaSelected = true;
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

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }

    
}
