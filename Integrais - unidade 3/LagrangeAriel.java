public class LagrangeAriel {
    public static void main(String[] args) {
        int pontos = 4;
        double[] x = {0, 1, 2, 3};
        double[] Fx = new double[pontos];

        Fx[0] = 1;
        Fx[1] = 2;
        Fx[2] = 4;
        Fx[3] = 8;

            System.out.println("\nA fórmula de interpolação de Lagrange é:");
            for (int i = 0; i < pontos; i++) {
                StringBuilder polinomio = new StringBuilder();
                for (int j = 0; j < pontos; j++) {
                    if (i != j) {
                        polinomio.append("(x - ").append(x[j]).append(")/(").append(x[i]).append(" - ").append(x[j]).append(")");
                    }
                }
                System.out.println("f(x) = " + Fx[i] + " * " + polinomio);
            }

            double x0= 1.5;


            double resultado = calcularInterpolacaoLagrange(x0, x, Fx);
            System.out.println("\nO valor da função interpolada em x = " + x0 + " é " + resultado);
        }

        public static double calcularInterpolacaoLagrange(double x0, double[] x, double[] Fx) {
            double resultado = 0;
            int n = x.length;
            for (int i = 0; i < n; i++) {
                double termo = 1;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        termo *= (x0 - x[j]) / (x[i] - x[j]);
                    }
                }
                resultado += Fx[i] * termo;
            }
            return resultado;
        }
    }