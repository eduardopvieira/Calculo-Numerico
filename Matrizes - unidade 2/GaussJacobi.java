import java.lang.Math;

public class GaussJacobi {
    public static void main(String[] args) {
        
        //Matriz principal
        Double[][] matrizA =
                {{10.0, 2.0, 1.0},
                {1.0, 5.0, 1.0},
                {2.0, 3.0, 10.0}};

        //Matriz auxiliar
        Double[][] matrizX =
                {{0.0},
                {0.0},
                {0.0}};

        //Matriz do =
        Double[][] matrizB =
                {{7.0},
                {-8.0},
                {6.0}};

        //Matriz do Chute
        Double[][] matrizXi =
                {{0.0},
                {0.0},
                {0.0}};

        //erro
        Double e = 0.05;

        Double d = e + 1;
        
        //numero inicial de iteracao (nao alterar)
        int k = 0;

        
        if (diagonalDominante(matrizA) == false) {

            System.out.println("Sua matriz não é diagonal dominante, logo não é aplicável nesse método, "
                    + "escolha outro método ou insira outra matrizA.");

        } else {
            while (d > e) {
                k++;

                if (k != 1) {
                    for (int i = 0; i < matrizX.length; i++) {
                        matrizXi[i][0] = matrizX[i][0];
                    }
                }


                //Calcula X

                for (int i = 0; i < matrizA.length; i++) {
                    matrizX[i][0] = (matrizB[i][0] - (calculaSubtracao(matrizA, matrizXi, i)))/matrizA[i][i];
                }

                // Crit de parada

                d = normaMax(matrizX, matrizXi)/normaMax(matrizX);

                System.out.println("iteração " + k + ": ");
                DecomposicaoLU.printarMatriz(matrizX);
                System.out.println();
            }
        }
    }

    public static Double calculaSubtracao(Double[][] matrizA, Double[][] matrizX, int i) {
        Double sub = 0d;

        for(int k = 0; k < matrizA.length; k++) {
            if (k != i){
                sub = sub + (matrizA[i][k] * matrizX[k][0]);
            }
        }

        return sub;
    }

    public static Double normaMax(Double[][] matriz) {
        Double max = matriz[0][0];
        Double control = 0d;

        for (int i = 1; i < matriz.length; i++) {
            control = matriz[i][0];

            if (control > max) {
                max = control;
            }
        }

        return max;
    }

    public static Double normaMax(Double[][] matrizX, Double[][] matrizXi) {
        Double control = 0d;
        Double max = Math.abs(matrizX[0][0] - matrizXi[0][0]);

        for (int i = 1; i < matrizX.length; i++) {
            control = Math.abs(matrizX[i][0] - matrizXi[i][0]);

            if (control > max) {
                max = control;
            }
        }

        return max;
    }

    public static boolean diagonalDominante(Double[][] matriz) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int i = 0; i < linhas; i++) {
            Double soma = 0.0;
            for (int j = 0; j < colunas; j++) {
                soma = matriz[i][j] + soma;
            }
            soma = soma - matriz[i][i];
            if (matriz[i][i] < soma) {
                return false;
            }
        }
        return true;
    }
}
