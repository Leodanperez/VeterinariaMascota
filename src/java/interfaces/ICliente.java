/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Computer
 */
public interface ICliente {

    public abstract boolean guardarCliente(Cliente cliente);

    public abstract ArrayList<Cliente> listarCliente();

    public abstract boolean actualizarCliente(Cliente cliente);

    public abstract boolean eliminarCliente(Cliente cliente);
}
