import java.lang.*;

class Main {
    public static void main(String[] args) {
        int[][] matrizUno = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrizDos = {
            {9, 8},
            {6, 5, 4},
            {7, 8, 9}
            // Tercera fila tiene solo 2 elementos
        };
        validarMatrices(matrizUno, matrizDos);
        // Llamar al método para sumar e imprimir
        SumarMatrices(matrizUno, matrizDos, 0, 0);
    }
    public static void validarMatrices(int[][] matrizUno, int[][] matrizDos) {
        if (matrizUno == null || matrizDos == null) {
            System.out.print("Ninguna de las matrices puede ser nula.");
        }
        if (matrizUno.length != matrizDos.length) {
            System.out.print("Las matrices deben tener el mismo número de filas.");
        }
        if (matrizUno.length == 0 || matrizUno[0].length == 0 || matrizDos.length == 0 || matrizDos[0].length == 0) {
            System.out.print("Las matrices no deben estar vacías.");
        }
    }
    public static void SumarMatrices(int[][] matrizUno, int[][] matrizDos, int fila, int columna) {
        // Caso base: si hemos llegado al final de las filas, terminar
        if (fila == matrizUno.length) {
            return;
        }

        // Verificar si los índices están dentro de los límites de ambas matrices
        if (columna < matrizUno[fila].length && columna < matrizDos[fila].length) {
            // Sumar el elemento actual y mostrarlo directamente
            int suma = matrizUno[fila][columna] + matrizDos[fila][columna];
            System.out.print(suma + " ");
        } else if (columna < matrizUno[fila].length) { 
            // Si matrizDos no tiene el elemento, imprimir solo el elemento de matrizUno
            System.out.print(matrizUno[fila][columna] + " ");
        } else if (columna < matrizDos[fila].length) { 
            // Si matrizUno no tiene el elemento, imprimir solo el elemento de matrizDos
            System.out.print(matrizDos[fila][columna] + " ");
        }
        
        // Mover a la siguiente columna o fila
        if (columna < matrizUno[0].length - 1) {
            SumarMatrices(matrizUno, matrizDos, fila, columna + 1);
        } else {
            // Imprimir salto de línea al finalizar una fila y avanzar a la siguiente
            System.out.println();
            SumarMatrices(matrizUno, matrizDos, fila + 1, 0);
        }
    }
}