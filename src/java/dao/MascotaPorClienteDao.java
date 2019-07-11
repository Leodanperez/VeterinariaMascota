
package dao;

import entidades.ClienteHasMascota;
import interfaces.IMascotaPorCliente;
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
public class MascotaPorClienteDao implements IMascotaPorCliente {

    //funcion para guardar
    @Override
    public boolean guardarMascotaPorCliente(ClienteHasMascota mascotaPorCliente) {
        Session session = null;
        boolean respuesta = true;
        try {
            //construir una nueva session y transaccion
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction(); //inicia
            //registra en la base de datos
            session.save(mascotaPorCliente);
            transaccion.commit();
        } catch (HibernateException e) {
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

    //funcion para listar
    @Override
    public ArrayList<ClienteHasMascota> listarMascotaPorClientes() {
        Session session = null;
        ArrayList<ClienteHasMascota> lista = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            //consulta hacia la base de datos
            String hql = "FROM Mascota";
            Query query = session.createQuery(hql);
            //ejecuta la consulta y obtener la lista. array: castea
            lista = (ArrayList<ClienteHasMascota>) query.list();
        } catch (HibernateException e) {
            System.out.println("ERROR EN LISTAR::" + e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return lista;
    }

    @Override
    public boolean actualizarMascotaPorCliente(ClienteHasMascota mascotaPorCliente) {
        //System.out.println("erer" + mascotaPorCliente.getNameCliente());
        boolean resp = true;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaccion = session.beginTransaction();
            session.update(mascotaPorCliente);
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
    public boolean eliminarMascotaPorCliente(ClienteHasMascota mascotaPorCliente) {
        Session sesion = null;
        boolean resp = true;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(mascotaPorCliente);
            sesion.getTransaction().commit();
        } catch (HibernateException e) {
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
