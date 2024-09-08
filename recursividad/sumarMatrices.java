package recursividad;
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
        };
        SumarMatrices(matrizUno, matrizDos, 0, 0);
    }
    public static void SumarMatrices(int[][] matrizUno, int[][] matrizDos, int fila, int columna) {
        if (fila == matrizUno.length) {
            return;
        }

        if (columna < matrizUno[fila].length && columna < matrizDos[fila].length) {
            int suma = matrizUno[fila][columna] + matrizDos[fila][columna];
            System.out.print(suma + " ");
        } else if (columna < matrizUno[fila].length) {
            System.out.print(matrizUno[fila][columna] + " ");
        } else if (columna < matrizDos[fila].length) {
            System.out.print(matrizDos[fila][columna] + " ");
        }

        if (columna < matrizUno[0].length - 1) {
            SumarMatrices(matrizUno, matrizDos, fila, columna + 1);
        } else {
            System.out.println();
            SumarMatrices(matrizUno, matrizDos, fila + 1, 0);
        }
    }
}
