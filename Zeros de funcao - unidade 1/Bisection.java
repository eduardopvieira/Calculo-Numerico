class Bisection {
    public static void main(String[] args) {
        double tol = 0.0001; //tolerancia
        double a = 0; //primeiro ponto do intervalo
        double b = 2; //segundo ponto do intervalo
        double iteracoes = numIteracoes(a, b, tol);
        int iteracaoAtual = 0;

        System.out.println("Número máximo de iteracoes: " + iteracoes);  //verificar o número de iterações retornado pelo código
        double result = bisseccao(a, b, tol, iteracoes, iteracaoAtual);
        System.out.println("Raiz aproximada: " + result);
        
    }

    public static double bisseccao(double a, double b, double tol, double iteracoes, double iteracaoAtual) {
        
        //Limitador de iterações:
        if (iteracaoAtual >= iteracoes) {
            System.out.println("Limite de iteracoes atingido. Nenhuma raiz encontrada.");
            return 0;
        }

        double c = (a + b) / 2;
        double fc = f(c); 

        System.out.println("C: " + c + " | Iteração atual: " + (iteracaoAtual + 1));
        if (Math.abs(fc) < tol)    { //Se o módulo de f(c) for menor que a tolerância, quer dizer que 'c' é a raiz, e o retorna.
            System.out.println("Número de iterações: " + (iteracaoAtual+1));
            return c;
        } else if (fc * f(a) < 0) { //Caso f(c) * f(a) continue a dar menor que 0, significa que a raiz existe dentro do intervalo, mas ainda não foi encontrada.
            iteracaoAtual = iteracaoAtual + 1;        //Então, o contador de iterações é incrementado e a função é chamada novamente.
            //System.out.println(iteracaoAtual);
            return bisseccao(a, c, tol, iteracoes, iteracaoAtual);
        } else {
            iteracaoAtual = iteracaoAtual + 1;        //Senão, o contador de iterações é incrementado e a função é chamada novamente.
            //System.out.println(iteracaoAtual);
            return bisseccao(b, c, tol, iteracoes, iteracaoAtual); //Dessa vez, será retornado pra bisseccao o valor de b, que será o novo a.
        }
    }

    //Cálculo da função em f(x)
    public static double f(double x) {
        double var = 2*x;
        double func = 2 * Math.cos(x) - Math.pow(Math.E, var); //A função escolhida deve ser alterada diretamente aqui.
        return func;
    }


    //Cálculo do número de iterações necessárias
    public static double numIteracoes(double a, double b, double tol) {
        double difBA = b - a;
        double resultFracionado = Math.log(difBA / tol) / Math.log(2); //Mesmo que Math.log(DifBA) - Math.log(tol) / Math.log(2)
        return Math.ceil(resultFracionado);
    }

}
