package recursividad;

public class Laberinto {

    public char[][] laberinto={
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' '},
            {'#', '#', '#', '#', '#', ' ', '#', '#', '#', ' '},
            {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', ' '},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'#', ' ', '#', '#', '#', '#', '#', '#', '#', ' '},
    };

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args) {
        Laberinto m = new Laberinto();  // Construimos un objeto de la clase Laberinto por defecto
        m.laberinto[2][1] = 'X';  // Introducimos en este caso, la salida (X) en las coordenadas (1,1)
        m.resuelve(9, 1);  // Ahora, introducimos la entrada (S) en las coordenadas (9,1) y llamamos al algoritmo
        System.out.println(m.imprimirLaberintoRecursivo(0, 0));  // Imprimimos el laberinto ya resuelto (si tiene solución)
    }

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y) {  // Permite introducir unas coordenadas (x, y)
        if (paso(x, y)) {  // Intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S';  // Introduce en las coordenadas (x, y) la entrada
        }
    }

    private boolean paso(int x, int y) {

        // Verificar si las coordenadas están dentro de los límites del laberinto
        if (!esValido(x, y)) {
            return false;  // Si está fuera de los límites, no es posible continuar por esta ruta
        }

        if (laberinto[x][y] == 'X') {  // Si hemos llegado a X, quiere decir que hemos encontrado solución
            return true;  // Luego, el algoritmo termina
        }

        if (laberinto[x][y] == '#' || laberinto[x][y] == '*' || laberinto[x][y] == 'f') {  // Si llegamos a una pared o al mismo punto,
            return false;  // Entonces el laberinto no puede resolverse y termina.
        }

        laberinto[x][y] = '*';  // Marcamos la posición como visitada

        // Intentar mover en las cuatro direcciones posibles usando recursividad
        if (paso(x, y + 1)) return true;  // Derecha
        if (paso(x - 1, y)) return true;  // Arriba
        if (paso(x, y - 1)) return true;  // Izquierda
        if (paso(x + 1, y)) return true;  // Abajo

        laberinto[x][y] = 'f';  // Volver atrás si la solución no se encuentra aquí
        return false;
    }

    // Método auxiliar para verificar si las coordenadas están dentro del rango del laberinto y evitar un desbordamiento
    private boolean esValido(int x, int y) {
        return (x >= 0 && x < laberinto.length && y >= 0 && y < laberinto[0].length);
    }

    private String imprimirLaberintoRecursivo(int x, int y) {
        if (x == laberinto.length) return "";  // Caso base: si hemos recorrido todas las filas, terminamos

        String salida = laberinto[x][y] + " ";
        if (y == laberinto[x].length - 1) {
            salida += "\n" + imprimirLaberintoRecursivo(x + 1, 0);  // Cambiar a la siguiente fila
        } else {
            salida += imprimirLaberintoRecursivo(x, y + 1);  // Continuar en la misma fila
        }
        return salida;
    }
}
