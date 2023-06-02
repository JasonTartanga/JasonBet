/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author xDoble_Jx
 */
public class Caballo {

    private String id_caballo;
    private String nombre;
    private String icono;
    private float cuota;

    public String getId_caballo() {
        return id_caballo;
    }

    public void setId_caballo(String id_caballo) {
        this.id_caballo = id_caballo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public float getCuota() {
        return cuota;
    }

    public void setCuota(float cuota) {
        this.cuota = cuota;
    }

    @Override
    public String toString() {
        return "Caballo{" + "id_caballo=" + id_caballo + ", nombre=" + nombre + ", icono=" + icono + ", cuota=" + cuota + '}';
    }

}
