package modelo;

import clases.Caballo;
import clases.Usuario;
import java.util.List;

/**
 *
 * @author xDoble_Jx
 */
public interface DAO {

    //*************** INSERTS ***************/
    public void registrarUsuario(Usuario usu);

    //*************** SELECTS ***************/
    public String generarIdUsuario();

    public Usuario iniciarSesion(String usuario, String contrasenia);

    public List<Caballo> listarCaballos();

    //*************** UPDATES ***************/
    public void actualizarSaldo(String id_usuario, Float saldo);
    //*************** DELETES ***************/
}
