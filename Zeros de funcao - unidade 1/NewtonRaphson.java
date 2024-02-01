public class NewtonRaphson {
    public static void main(String[] args) {
        double x0 = 0;
        double tol = 0.01;
        double h = 0.01;    

        double result = newtonRaphson(x0, tol, h);

        if (result != 0) {
            System.out.println("O método convergiu para a raiz: " + result);
        } else {
            System.out.println("Não foi possível encontrar uma raiz no número máximo de iterações.");
        }
    }

    public static double f(double x) {
        return (x * x) + (x) - 26;
    }

    public static double derivada(double xk, double h) {
        double xkh = f(xk+h);
        System.out.println("f(xk+h): " + xkh);
        double xkmenosh = f(xk-h);
        System.out.println("f(xk-h): " + xkmenosh);
        double doish = 2 * h;
        System.out.println("2h: " + doish);
        System.out.println("f(xk+h) - f(xk-h): " + (xkh - xkmenosh));
        System.out.println("resultado:" + (f(xk + h) - f(xk - h)) / (2 * h));
        System.out.println("====================");
        
        return (f(xk + h) - f(xk - h)) / (2 * h);
    }

    public static double newtonRaphson(double x0, double tol, double h) {
        double xk = x0;
        double erro;
        int maxIteracoes = 100;
        int iteracaoAtual = 0;

        do {
            double derivadaXk = derivada(xk, h);
            System.out.println("Derivada de xk: " + derivadaXk);
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
            System.out.println("Não foi possível encontrar uma raiz. Número de iterações: " + (iteracaoAtual + 1));
            return 0;
        }
    }
}
