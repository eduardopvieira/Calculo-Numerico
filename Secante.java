public class Secante {
    public static void main(String[] args) {
        double x0 = -1.5;
        double tol = 0.0001;

        double result = metodoSecante(x0, tol);

        if (!(result == 0)) {
            System.out.println("O método convergiu para a raiz: " + result);
        } else {
            System.out.println("Não foi possível encontrar uma raiz no número máximo de iterações.");
        }
    }

    public static double f(double x) {
        return (x * x ) + (2 * x) - 8;
    }

    public static double calculoSecante(double xk, double xkAnterior) {
        
        double denominador = (f(xk) - f(xkAnterior)) / (xk - xkAnterior);
        double calculo = xk - (f(xk) / denominador);

        return calculo;
    }

    public static double metodoSecante(double x0, double tol) {
        // Definindo a segunda aproximação inicial com base na primeira aproximação
        double x1 = x0 + 0.1; // Por exemplo, poderíamos adicionar um pequeno incremento a x0
    
        double xk = x1;
        double xkAnterior = x0;
        double erro;
        int maxIteracoes = 100;
        int iteracaoAtual = 0;
    
        do {
            double verificarSecante = calculoSecante(xk, xkAnterior);
    
            if (verificarSecante == 0) {
                System.out.println("Derivada zero encontrada. O método não pode convergir.");
                return 0;
            }
    
            xk = calculoSecante(xk, xkAnterior);
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
