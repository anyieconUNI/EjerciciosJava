public class adivinarNum {
    public static void modificarValor(int numero){
        numero=100;
        System.out.println("número dentro del metodo: "+numero);
    }
    public static void main(String[] args) {
        int valor =50;
        System.out.println("valor antes de ser modificado:" + valor);

        modificarValor(valor);
        System.out.println("valor después de ser modificado: "+valor);
    }
}
