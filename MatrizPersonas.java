import java.util.ArrayList;
import java.util.List;

class Persona {
    int edad;

    public Persona(int edad) {
        this.edad = edad;
    }
}

public class MatrizPersonas {

    public static void main(String[] args) {
        // Crear la matriz de personas
        Persona[][] matriz = {
                {new Persona(5), new Persona(7), new Persona(1), new Persona(3)},
                {new Persona(6), new Persona(45), new Persona(13), new Persona(89)},
                {new Persona(2), new Persona(28), new Persona(496), new Persona(8128)},
                {new Persona(11), new Persona(4), new Persona(8), new Persona(89)},
                {new Persona(31), new Persona(37), new Persona(43), new Persona(10)}
        };

        // Listas para almacenar edades primos y perfectos
        List<Integer> listaPrimos = new ArrayList<>();
        List<Integer> listaPerfectos = new ArrayList<>();

        // Iniciar el recorrido recursivo de la matriz
        recorrerMatriz(matriz, matriz.length - 1, 0, listaPrimos, listaPerfectos);

        // Imprimir los resultados
        System.out.println("Edades Primos:");
        imprimirLista(listaPrimos, 0);
        System.out.println("Edades Perfectos:");
        imprimirLista(listaPerfectos, 0);
    }

    // Función para recorrer la matriz de forma recursiva
    public static void recorrerMatriz(Persona[][] matriz, int i, int j, List<Integer> listaPrimos, List<Integer> listaPerfectos) {
        // Caso base: si estamos fuera de los límites de la matriz
        if (i < 0) {
            return;
        }

        // Obtener la edad de la persona actual
        int edad = matriz[i][j].edad;

        // Verificar si la edad es un número primo
        if (esPrimoRecursivo(edad, 2)) {
            listaPrimos.add(edad);
        }

        // Verificar si la edad es un número perfecto
        if (esPerfectoRecursivo(edad, 1, 0)) {
            listaPerfectos.add(edad);
        }

        // Avanzar a la siguiente posición en la matriz
        if (j < matriz[0].length - 1) {
            recorrerMatriz(matriz, i, j + 1, listaPrimos, listaPerfectos);
        } else {
            recorrerMatriz(matriz, i - 1, 0, listaPrimos, listaPerfectos);
        }
    }

    // Función recursiva para verificar si un número es primo
    public static boolean esPrimoRecursivo(int n, int divisor) {
        if (n <= 1) {
            return false;
        }
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return esPrimoRecursivo(n, divisor + 1);
    }

    // Función recursiva para verificar si un número es perfecto
    public static boolean esPerfectoRecursivo(int n, int divisor, int suma) {
        if (divisor == n) {
            return suma == n;
        }
        if (n % divisor == 0) {
            suma += divisor;
        }
        return esPerfectoRecursivo(n, divisor + 1, suma);
    }

    // Función recursiva para imprimir una lista
    public static void imprimirLista(List<Integer> lista, int index) {
        if (index >= lista.size()) {
            return;
        }
        System.out.println(lista.get(index));
        imprimirLista(lista, index + 1);
    }
}
