
package dao;

import entidades.Tipoatencion;
import interfaces.ITipoAtencion;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utilitarios.HibernateUtil;

/**
 *
 * @author LEO
 */
public class TipoAtencionDao implements ITipoAtencion{

    @Override
    public boolean guardarTipAtencion(Tipoatencion tipoaten) {
        Session session = null;
        boolean respuesta = true;
        try {
            //construir una nueva session y transaccion
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction(); //inicia
            //registra en la base de datos
            session.save(tipoaten);
            transaccion.commit();
        } catch (Exception e) {
            System.out.println("Error al guardar. " + e);
            respuesta = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        //session.close();
        return respuesta;
    }

    @Override
    public ArrayList<Tipoatencion> listarTipoAtencion() {
        Session session = null;
        ArrayList<Tipoatencion> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //consulta hacia la base de datos
            String hql = "FROM Tipoatencion";
            Query query = session.createQuery(hql);
            //ejecuta la consulta y obtener la lista. array: castea
            lista = (ArrayList<Tipoatencion>) query.list();
        } catch (Exception e) {
            System.out.println("ERROR EN LISTAR::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return lista;
    }

    @Override
    public boolean actualizarTipAtencion(Tipoatencion tipoaten) {
        System.out.println("erer" + tipoaten.getDescripcion());
        boolean resp = true;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction();
            session.update(tipoaten);
            transaccion.commit();
        } catch (HibernateException e) {
            resp = false;
            System.out.println("ERROR EN ACTU::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return resp;
    }

    @Override
    public boolean eliminarTipAtencion(Tipoatencion tipoaten) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(tipoaten);
            sesion.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("ERROR DAO::" + e);
            resp = false;
            sesion.getTransaction().rollback();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }

        return resp;
    }
    
}
