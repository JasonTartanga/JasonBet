package modelo;

import clases.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xDoble_Jx
 */
public class DAOImplementacion implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    //************** INSERTS***************/
    final private String REGISTRAR_USUARIO = "INSERT INTO USUARIO VALUES (?, ?, ?, ?, ?, ?, ?)";

    //************** SELECTS***************/
    //************** UPDATES***************/
    //************** DELETES***************/
    public void abrirConexion() {

        try {
            Properties configBDA = new Properties();
            String rutaProyecto = System.getProperty("user.dir");
            FileInputStream fis = new FileInputStream(rutaProyecto + "\\src\\modelo\\configBDA.properties");
            configBDA.load(fis);

            final String URL = configBDA.getProperty("url");
            final String USER = configBDA.getProperty("user");
            final String PASSWORD = configBDA.getProperty("password");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepararUsuario(Usuario usu) {
        try {
            stmt.setString(1, usu.getId_usuario());
            stmt.setString(2, usu.getNombre());
            stmt.setString(3, usu.getApellidos());
            stmt.setString(4, usu.getDni());
            stmt.setString(5, usu.getGmail());
            stmt.setDate(6, Date.valueOf(usu.getFecha_nac() + ""));
            stmt.setFloat(7, usu.getSaldo());
        } catch (SQLException ex) {
            Logger.getLogger(DAOImplementacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stmt;
    }

    @Override
    public void registrarUsuario(Usuario usu) {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(REGISTRAR_USUARIO);
            stmt = this.prepararUsuario(usu);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        cerrarConexion();
    }
}
