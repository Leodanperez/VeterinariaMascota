
package managedBean;

import dao.SexoDao;
import entidades.Sexo;
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
public class SexoBean implements Serializable{

    private Sexo sexo;
    private boolean banderaSelected = false;
    
    public SexoBean() {
        this.sexo = new Sexo();
    }
    
    public String guardarSexo(){
        try {
            SexoDao dao = new SexoDao();
            boolean respuesta = dao.guardarSexo(sexo);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Registro Correctamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Registrar"));
            }
        } catch (HibernateException e) {
            System.out.println("Error al insertar "+e.getMessage());
        }
        return "/ISexo";
    }
    
    public String actualizarSexo(){
        try {
            SexoDao dao = new SexoDao();
            boolean respuesta = dao.actualizarSexo(sexo);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Actualizo Correctamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Actualizar"));
            }
        } catch (HibernateException e) {
            System.out.println("Error al actualizar: "+e.getMessage());
        }
        return "/ISexo";
    }
    
    public ArrayList<Sexo> listarSexo(){
        ArrayList<Sexo>list = new ArrayList<>();
        SexoDao dao = new SexoDao();
        list = dao.listarSexo();
        return list;
    }
    
    public String eliminarSexo(){
        try {
            SexoDao dao = new SexoDao();
            boolean respuesta = dao.eliminarSexo(sexo);
            if (respuesta) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se Elimino Correctamente"));
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error al Eliminar"));
            }
        } catch (HibernateException e) {
            System.out.println("Error al eliminar: "+e.getMessage());
        }
        return "/ISexo";
    }
    
    public String limpiar(){
        return "/ISexo";
    }
    
    public void selectedBandera(){
        banderaSelected = true;
    }

    public boolean isBanderaSelected() {
        return banderaSelected;
    }

    public void setBanderaSelected(boolean banderaSelected) {
        this.banderaSelected = banderaSelected;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
