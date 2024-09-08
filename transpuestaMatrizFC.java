import java.util.Arrays;

public class transpuestaMatrizFC {
    public static void main(String[] args) {
        // Matriz de ejemplo de tamaño 4x2 (irregular)
        int[][] matriz = {
                {1, 2},
                {3, 4},
                {5, 6},
                {7}
        };

        // Llamada al método unificado para obtener y mostrar la matriz transpuesta
        procesarMatriz(matriz, 0, 0, null, 0);
    }

    // Método unificado para transponer la matriz, calcular la matriz transpuesta e imprimirla
    public static int[][] procesarMatriz(int[][] matriz, int i, int j, int[][] transpuesta, int maxColumnas) {
        // Caso base: si es la primera llamada, determinar la longitud máxima de las columnas
        if (transpuesta == null) {
            if (i >= matriz.length) {
                // Crear la matriz transpuesta con el tamaño adecuado
                transpuesta = new int[maxColumnas][matriz.length];
                return procesarMatriz(matriz, 0, 0, transpuesta, maxColumnas);
            }

            // Calcular la longitud máxima de las columnas de la matriz original
            if (j < matriz[i].length) {
                maxColumnas = Math.max(maxColumnas, matriz[i].length);
                return procesarMatriz(matriz, i, j + 1, null, maxColumnas);
            } else {
                return procesarMatriz(matriz, i + 1, 0, null, maxColumnas);
            }
        }

        // Caso base: si hemos procesado todas las filas de la matriz original
        if (i >= matriz.length) {
            imprimirMatriz(transpuesta, 0); // Llamada recursiva para imprimir la matriz transpuesta
            return transpuesta;
        }

        // Caso base: si hemos procesado todas las columnas de la fila actual
        if (j >= matriz[i].length) {
            return procesarMatriz(matriz, i + 1, 0, transpuesta, maxColumnas); // Pasar a la siguiente fila
        }

        // Asignar el valor de la matriz original a la posición transpuesta
        transpuesta[j][i] = matriz[i][j];

        // Llamada recursiva para procesar el siguiente elemento en la fila
        return procesarMatriz(matriz, i, j + 1, transpuesta, maxColumnas);
    }

    // Método recursivo para imprimir la matriz
    public static void imprimirMatriz(int[][] matriz, int i) {
        // Caso base: si hemos procesado todas las filas
        if (i >= matriz.length) {
            return;
        }

        // Imprimir la fila actual
        System.out.println(Arrays.toString(matriz[i]));

        // Llamada recursiva para imprimir la siguiente fila
        imprimirMatriz(matriz, i + 1);
    }
}
