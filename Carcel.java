public class Carcel {

    // Definición de la cárcel como una matriz 2D
    static char[][] carcel = {
            {' ', 'X', 'P', ' ', ' ', ' ', ' ', 'P'},
            {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'P'},
            {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'P'},
            {' ', ' ', ' ', ' ', 'X', ' ', ' ', 'P'},
            {' ', ' ', 'X', ' ', ' ', ' ', ' ', 'P'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'G'},
            {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' '}
    };

    // Punto de control de llegada
    static int[] puntoControl = {5, 7}; // (fila, columna)
    static int presosTotales = 26; // Cantidad total de presos que deben haber

    public static void main(String[] args) {
        // Matriz para llevar el registro de las posiciones visitadas
        boolean[][] visitado = new boolean[carcel.length][carcel[0].length];

        // Iniciar el recorrido desde la posición inicial (0, 0)
        int presosEncontrados = recorrerCarcel(0, 0, visitado, 0);

        // Mostrar el resultado final
        if (presosEncontrados == presosTotales) {
            System.out.println("No se ha escapado ningún preso.");
        } else if (presosEncontrados < presosTotales) {
            System.out.println("Se han escapado " + (presosTotales - presosEncontrados) + " presos.");
        } else {
            System.out.println("No se pudo llegar al punto de control.");
        }
    }

    // Método para verificar si la posición (x, y) es válida y no ha sido visitada
    public static boolean esValido(int x, int y, boolean[][] visitado) {
        return x >= 0 && x < carcel.length && y >= 0 && y < carcel[0].length && !visitado[x][y];
    }

    // Método recursivo para recorrer la cárcel y contar los presos
    public static int recorrerCarcel(int x, int y, boolean[][] visitado, int presosEncontrados) {
        // Verificar si hemos llegado al punto de control
        if (x == puntoControl[0] && y == puntoControl[1]) {
            System.out.println("Llegamos al punto de control con " + presosEncontrados + " presos encontrados.");
            return presosEncontrados;
        }

        // Marcar la posición actual como visitada
        visitado[x][y] = true;

        // Si encontramos un preso, incrementamos el contador
        if (carcel[x][y] == 'P') {
            presosEncontrados++;
        }

        int maxPresosEncontrados = -1;

        // Movimiento a la derecha
        if (esValido(x, y + 1, visitado)) {
            int resultadoDerecha = recorrerCarcel(x, y + 1, visitado, presosEncontrados);
            maxPresosEncontrados = Math.max(maxPresosEncontrados, resultadoDerecha);
        }

        // Movimiento hacia abajo
        if (esValido(x + 1, y, visitado)) {
            int resultadoAbajo = recorrerCarcel(x + 1, y, visitado, presosEncontrados);
            maxPresosEncontrados = Math.max(maxPresosEncontrados, resultadoAbajo);
        }

        // Movimiento hacia arriba
        if (esValido(x - 1, y, visitado)) {
            int resultadoArriba = recorrerCarcel(x - 1, y, visitado, presosEncontrados);
            maxPresosEncontrados = Math.max(maxPresosEncontrados, resultadoArriba);
        }

        // Movimiento a la izquierda
        if (esValido(x, y - 1, visitado)) {
            int resultadoIzquierda = recorrerCarcel(x, y - 1, visitado, presosEncontrados);
            maxPresosEncontrados = Math.max(maxPresosEncontrados, resultadoIzquierda);
        }

        // Si se encontró un camino válido, devolver el máximo de presos encontrados
        if (maxPresosEncontrados != -1) {
            visitado[x][y] = false; // Retroceder (desmarcar)
            return maxPresosEncontrados;
        } else {
            // Si no se encontró un camino, mantener el punto como visitado (evitar ciclos infinitos)
            return -1;
        }
    }
}
