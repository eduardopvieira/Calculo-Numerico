public class NewtonRaphson {
    public static void main(String[] args) {
        double x0 = 1.5;
        double tol = 0.001;
        double h = 0.000001;    

        double result = newtonRaphson(x0, tol, h);

        if (!(result == 0)) {
            System.out.println("O método convergiu para a raiz: " + result);
        } else {
            System.out.println("Não foi possível encontrar uma raiz no número máximo de iterações.");
        }
    }

    public static double f(double x) {
        return (x * x) + (5 * x) - 9;
    }

    public static double derivada(double xk, double h) {
        // Improved derivative calculation
        return (f(xk + h) - f(xk - h)) / (2 * h);
    }

    public static double newtonRaphson(double x0, double tol, double h) {
        double xk = x0;
        double erro;
        int maxIteracoes = 100;
        int iteracaoAtual = 0;

        do {
            double derivadaXk = derivada(xk, h);
            
            if (derivadaXk == 0) {
                System.out.println("Derivada zero encontrada. O método não pode convergir.");
                return 0;
            }

            xk = xk - (f(xk) / derivadaXk);
            erro = Math.abs(f(xk));
            System.out.println("Iteração " + iteracaoAtual + ": xk = " + xk + ", Erro = " + erro);
            iteracaoAtual++;

        } while(iteracaoAtual < maxIteracoes && erro >= tol);

        if (erro <= tol) {
            return xk;
        } else {
            System.out.println("Não foi possível encontrar uma raiz. Número de iterações: " + iteracaoAtual);
            return 0;
        }
    }
}
