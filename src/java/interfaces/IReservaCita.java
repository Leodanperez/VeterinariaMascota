
package interfaces;

import entidades.Reservacita;
import java.util.ArrayList;

/**
 *
 * @author LEO
 */
public interface IReservaCita {
    public abstract boolean guardarReserva(Reservacita reservacita);

    public abstract ArrayList<Reservacita> listarReservas();

    public abstract boolean actualizarReserva(Reservacita reservacita);

    public abstract boolean eliminarReserva(Reservacita reservacita);
}
