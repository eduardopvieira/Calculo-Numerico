class FalsePosition {
    public static void main(String[] args) {
        double tol = 0.0001; // tolerancia
        double a = -5; // primeiro ponto do intervalo
        double b = -3; // segundo ponto do intervalo
        double iteracoes = numIteracoes(a, b, tol);
        int iteracaoAtual = 0;
        double result;

        System.out.println("Número máximo de iteracoes: " + iteracoes);
        result = falsaPosicao(a, b, tol, iteracoes, iteracaoAtual);
        System.out.println("Raiz aproximada: " + result);
    }

    public static double falsaPosicao(double a, double b, double tol, double iteracoes, int iteracaoAtual) {

        // Limitador de iterações:
        if (iteracaoAtual >= iteracoes) {
            System.out.println("Limite de iteracoes atingido. Nenhuma raiz encontrada.");
            return 0;
        }

        double c = a - (((b - a) * f(a)) / (f(b) - f(a)));
        double fc = f(c);

        if (Math.abs(fc) < tol) {
            System.out.println("Número de iterações: " + (iteracaoAtual + 1));
            return c;
        } else if (fc * f(a) < 0) {
            iteracaoAtual = iteracaoAtual + 1;
            System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", fc = " + fc + ", iteracaoAtual = " + iteracaoAtual);
            return falsaPosicao(a, c, tol, iteracoes, iteracaoAtual);
        } else {
            System.out.println("a = " + a + ", b = " + b + ", c = " + c + ", fc = " + fc + ", iteracaoAtual = " + iteracaoAtual);
            iteracaoAtual = iteracaoAtual + 1;
            return falsaPosicao(b, c, tol, iteracoes, iteracaoAtual);
        }
    }

    // Cálculo da função em f(x)
    public static double f(double x) {
        double result = (x * x) + (x) - 26;
        return result;
    }

    // Cálculo do número de iterações necessárias
    public static double numIteracoes(double a, double b, double tol) {
        double difBA = b - a;
        double resultFracionado = Math.log(difBA / tol) / Math.log(2);
        return Math.ceil(resultFracionado);
    }
}