
package interfaces;

import entidades.Tiporeserva;
import java.util.ArrayList;

/**
 *
 * @author LEO
 */
public interface ITipoReserva {
    public abstract boolean guardarTiporeserva(Tiporeserva tiporeserva);

    public abstract ArrayList<Tiporeserva> listarTiporeserva();

    public abstract boolean actualizarTiporeserva(Tiporeserva tiporeserva);

    public abstract boolean eliminarTiporeserva(Tiporeserva tiporeserva);
}
