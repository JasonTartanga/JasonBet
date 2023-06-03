package modelo;

import clases.Caballo;
import clases.Tarjeta;
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
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xDoble_Jx
 */
public class DAOImplementacion implements DAO {

    private Connection con = null;
    private PreparedStatement stmt;

    //************** INSERTS***************/
    final private String REGISTRAR_USUARIO = "INSERT INTO Usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    //************** SELECTS***************/
    final private String GENERAR_ID_USUARIO = "SELECT id_usuario FROM Usuario ORDER BY id_usuario DESC LIMIT 1";
    final private String INICIAR_SESION = "SELECT * FROM Usuario WHERE nombre = ? and contrasenia = ?";

    final private String LISTAR_CABALLOS = "SELECT * FROM Caballo";

    final private String LISTAR_TARJETAS_USUARIO = "SELECT * FROM Tarjeta WHERE num_tarjeta in (SELECT num_tarjeta FROM MetodoPago WHERE id_usuario = ?)";

//************** UPDATES***************/
    final private String ACTUALIZAR_SALDO = "UPDATE Usuario SET saldo = saldo + ? WHERE id_usuario = ?";

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
            stmt.setString(3, usu.getContrasenia());
            stmt.setString(4, usu.getApellidos());
            stmt.setString(5, usu.getDni());
            stmt.setString(6, usu.getGmail());
            stmt.setDate(7, Date.valueOf(usu.getFecha_nac() + ""));
            stmt.setFloat(8, usu.getSaldo());
            stmt.setString(9, usu.getIcono());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public Usuario recuperarUsuario(ResultSet rs) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Usuario usu = new Usuario();

        try {
            usu.setId_usuario(rs.getString("id_usuario"));
            usu.setNombre(rs.getString("nombre"));
            usu.setContrasenia(rs.getString("contrasenia"));
            usu.setApellidos(rs.getString("apellidos"));
            usu.setDni(rs.getString("dni"));
            usu.setGmail(rs.getString("gmail"));
            usu.setFecha_nac(LocalDate.parse(rs.getDate("fecha_nac") + "", formateador));
            usu.setSaldo(rs.getFloat("saldo"));
            usu.setIcono(rs.getString("icono"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usu;
    }

    @Override
    public void registrarUsuario(Usuario usu) {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(REGISTRAR_USUARIO);
            stmt = this.prepararUsuario(usu);
            System.out.println(stmt);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        cerrarConexion();
    }

    @Override
    public String generarIdUsuario() {
        String id = "";
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(GENERAR_ID_USUARIO);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id = "U-" + String.format("%03d", Integer.parseInt(rs.getString("id_usuario").substring(2, 5)) + 1);
            } else {
                id = "U-001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cerrarConexion();
        return id;
    }

    @Override
    public Usuario iniciarSesion(String usuario, String contrasenia) {
        this.abrirConexion();
        Usuario usu = null;

        try {
            stmt = con.prepareStatement(INICIAR_SESION);
            stmt.setString(1, usuario);
            stmt.setString(2, contrasenia);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usu = new Usuario();
                usu = this.recuperarUsuario(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
        return usu;
    }

    @Override
    public List<Caballo> listarCaballos() {
        List<Caballo> caballos = new ArrayList<>();
        this.abrirConexion();
        try {
            stmt = con.prepareStatement(LISTAR_CABALLOS);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Caballo cab = new Caballo();
                cab.setId_caballo(rs.getString("id_caballo"));
                cab.setNombre(rs.getString("nombre"));
                cab.setIcono(rs.getString("imagen"));

                caballos.add(cab);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.cerrarConexion();
        return caballos;
    }

    @Override
    public void actualizarSaldo(String id_usuario, Float saldo) {
        this.abrirConexion();

        try {
            stmt = con.prepareStatement(ACTUALIZAR_SALDO);
            stmt.setFloat(1, saldo);
            stmt.setString(2, id_usuario);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
    }

    @Override
    public List<Tarjeta> listarTarjetasUsuario(String id_usuario) {
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Tarjeta> tarjetas = new ArrayList<>();

        this.abrirConexion();

        try {
            stmt = con.prepareStatement(LISTAR_TARJETAS_USUARIO);
            stmt.setString(1, id_usuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Tarjeta tar = new Tarjeta();
                tar.setNum_tarjeta(rs.getString("num_tarjeta"));
                tar.setFecha_cad(LocalDate.parse(rs.getDate("fecha_cad") + "", formateador));
                tar.setCsv(rs.getInt("csv"));
                tar.setPin(rs.getInt("pin"));
                tar.setSaldo(rs.getFloat("saldo"));
                tarjetas.add(tar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.cerrarConexion();
        return tarjetas;
    }

}
