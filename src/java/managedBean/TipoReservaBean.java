
package managedBean;

import dao.TipoReservaDao;
import entidades.Tiporeserva;
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
public class TipoReservaBean implements Serializable{
    private Tiporeserva tiporeserva;
    private boolean banderaSelect = false;

    public TipoReservaBean() {
        this.tiporeserva = new Tiporeserva();
    }
    
    public String guardarTipoReserva() {
        try {

            TipoReservaDao reservadao = new TipoReservaDao();
            boolean respuesta = reservadao.guardarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/ITipoReserva";
    }
    
    public String actualizarTipoReserva() {
        try {
            TipoReservaDao reservadao = new TipoReservaDao();
            boolean respuesta = reservadao.actualizarTiporeserva(tiporeserva);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/ITipoReserva";

    }

    public ArrayList<Tiporeserva> listarTipoReserva() {
        ArrayList<Tiporeserva> lista = new ArrayList<>();
        TipoReservaDao reservadao = new TipoReservaDao();
        lista = reservadao.listarTiporeserva();
        return lista;
    }

    public String eliminar() {
        TipoReservaDao reservadao = new TipoReservaDao();
        boolean respuesta = reservadao.eliminarTiporeserva(tiporeserva);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/ITipoReserva";
    }

    public String limpiar() {
        return "/ITipoReserva";
    }

    public Tiporeserva getTiporeserva() {
        return tiporeserva;
    }

    public void setTiporeserva(Tiporeserva tiporeserva) {
        this.tiporeserva = tiporeserva;
    }
    
    public void selectBandera() {
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
}
