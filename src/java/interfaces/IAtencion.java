
package interfaces;

import entidades.Atencion;
import java.util.ArrayList;

/**
 *
 * @author LEO
 */
public interface IAtencion {
    public abstract boolean guardarAtencion(Atencion atencion);

    public abstract ArrayList<Atencion> listarAtencions();

    public abstract boolean actualizarAtencion(Atencion atencion);

    public abstract boolean eliminarAtencion(Atencion atencion);
}
