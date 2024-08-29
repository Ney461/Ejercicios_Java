package Reto16;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */
public class CuantosDias {
    public static void main(String[] args) throws ParseException{
        //Declaración y asignación de variables
        String fecha1, fecha2;
        fecha1 = "11/06/2024";
        fecha2 = "29/08/2024";

        //Imprime la cantidad de días de diferencia
        System.out.println("La diferencia de días entre ["+fecha1+"] y ["+fecha2+"] es: "+cuantosDias(fecha1, fecha2)+" días");
   }

    public static int cuantosDias(String strFecha1, String strFecha2) throws ParseException{
        //Formato de la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        //Esto asegura que solo acepte fechas válidas y exactas
        sdf.setLenient(false);

        try {
            //Instancias de Date que representan las fechas y reciben como parámetro el String del main
            Date fechaDate1 = sdf.parse(strFecha1);
            Date fechaDate2 = sdf.parse(strFecha2);

            // Calcula la diferencia en milisegundos entre ambas fechas y la convierte a un valor absoluto usando Math.abs()
            long diferenciaMilisegundos = Math.abs(fechaDate1.getTime() - fechaDate2.getTime());
            
            // Convierte la diferencia en milisegundos a días usando TimeUnit.DAYS.convert
            // La función convert toma la diferencia en milisegundos y la convierte a días
            int diferenciaDias = (int)TimeUnit.DAYS.convert(diferenciaMilisegundos, TimeUnit.MILLISECONDS);

            //Retorna la cantidad de días en entero
            return diferenciaDias;
        } catch (ParseException e) {
            // Lanzar una excepción personalizada si el formato es incorrecto
            throw new IllegalArgumentException("El formato ingresado es incorrecto. Por favor, use 'dd/MM/yyyy'.");
        }
    } 
}
