package recursividad;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {

    private String[][] parqueadero = {
            {"L", " ", "L", "D", "R1","L", "L"},
            {"L", " ", "L", "C", " ", "L", " "},
            {" ", " ", " ", "C", " ", " ", " "},
            {"C", " ", " ", "C", "D", "D", " "},
            {"C", " ", " ", " ", " ", "L", " "},
            {"C", " ", "C", " ", " ", "L", " "},
            {"C", " ", "C", " ", "C", "C", " "},
            {" ", " ", "C", " ", " ", " ", " "},
            {"C", " ", "C", " ", "C", " ", "C"},
            {"C", " ", "R", " ", "C", " ", "R"},
            {" ", " ", "R", " ", "C", "C", "R"},
            {"E", "R", " ", " ", " ", " ", "R2"}
    };

    private int[] entradaPos = {11, 0}; // Coordenadas de la entrada

    // Lista de destinos (espacios reservados)
    private List<String> reservados = new ArrayList<>();

    public static void main(String[] args) {
        Parqueadero p = new Parqueadero();

        // Agregar destinos reservados (puedes agregar más aquí)
        p.reservados.add("R1");
        p.reservados.add("R2");

        // Parquea los carros en los destinos
        p.parquearCarrosRecursivamente(0);
    }

    // Método para parquear N carros recursivamente
    public boolean parquearCarrosRecursivamente(int indice) {
        if (indice >= reservados.size()) {
            return true;  // Todos los carros han sido estacionados
        }

        String destino = reservados.get(indice);

        if (parquearCarro(entradaPos[0], entradaPos[1], destino)) {
            imprimirParqueaderoRecursivo(0, 0);  // Mostrar el estado del parqueadero después de parquear el carro

            // Limpiar el camino antes de intentar el próximo carro
            limpiarCaminoRecursivo(0, 0);

            // Intentar parquear el siguiente carro recursivamente
            return parquearCarrosRecursivamente(indice + 1);
        } else {
            System.out.println("No se pudo parquear el carro en " + destino);
            return false;  // No se pudo estacionar en este destino
        }
    }

    public boolean parquearCarro(int x, int y, String destino) {
        if (!esValido(x, y)) {
            return false;  // Verifica que esté dentro del parqueadero
        }

        if (parqueadero[x][y].equals(destino)) {  // Si llega al destino (R1 o R2)
            parqueadero[x][y] = "PAR";  // Estaciona el carro
            return true;
        }

        if (!parqueadero[x][y].equals(" ") && !parqueadero[x][y].equals("E")
                && !parqueadero[x][y].equals("L")) {
            return false;  // No puede moverse si no es un pasillo, entrada o espacio libre
        }

        // Marca el paso del carro
        String backup = parqueadero[x][y];
        parqueadero[x][y] = "+";

        // Intentar moverse en las cuatro direcciones: derecha, abajo, arriba, izquierda
        if (parquearCarro(x, y + 1, destino) ||  // Derecha
                parquearCarro(x + 1, y, destino) ||  // Abajo
                parquearCarro(x - 1, y, destino) ||  // Arriba
                parquearCarro(x, y - 1, destino)) {  // Izquierda
            return true;
        }

        // Vuelve atrás si no encontró el destino en esta ruta
        parqueadero[x][y] = backup;
        return false;
    }

    private boolean esValido(int x, int y) {
        return x >= 0 && x < parqueadero.length && y >= 0 && y < parqueadero[0].length;
    }

    // Método recursivo para limpiar el camino
    private void limpiarCaminoRecursivo(int i, int j) {
        if (i >= parqueadero.length) {
            return;  // Caso base: si hemos recorrido todas las filas, terminamos
        }

        if (j >= parqueadero[i].length) {
            limpiarCaminoRecursivo(i + 1, 0);  // Cambiar a la siguiente fila
            return;
        }

        if (parqueadero[i][j].equals("+")) {
            parqueadero[i][j] = " ";  // Limpia el camino
        }
        limpiarCaminoRecursivo(i, j + 1);  // Continuar en la misma fila
    }

    // Método recursivo para imprimir el parqueadero
    private void imprimirParqueaderoRecursivo(int i, int j) {
        if (i >= parqueadero.length) {
            System.out.println();  // Caso base: si hemos recorrido todas las filas, terminamos
            return;
        }

        if (j >= parqueadero[i].length) {
            System.out.println();  // Cambio de línea al final de la fila
            imprimirParqueaderoRecursivo(i + 1, 0);  // Cambiar a la siguiente fila
            return;
        }

        System.out.print(parqueadero[i][j] + "\t");
        imprimirParqueaderoRecursivo(i, j + 1);  // Continuar en la misma fila
    }
}