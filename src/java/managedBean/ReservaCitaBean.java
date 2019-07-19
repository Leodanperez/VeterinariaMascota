package managedBean;

import dao.ClienteDao;
import dao.ReservarCitaDao;
import dao.TipoReservaDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Reservacita;
import entidades.Tiporeserva;
import entidades.Usuario;
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
public class ReservaCitaBean {

    private ArrayList listatiporeserva;
    private ArrayList listcliente;
    private ArrayList listusuario;

    private Reservacita reservacita;

    private int idTipreserva;
    private int idCliente;
    private int idUsuario;

    final private Cliente clienteId;
    final private Tiporeserva tiporeservaId;
    final private Usuario usuarioId;

    private boolean banderaSelected = false;

    public ReservaCitaBean() {
        listatiporeserva = new ArrayList();
        listcliente = new ArrayList();
        listusuario = new ArrayList();

        reservacita = new Reservacita();
        clienteId = new Cliente();
        tiporeservaId = new Tiporeserva();
        usuarioId = new Usuario();

        listarCombos();
    }

    public void listarCombos() {
        TipoReservaDao tipresrevadao = new TipoReservaDao();
        ClienteDao clientdao = new ClienteDao();
        UsuarioDao userdao = new UsuarioDao();

        listatiporeserva = tipresrevadao.listarTiporeserva();
        listcliente = clientdao.listarCliente();
        listusuario = userdao.listarUsuarios();
    }

    public String guardarReservacita() {
        try {
            ReservarCitaDao recervdao = new ReservarCitaDao();
            clienteId.setIdCliente(idCliente);
            tiporeservaId.setIdTipoReserva(idTipreserva);
            usuarioId.setIdUsuario(idUsuario);

            reservacita.setCliente(clienteId);
            reservacita.setTiporeserva(tiporeservaId);
            reservacita.setUsuario(usuarioId);

            boolean respuest = recervdao.guardarReserva(reservacita);
            if (respuest) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (Exception e) {
            System.out.println("Error:: "+e.getMessage());
        }

        return "/IReservaCita";
    }

    public ArrayList<Reservacita> listarReservacita() {
        ArrayList<Reservacita> lista = new ArrayList<>();
        ReservarCitaDao recervdao = new ReservarCitaDao();
        lista = recervdao.listarReservas();
        return lista;
    }

    public String actualizarReservacita() {
        try {
            ReservarCitaDao recervdao = new ReservarCitaDao();
            boolean respuesta = recervdao.actualizarReserva(reservacita);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/IReservaCita";
    }

    public String eliminar() {
        ReservarCitaDao recervdao = new ReservarCitaDao();
        boolean respuesta = recervdao.eliminarReserva(reservacita);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/IReservaCita";
    }

    public String limpiar() {
        return "/IReservaCita";
    }

    public void selectBandera() {
        banderaSelected = true;
    }

    public ArrayList getListatiporeserva() {
        return listatiporeserva;
    }

    public void setListatiporeserva(ArrayList listatiporeserva) {
        this.listatiporeserva = listatiporeserva;
    }

    public ArrayList getListcliente() {
        return listcliente;
    }

    public void setListcliente(ArrayList listcliente) {
        this.listcliente = listcliente;
    }

    public ArrayList getListusuario() {
        return listusuario;
    }

    public void setListusuario(ArrayList listusuario) {
        this.listusuario = listusuario;
    }

    public Reservacita getReservacita() {
        return reservacita;
    }

    public void setReservacita(Reservacita reservacita) {
        this.reservacita = reservacita;
    }

    public int getIdTipreserva() {
        return idTipreserva;
    }

    public void setIdTipreserva(int idTipreserva) {
        this.idTipreserva = idTipreserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }

}
