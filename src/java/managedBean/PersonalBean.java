
package managedBean;

import dao.PersonalDao;
import entidades.Personal;
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
public class PersonalBean implements Serializable{
    
    private Personal personal;
    private boolean banderaSelect = false;

    public PersonalBean() {
        this.personal = new Personal();
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String guardarPersonal() {
        try {

            PersonalDao personalDao = new PersonalDao();
            boolean respuesta = personalDao.guardarPersonal(personal);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se registro correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo registrar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/IPersonal";
    }

    public String actualizarPersonal() {
        try {
            PersonalDao personalDao = new PersonalDao();
            boolean respuesta = personalDao.actualizarPersonal(personal);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo actualizar"));
            }
        } catch (HibernateException e) {
            ///transation.rollback();  -- regresa a la anterior
            System.out.println("Error::: " + e);
        }
        return "/IPersonal";

    }

    public ArrayList<Personal> listarPersonals() {
        ArrayList<Personal> lista = new ArrayList<>();
        PersonalDao personalDao = new PersonalDao();
        lista = personalDao.listarPersonal();
        return lista;
    }

    public String eliminar() {
        PersonalDao personalDao = new PersonalDao();
        boolean respuesta = personalDao.eliminarPersonal(personal);
        if (respuesta) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se elimino correctamente"));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puedo eliminar"));
        }
        return "/IPersonal";
    }
    
    public String limpiar() {
        return "/IPersonal";
    }
    
    public void selectBandera(){
        banderaSelect = true;
    }

    public boolean isBanderaSelect() {
        return banderaSelect;
    }

    public void setBanderaSelect(boolean banderaSelect) {
        this.banderaSelect = banderaSelect;
    }
    
}
