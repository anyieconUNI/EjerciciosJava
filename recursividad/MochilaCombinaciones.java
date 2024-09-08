package recursividad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MochilaCombinaciones {

    private static final Set<String> posibilidadesMochila = new HashSet<>();

    public static void main(String[] args) {
        int[] pesos = {12, 2, 5, 11, 4,1,10};
        int[] valores = {4, 2, 2, 1, 10,80,1};
        int capacidad = 15;

        calcularPosibilidades(valores, pesos, capacidad, 0, new ArrayList<>(), 0, 0);
    }

    public static void calcularPosibilidades(int[] valores, int[] pesos, int capacidad, int inicio, List<Integer> posibilidadActual, int pesoTotal, int valorTotal) {
        if (pesoTotal == capacidad) {
            StringBuilder combinacionTexto = new StringBuilder();
            imprimirPosibilidades(posibilidadActual, valores, pesos, 0, combinacionTexto);

            if (posibilidadesMochila.add(combinacionTexto.toString())) {
                System.out.println(combinacionTexto.toString() + " -> Peso Total: " + pesoTotal + ", Valor Total: " + valorTotal);
            }
        }

        if (inicio >= pesos.length) {
            return;
        }

        posibilidadActual.add(inicio);
        calcularPosibilidades(valores, pesos, capacidad, inicio + 1, posibilidadActual, pesoTotal + pesos[inicio], valorTotal + valores[inicio]);
        posibilidadActual.remove(posibilidadActual.size() - 1);

        calcularPosibilidades(valores, pesos, capacidad, inicio + 1, posibilidadActual, pesoTotal, valorTotal);
    }

    public static void imprimirPosibilidades(List<Integer> combinacion, int[] valores, int[] pesos, int indice, StringBuilder resultado) {
        if (indice >= combinacion.size()) {
            return;
        }

        int i = combinacion.get(indice);
        resultado.append("(Peso: ").append(pesos[i]).append(", Valor: ").append(valores[i]).append(") ");
        imprimirPosibilidades(combinacion, valores, pesos, indice + 1, resultado);
    }
}
