public class SomaRiemann {
    public static void main(String[] args) {
        double n = 100000; // n = número de retangulos
        int a = 2; // a = ponto mais a es
        int b = 5; // b = ponto mais a direita do intervalo
        double soma = 0;
        double deltaX = (b - a) / n;

        for (int i = 0; i < n; i++) {
            double xi = a + i * deltaX;
            soma += f(xi) * deltaX;
        }

        System.out.println("Area total: " + soma);

    }

    public static double f(double x) {
        double funcao = -(x * x) + (4 * x) + 5;
        return funcao;
    }
}