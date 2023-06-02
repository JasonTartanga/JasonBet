/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author xDoble_Jx
 */
public class Utilidades {

    public static int numeros_aleatorios(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static boolean validarDni(String dni) {
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

        boolean correcto = true;
        try {

            if (dni.length() != 9) {
                System.out.println("longitud diferente a 9");
                return false;
            }

            int numDni = Integer.parseInt(dni.substring(0, 8));
            int charDni = numDni % 23;

            if (dni.charAt(8) != caracteres.charAt(charDni)) {
                return false;
            }

        } catch (NumberFormatException e) {

            return false;
        }

        return true;
    }

    public static LocalDate validarFecha(String fec) {
        DateTimeFormatter formateadorG = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formateadorB = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        char s = fec.charAt(2);

        try {
            if (s == '-') {
                return LocalDate.parse(fec, formateadorG);

            } else if (s == '/') {
                return LocalDate.parse(fec, formateadorB);
            } else {
                return null;
            }
        } catch (DateTimeParseException e) {
            return null;
        }

    }

    public static boolean validarGmail(String email) {
        // Expresión regular para validar una dirección de correo electrónico de Gmail
        String regex = "^[A-Za-z0-9+_.-]+@gmail\\.com$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static float generarCuotas(int media, int desviacion, int minimo, int maximo) {
        Random random = new Random();
        double numeroAleatorio;

        do {
            numeroAleatorio = (random.nextGaussian() * desviacion) + media;
        } while (numeroAleatorio < minimo || numeroAleatorio > maximo);

        double factor = Math.pow(10, 2);
        return (float) (Math.round(numeroAleatorio * factor) / factor);
    }
}
