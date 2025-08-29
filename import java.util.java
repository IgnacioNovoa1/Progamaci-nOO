import java.util.Scanner;
public class UtilidadesTexto {

    public static String ingresarFrase() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la frase a evaluar: ");
        String frase = sc.nextLine();
        return frase;
    }

    public static String fraseLimpia(String frase) {
        String palabraLimpia = frase.replaceAll("\\s+", "").toLowerCase();
        return palabraLimpia;
    }

    public static boolean revesDerecho(String frase) {
        String limpia = fraseLimpia(frase);
        String reverso = new StringBuilder(limpia).reverse().toString();
        return limpia.equals(reverso);
    }

    public static int contarVocales(String frase) {
        int contador = 0;
        String minus = frase.toLowerCase();

        char[] vocales = {'a', 'e', 'i', 'o', 'u'};

        for (int i = 0; i < minus.length(); i++) {
            char c = minus.charAt(i);
            for (char v : vocales) {
                if (c == v) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public static void main(String[] args) {  
    }
}

