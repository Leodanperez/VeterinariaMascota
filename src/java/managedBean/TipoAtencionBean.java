
package managedBean;

import dao.TipoAtencionDao;
import dao.TipoAtencionDao;
import entidades.Tipoatencion;
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
public class TipoAtencionBean implements Serializable{
    private Tipoatencion tipoatencion;
    private boolean banderaSelect = false;
    
    public TipoAtencionBean() {
        this.tipoatencion = new Tipoatencion();
    }
    
    public String guardarTipoAtencion() {
        try {

            TipoAtencionDao atenciondao = new TipoAtencionDao();
            boolean respuesta = atenciondao.guardarTipAtencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/ITipoAtencion";
    }
    
    public String actualizarTipoAtencion() {
        try {
            TipoAtencionDao atenciondao = new TipoAtencionDao();
            boolean respuesta = atenciondao.actualizarTipAtencion(tipoatencion);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/ITipoAtencion";

    }

    public ArrayList<Tipoatencion> listarTipoAtencion() {
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        TipoAtencionDao atenciondao = new TipoAtencionDao();
        lista = atenciondao.listarTipoAtencion();
        return lista;
    }

    public String eliminar() {
        TipoAtencionDao atenciondao = new TipoAtencionDao();
        boolean respuesta = atenciondao.eliminarTipAtencion(tipoatencion);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/ITipoAtencion";
    }

    public String limpiar() {
        return "/ITipoAtencion";
    }
    
    public void selectBandera() {
        banderaSelect = true;
    }

    public Tipoatencion getTipoatencion() {
        return tipoatencion;
    }

    public void setTipoatencion(Tipoatencion tipoatencion) {
        this.tipoatencion = tipoatencion;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
    
}
