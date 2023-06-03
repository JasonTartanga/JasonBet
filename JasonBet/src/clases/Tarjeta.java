/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.time.LocalDate;

/**
 *
 * @author xDoble_Jx
 */
public class Tarjeta {

    private String num_tarjeta;
    private LocalDate fecha_cad;
    private int csv;
    private int pin;
    private float saldo;

    public String getNum_tarjeta() {
        return num_tarjeta;
    }

    public void setNum_tarjeta(String num_tarjeta) {
        this.num_tarjeta = num_tarjeta;
    }

    public LocalDate getFecha_cad() {
        return fecha_cad;
    }

    public void setFecha_cad(LocalDate fecha_cad) {
        this.fecha_cad = fecha_cad;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "num_tarjeta=" + num_tarjeta + ", fecha_cad=" + fecha_cad + ", csv=" + csv + ", pin=" + pin + ", saldo=" + saldo + '}';
    }

}
