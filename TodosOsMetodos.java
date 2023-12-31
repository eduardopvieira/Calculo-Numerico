import java.util.Scanner;

class TodosOsMetodos {
    public static void main(String[] args) {
        double tol = 0.0001; // tolerancia
        double a = -1; // primeiro ponto do intervalo
        double b = 100; // segundo ponto do intervalo
        double iteracoes = numIteracoes(a, b, tol);
        int iteracaoAtual = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual método deseja utilizar? \n1 - Bissecção \n2 - Falsa Posição \n");
        int metodo = sc.nextInt();
        sc.close();
        double result;

        switch (metodo) {
            case 1:
                System.out.println("Usando a bissecção.");
                System.out.println("Número máximo de iterações: " + iteracoes);
                result = bisseccao(a, b, tol, iteracoes, iteracaoAtual);
                System.out.println("Raiz aproximada: " + result);
                break;
            case 2:
                System.out.println("Usando a falsa posição.");
                System.out.println("Número máximo de iterações: " + iteracoes);
                result = falsaPosicao(a, b, tol, iteracoes, iteracaoAtual);
                System.out.println("Raiz aproximada: " + result);
                break;
            default:
                break;
        }
    }

    public static double f(double x) {
        return x * x + x - 6; // A função escolhida deve ser alterada diretamente aqui.
    }


    //Limitador do numero de iterações segundo a fórmula.
    public static double numIteracoes(double a, double b, double tol) {
        double difBA = b - a;
        return Math.ceil(Math.log(difBA / tol) / Math.log(2));
    }

    public static double bisseccao(double a, double b, double tol, double iteracoes, double iteracaoAtual) {
        
        //Limitador de iterações:
        if (iteracaoAtual >= iteracoes) {
            System.out.println("Limite de iteracoes atingido. Nenhuma raiz encontrada.");
            return 0;
        }

        double c = (a + b) / 2;
        double fc = f(c); 

        if (Math.abs(fc) < tol)    { //Se o módulo de f(c) for menor que a tolerância, quer dizer que 'c' é a raiz, e o retorna.
            System.out.println("Número de iterações: " + iteracaoAtual);
            return c;
        } else if (fc * f(a) < 0) { //Caso f(c) * f(a) continue a dar menor que 0, significa que a raiz existe dentro do intervalo, mas ainda não foi encontrada.
            iteracaoAtual = iteracaoAtual + 1;        //Então, o contador de iterações é incrementado e a função é chamada novamente.
            //System.out.println(iteracaoAtual);
            return bisseccao(a, c, tol, iteracoes, iteracaoAtual);
        } else {
            iteracaoAtual = iteracaoAtual + 1;        //Então, o contador de iterações é incrementado e a função é chamada novamente.
            //System.out.println(iteracaoAtual);
            return bisseccao(b, c, tol, iteracoes, iteracaoAtual);
        }
    }

    public static double falsaPosicao(double a, double b, double tol, double iteracoes, int iteracaoAtual) {
        // Limitador de iterações:
        if (iteracaoAtual >= iteracoes) {
            System.out.println("Limite de iterações atingido. Nenhuma raiz encontrada.");
            return 0;
        }

        double c = a - (((b - a) * f(a)) / (f(b) - f(a)));
        double fc = f(c);

        if (Math.abs(fc) < tol) {
            System.out.println("Número de iterações: " + iteracaoAtual);
            return c;
        } else if (fc * f(a) < 0) {
            iteracaoAtual++;
            return falsaPosicao(a, c, tol, iteracoes, iteracaoAtual);
        } else {
            iteracaoAtual++;
            return falsaPosicao(b, c, tol, iteracoes, iteracaoAtual);
        }
    }
}
