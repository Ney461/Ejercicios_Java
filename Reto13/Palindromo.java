package Reto13;
/*
 * Escribe una función que reciba un texto y retorne verdadero o
 * falso (Boolean) según sean o no palíndromos.
 * Un Palíndromo es una palabra o expresión que es igual si se lee
  * de izquierda a derecha que de derecha a izquierda.
 * NO se tienen en cuenta los espacios, signos de puntuación y tildes.
 * Ejemplo: Ana lleva al oso la avellana.
 */
public class Palindromo {

    public static void main(String[] args) {
        boolean x = esPalindromo("í¿ndnÍ");
        System.out.println(x);
    }

    public static boolean esPalindromo(String frase){
        StringBuilder fraseInvertida=new StringBuilder();
        StringBuilder fraseSinEspacio=new StringBuilder();

        //*Quitar signos de puntuación, espacios y tíldes*/
        for(int i=0; i<frase.length(); i++){
            char letra = frase.toLowerCase().charAt(i);
            if(letra == 'á'){
                fraseSinEspacio.append('a');
            } else if(letra == 'é'){ 
                fraseSinEspacio.append('e');
            } else if(letra == 'í'){
                fraseSinEspacio.append('i');
            } else if(letra == 'ó'){
                fraseSinEspacio.append('o');
            } else if(letra == 'ú'){
                fraseSinEspacio.append('u');
            } else if(letra != '!' && letra != '¡' &&
                letra != '¿' && letra != '?' &&
                letra != '.' && letra != ' '){
                fraseSinEspacio.append(letra);
            }
        }

        //*Invertir la frase */
        for(int i=fraseSinEspacio.length()-1; i >= 0; i--){
            char letra = fraseSinEspacio.charAt(i);
            fraseInvertida.append(letra);
        }
        return fraseSinEspacio.toString().equals(fraseInvertida.toString());

        //! Otra forma de hacerlo de manera más optima es esta:
        /*
        String textoNormalizado = Normalizer.normalize(frase.toLowerCase(), Form.NFD)
            .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "") // Eliminar tildes
            .replaceAll("[\\W_]", ""); // Eliminar signos de puntuación y espacios

        StringBuilder textoInvertido = new StringBuilder(textoNormalizado).reverse();

        return textoNormalizado.equals(textoInvertido.toString());
         */
    }
}
