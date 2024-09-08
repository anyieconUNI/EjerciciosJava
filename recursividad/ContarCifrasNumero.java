package recursividad;

public class ContarCifrasNumero {

    public static void main(String[] args) {
        int numero = 123456;
        int cantidadCifras = contarCifrasRecursivo(Math.abs(numero));
        System.out.println("La cantidad de cifras del número " + numero + " es: " + cantidadCifras);
    }

    // Método recursivo para contar la cantidad de cifras de un número
    public static int contarCifrasRecursivo(int n) {
        // Caso base: Si el número es 0, tiene una cifra
        if (n == 0) {
            return 0;
        }
        // Caso recursivo: Llamar a la función con n dividido por 10
        return 1 + contarCifrasRecursivo(n / 10);
    }
}

