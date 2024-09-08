package recursividad;

public class cerosArrUni {

    public static void main(String[] args) {
        int[] arreglo = {0, 1, 0, 3, 4, 0, 6}; // Ejemplo de arreglo
        int n = arreglo.length;

        int cantidadCeros = contarCerosRecursivo(arreglo, 0, n);
        System.out.println("La cantidad de ceros en el arreglo es: " + cantidadCeros);
    }

    // Método recursivo para contar ceros en un arreglo
    public static int contarCerosRecursivo(int[] arreglo, int inicio, int n) {
        // Caso base: si el inicio es igual al tamaño del arreglo, se termina la recursión
        if (inicio == n) {
            return 0;
        }
        // Si el elemento actual es 0, cuenta 1 y continúa con la recursión
        if (arreglo[inicio] == 0) {
            return 1 + contarCerosRecursivo(arreglo, inicio + 1, n);
        }
        // Si no es 0, continúa con la recursión sin contar
        return contarCerosRecursivo(arreglo, inicio + 1, n);
    }
}

