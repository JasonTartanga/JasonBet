/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import java.util.Random;

/**
 *
 * @author xDoble_Jx
 */
public class Utilidades {

    public static int numeros_aleatorios(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
