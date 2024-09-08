import java.util.ArrayList;

public class MatrizPalabras {

    public static void main(String[] args) {
        // Definimos la matriz de palabras de 4x4
        String[][] matriz = {
                {"vacio", "carro", "baul", "perro"},
                {"colombia", "casa", "moto", "caza"},
                {"llanta", "reir", "archivo", "silla"},
                {"cocina", "ola", "ave", "freir", "jaar"}
        };

        // ArrayList para almacenar las palabras con dos vocales seguidas
        ArrayList<String> listaPalabras = new ArrayList<>();

        // Llamada a la función para recorrer la matriz
        recorrerMatriz(matriz, 0, 0, listaPalabras);

        // Mostrar las palabras con dos vocales seguidas
        System.out.println("Palabras con dos vocales seguidas: " + listaPalabras);
    }

    // Función recursiva para recorrer la matriz
    public static void recorrerMatriz(String[][] matriz, int i, int j, ArrayList<String> listaPalabras) {
        // Caso base: si hemos recorrido toda la matriz
        if (i >= matriz.length) {
            return;
        }

        // Verificar si la palabra en la posición actual tiene dos vocales seguidas
        if (verificarVocalesSeguidas(matriz[i][j], 0)) {
            listaPalabras.add(matriz[i][j]);
        }

        // Movimiento al siguiente elemento de la matriz
        if (j < matriz[i].length - 1) {
            recorrerMatriz(matriz, i, j + 1, listaPalabras); // Continuar en la misma fila
        } else {
            recorrerMatriz(matriz, i + 1, 0, listaPalabras); // Mover a la siguiente fila
        }
    }

    // Función unificada para verificar si hay dos vocales seguidas en una palabra
    public static boolean verificarVocalesSeguidas(String palabra, int index) {
        // Caso base: si alcanzamos el final de la palabra
        if (index >= palabra.length() - 1) {
            return false;
        }

        // Convertir el carácter actual y el siguiente a minúsculas
        char actual = Character.toLowerCase(palabra.charAt(index));
        char siguiente = Character.toLowerCase(palabra.charAt(index + 1));

        // Verificar si el carácter actual y el siguiente son vocales
        if ((actual == 'a' || actual == 'e' || actual == 'i' || actual == 'o' || actual == 'u') &&
                (siguiente == 'a' || siguiente == 'e' || siguiente == 'i' || siguiente == 'o' || siguiente == 'u')) {
            return true;
        }

        // Llamada recursiva para verificar el siguiente par de caracteres
        return verificarVocalesSeguidas(palabra, index + 1);
    }
}
