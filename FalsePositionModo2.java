

//Esse modo funciona apenas quando não levado em conta o número máximo de iterações.




class FalsePosition {
    public static void main(String[] args) {
        double tol = 0.001; // tolerancia
        double a = -1; // primeiro ponto do intervalo
        double b = 15; // segundo ponto do intervalo
        double iteracoes = numIteracoes(a, b, tol);
        int iteracaoAtual = 0;
        double result;

        System.out.println("Número máximo de iteracoes: " + iteracoes);
        result = falsaPosicao(a, b, tol, iteracoes, iteracaoAtual);
        System.out.println("Raiz aproximada: " + result);
        System.out.println("Número de iterações: " + (iteracaoAtual + 1));
    }

    public static double falsaPosicao(double a, double b, double tol, double iteracoes, int iteracaoAtual) {

        // Limitador de iterações:
        if (iteracaoAtual >= iteracoes) {
            System.out.println("Limite de iterações atingido. Nenhuma raiz encontrada.");
            return 0;
        }
    
        //double c = a - ((fa * (b - a)) / (fb - fa));
        //double fc = f(c);
    
        double cAntes = 0;
        double c = (a * f(b) - b * f(a)) / (f(b) - f(a));
        double erro = Math.abs(c - cAntes);
        double cDepois = 0;

        while (erro > tol) {
            System.out.println("A: " + a);
            System.out.println("B: " + b);
            System.out.println("C: " + c);
            System.out.println("C depois: " + cDepois);
            
            cDepois = (a * f(b) - b * f(a)) / (f(b) - f(a));

            if (f(a) * f(b) >= 0 ) {
                System.out.println("Erro: Sem raiz ou multiplas raizes no intervalo.");
                return 0;
            }

            if (f(cDepois) * f(a) < 0) {
                erro = Math.abs(cDepois - b);
                b = cDepois;
                iteracaoAtual = iteracaoAtual + 1;
            }
            else if (f(cDepois) * f(b) < 0) {
                erro = Math.abs(cDepois - a);
                a = cDepois;
                iteracaoAtual = iteracaoAtual + 1;
            }
            else {
                System.out.println("Algo deu ruim");
                return 0;
            }

        }

        System.out.println("O valor aproximado da raiz eh de " + cDepois);
        System.out.println("Foram feitas " + iteracaoAtual +  " iteracoes");
        System.out.println("Numero maximo de iteracoes: " + iteracoes);
        return 0;
    }


    // Cálculo da função em f(x)
    public static double f(double x) {
        double result = (x * x) + x - 6;
        return result;
    }

    // Cálculo do número de iterações necessárias
    public static double numIteracoes(double a, double b, double tol) {
        double difBA = b - a;
        double resultFracionado = Math.log(difBA / tol) / Math.log(2);
        return Math.ceil(resultFracionado);
    }
}