
package interfaces;

import entidades.ClienteHasMascota;
import java.util.ArrayList;

/**
 *
 * @author Computer
 */
public interface IMascotaPorCliente{

    public abstract boolean guardarMascotaPorCliente(ClienteHasMascota mascotaPorCliente);

    public abstract ArrayList<ClienteHasMascota> listarMascotaPorClientes();

    public abstract boolean actualizarMascotaPorCliente(ClienteHasMascota mascotaPorCliente);

    public abstract boolean eliminarMascotaPorCliente(ClienteHasMascota mascotaPorCliente);

}
