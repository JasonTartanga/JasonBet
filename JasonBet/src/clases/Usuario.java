package clases;

import java.time.LocalDate;

/**
 *
 * @author xDoble_Jx
 */
public class Usuario {

    private String id_usuario;
    private String nombre;
    private String apellidos;
    private String contrasenia;
    private String dni;
    private String gmail;
    private LocalDate fecha_nac;
    private float saldo;
    private String imagen;

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setIcono(String imagen) {
        this.imagen = imagen;
    }

    public String getIcono() {
        return imagen;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", contrasenia=" + contrasenia + ", dni=" + dni + ", gmail=" + gmail + ", fecha_nac=" + fecha_nac + ", saldo=" + saldo + ", imagen=" + imagen + '}';
    }

}
