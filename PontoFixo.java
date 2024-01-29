public class PontoFixo {

    public static void main(String[] args) {
        double intervaloEsquerdo = -0.9;
        double intervaloDireito = 1;
        int limiteIteracoes = 1000;
        double tolerancia = 0.001;
        double x0 = 0.3;
        
        if (verificaIntervalo(intervaloEsquerdo, intervaloDireito) == true) {  //Verifica se f(a) * f(b) < 0
            MetodoPontoFixo(x0, limiteIteracoes, tolerancia);   //Se sim, faz o método
        } else {
            System.out.println("Não há raiz no intervalo"); //Se não, não há raiz no intervalo
        }          
    }

//================================Função de verificação se f(a) * f(b) < 0================================
    public static boolean verificaIntervalo(double a, double b) {
        if (f(a) * f(b) < 0) {
            return true;
        } else {
            return false;
        }
    }

//============================================Função f(x)=================================================

    public static double f(double x) {
        double valor = (x * x * x) - (12 * x * x) - 9;
        return valor;
    }

//==============================Função g(x) (Deve ser a função isolada)====================================

    public static double g(double x) {
        double valor = (Math.cbrt((12 * x * x) + 9));
        return valor;
    }

//================================================Método===================================================
    public static void MetodoPontoFixo(double x0, int limiteIteracoes, double tolerancia) {
            double x1 = x0; //Define um x1 igual ao x0
            double x2 = 0; //X2 zerado
            int iteracoes = 0; //contador para iteracoes
            double erro = 0; //erro (diferença entre x1 e x2)

            do {
                x2 = g(x1); //X2 recebe o valor de g(x1)
                erro = Math.abs(x2 - x1); //Erro recebe o valor absoluto da diferença entre x1 e x2
                System.out.println("ERRO: " + erro + " | X1: " + x1 + " | X2: " + x2); //Printa o erro, x1 e x2 para cada iteracao
                x1 = x2; //Atribui x2 a x1
                iteracoes++;
            } while (iteracoes < limiteIteracoes && erro > tolerancia); //Continua enquanto a iteracao atual for menor que o limite de iteracoes 
                                                                        //e a diferença entre x2 e x1 for maior que a tolerancia

            System.out.println("Raiz: " + x2);
            System.out.println("Iterações: " + iteracoes);
            System.out.println("Erro: " + erro);
    }
}
