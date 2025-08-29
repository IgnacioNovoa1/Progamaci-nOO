import java.util.Scanner;
public class UtilidadesTexto {

    public static String ingresarFrase(Scanner sc) {
        System.out.print("Ingresa la frase a evaluar: ");
        String frase = sc.nextLine();
        while (frase.trim().isEmpty()) {
            System.out.println("Error: La frase no puede estar vacía.");
            System.out.print("Ingresa la frase a evaluar: ");
            frase = sc.nextLine();
        }
        return frase;
    }

    public static String fraseLimpia(String frase) {
        String palabraLimpia = frase.replaceAll("\\s+", "").toLowerCase();
        return palabraLimpia;
    }

    public static boolean revesDerecho(String frase) {
        String limpia = fraseLimpia(frase);
        if (!limpia.matches("[a-z]+")) {
            System.out.println("Advertencia: La frase contiene números o símbolos. Palíndromo solo evalúa letras.");
            return false;
        }
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
    public static String encriptar(String frase){
        if (!frase.matches("[a-zA-Z\\s]+")) {
            System.out.println("Advertencia: La frase contiene números o símbolos. Solo se encriptarán las letras.");
        }
        String encriptada = frase.replaceAll("a", "@")
                         .replaceAll("e", "&")
                         .replaceAll("i", "!")
                         .replaceAll("o", "*")
                         .replaceAll("u", "#");

        return encriptada
        ;                
    }

    public static String desencriptar(String encriptada){
        if (!encriptada.matches(".*[@&!*#].*")) {
            System.out.println("Advertencia: La frase no parece estar encriptada.");
        }
        String desencriptada = encriptada.replaceAll("@", "a")
                         .replaceAll("&", "e")
                         .replaceAll("!", "i")
                         .replaceAll("*", "o")
                         .replaceAll("#", "u");

        return desencriptada;                
    }
    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ DE UTILIDADES =====");
        System.out.println("1. Verificar Revés-Derecho (Palíndromo)");
        System.out.println("2. Contar vocales");
        System.out.println("3. Encriptar frase");
        System.out.println("4. Desencriptar frase");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }
    
    public static void opcion1 (Scanner sc) {
        String frase = ingresarFrase(sc);
        System.out.println("Tu frase " + frase + "¿es un palíndromo? " + revesDerecho(frase));
    }

    public static void opcion2(Scanner sc){
        String frase = ingresarFrase(sc);
        System.out.println("El número de voclaes de tu frase es: " + contarVocales(frase));
    }
    
    public static void opcion3(Scanner sc){
        String frase = ingresarFrase(sc);
        System.out.println("Frase encriptada: " + encriptar(frase));
    }

    public static void opcion4(Scanner sc){
        String frase = ingresarFrase(sc);
        System.out.println("Frase desencriptada: " + desencriptar(frase));
    }
    public static void iniciarPrograma(){
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            if (!sc.hasNextInt()) {
                System.out.println("Error: Debes ingresar un número entre 1 y 5.");
                sc.nextLine(); 
                continue;
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> opcion1(sc);
                case 2 -> opcion2(sc);
                case 3 -> opcion3(sc);
                case 4 -> opcion4(sc);
                case 5 -> System.out.println("Adios...");
                default -> System.out.println("Opción invalida...");
            }
        
        } while (opcion != 5);
        sc.close();
    }

    public static void main(String[] args){
        iniciarPrograma();
    }
}
