package Reto15;
/*
 * Escribe una función que calcule si un número dado es un número de Armstrong
 * (o también llamado narcisista).
 * Ejemplo:
 * 153
 * Entonces sería:
 * 1^3 = 1
 * 5^3 = 125
 * 3^3 = 27
 * La sumatoria de estos números es 153
 * El exponente depende del número de dígitos que tenga el número
 */
public class numeroArmstrong {
    public static void main(String[] args) {
        long num = 54748;
        //Imprime el resultado de la comprobación 
        System.out.println("El número "+num+esArmstrong(num));
    }
    public static String esArmstrong(long num){
        //Obtener la cantidad de dígitos que tiene el número 
        String strDig = String.valueOf(num);
        int cantDig = strDig.length();

        //Convertir el String strDig a un array de caracteres
        char[] charNum = strDig.toCharArray();

        //Variable acumuladora para la suma
        int suma=0;

        //Iterar sobre cada carácter en charNum
        for(char n : charNum){
            //Convertir el carácter n a entero restando '0' para evitar obtener el codigo ASCII y guardarlo en x
            int x = n-'0';

            //Elevar cada entero por la cantidad de dígitos del número
            int y = (int) Math.pow(x, cantDig);

            //Acumular el resultado en la variable suma
            suma += y;
        } 
        //Crear el mensaje para mostrar el resultado
        String msj = (num==suma) ? " es un número Armstrong" : " no es un número Armstrong";
        
        //Retornamos el mensaje 
        return msj;
    }
}
