
package interfaces;

import entidades.Tipoatencion;
import java.util.ArrayList;

/**
 *
 * @author LEO
 */
public interface ITipoAtencion {
    public abstract boolean guardarTipAtencion(Tipoatencion tipoaten);

    public abstract ArrayList<Tipoatencion> listarTipoAtencion();

    public abstract boolean actualizarTipAtencion(Tipoatencion tipoaten);

    public abstract boolean eliminarTipAtencion(Tipoatencion tipoaten);
}
