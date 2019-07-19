package managedBean;

import dao.ClienteDao;
import dao.PersonalDao;
import dao.UsuarioDao;
import entidades.Cliente;
import entidades.Personal;
import entidades.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author LEO
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    private ArrayList listaclientes;
    private ArrayList listpersonal;
    private Usuario usuario;

    private int idCliente;
    private int idPersonal;

    final private Cliente clienteId;
    final private Personal personalId;
    
    private boolean banderaSelected = false;

    public UsuarioBean() {
        this.usuario = new Usuario();
        listaclientes = new ArrayList();
        listpersonal = new ArrayList();

        usuario = new Usuario();
        clienteId = new Cliente();
        personalId = new Personal();

        listarCombos();
    }

    public void listarCombos() {
        ClienteDao clientedao = new ClienteDao();
        PersonalDao personaldao = new PersonalDao();

        listaclientes = clientedao.listarCliente();
        listpersonal = personaldao.listarPersonal();
    }

    public String guardarUsuario() {
        try {
            UsuarioDao usuariodao = new UsuarioDao();
            clienteId.setIdCliente(idCliente);
            personalId.setIdpersonal(idPersonal);
            usuario.setPersonal(personalId);
            usuario.setCliente(clienteId);
            boolean respuest = usuariodao.guardarUsuario(usuario);
            if (respuest) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (Exception e) {
            System.out.println("Error:: "+e.getMessage());
        }

        return "/RegistroUsuario";
    }
    
    public String actualizarUsuario(){
        try {
            UsuarioDao usuariodao = new UsuarioDao();
            boolean respuesta = usuariodao.actualizarUsuario(usuario);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (Exception e) {
            System.out.println("Error:: actualizar "+e.getMessage());
        }
        return "/RegistroUsuario";
    }

    public ArrayList<Usuario> listarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<>();
        UsuarioDao usuariodao = new UsuarioDao();
        lista = usuariodao.listarUsuarios();
        return lista;
    }
    
    public String eliminar() {
        UsuarioDao usuariodao = new UsuarioDao();
        boolean respuesta = usuariodao.eliminarUsuario(usuario);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/RegistroUsuario";
    }

    public String limpiar() {
        return "/RegistroUsuario";
    }

    public void selectBandera() {
        banderaSelected = true;
    }

    public ArrayList getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList listaclientes) {
        this.listaclientes = listaclientes;
    }

    public ArrayList getListpersonal() {
        return listpersonal;
    }

    public void setListpersonal(ArrayList listpersonal) {
        this.listpersonal = listpersonal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }

}
