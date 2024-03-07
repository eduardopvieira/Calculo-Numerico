import java.util.Random;
import java.util.Scanner;

//Condições: A = Q * Qtransposta
//'A' deve ser uma matriz simétrica, portanto, A = Atransposta

public class Cholesky {
     public static void main(String[] args) {
        int tamanho;
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();

        double matrizOriginal[][] = new double[tamanho][tamanho];

        System.out.println("Digite sua matriz: ");
        matrizOriginal = digitarMatrizSimetrica(tamanho, sc);


        double[][] Q = new double[tamanho][tamanho];
        Q = cholesky(matrizOriginal);

         System.out.println("=========== MATRIZ ORIGINAL ===========");
         printarMatriz(matrizOriginal);

         System.out.println("=========== MATRIZ L PÓS CHOLESKY ===========");
         printarMatriz(Q);

         System.out.println("=========== MATRIZ L TRANSPOSTA ==========");
         double[][] Qtransposta = matrizTransposta(Q);
         printarMatriz(Qtransposta);

         System.out.println("========== L * L TRANSPOSTA (É PRA SER IGUAL A ORIGINAL) ===========");
         System.out.println("metodo de multiplicacao ta dando errado kekw ver dps (MAS O CHOLESKY TA CERTO E A TRANSPOSTA TB)");
         double[][] resultado = multiplicarMatrizes(Q, Qtransposta);
         printarMatriz(resultado);

    }

    //=========================Métodos=======================
    
    public static double[][] digitarMatrizSimetrica(int tamanho, Scanner ler) {
        double[][] matriz = new double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("[%d][%d]: ", (i+1), (j+1));
                matriz[i][j] =  ler.nextDouble();
                matriz[j][i] = matriz [i][j];
            }
        }
        return matriz;
    }

    public static double[] digitarMatrizB(int tamanho, Scanner ler) {
        double[] matrizB = new double[tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("[%d][1]: ", (i+1) );
            matrizB[i] = ler.nextDouble();
        }
        return matrizB;
    }


    public static void printarMatriz(double[][] matriz) {
        
        int tamLinhas = matriz.length;
        int tamColunas = matriz[0].length;

        for (int i = 0; i < tamLinhas; i++) {
            for (int j = 0; j < tamColunas; j++) {
                System.out.printf(" [%f] ",(matriz[i][j]));
            } System.out.println("");
        }
    }

    public static void printarMatriz(double[] matriz) {
        
        int tamLinhas = matriz.length;

        for (int i = 0; i < tamLinhas; i++) {
            System.out.println(matriz[i] + " ");
        }
    }


    public static double[][] gerarMatrizSimetrica(int tamanho) {
        
        double[][] matriz = new double[tamanho][tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j <= i; j++) {                
                matriz[i][j] = rand.nextInt(10)+1;
                matriz[j][i] = matriz[i][j];
            }
        }
        return matriz;
    }

    public static double[][] multiplicarMatrizes(double[][] matrizA, double[][] matrizB) {
        int tamanho = matrizA.length;
         double[][] matrizResultado = new double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                for (int k = 0; k < tamanho; k++) {
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }
        return matrizResultado;
    }

    public static double[][] matrizTransposta(double[][] matriz) {
        int tamanho = matriz.length;

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j <= i; j++) {
                double pivo = matriz[j][i];
                matriz[j][i] = matriz [i][j];
                matriz[i][j] = pivo;
            }
        }
        return matriz;
    }
    //Método feito a partir do livro "Cálculo Numerico - Aspectos teóricos e computacionais. Ruggiero, Marcio 2ed."
    public static double[][] cholesky(double[][] matriz) {
        int tamanho = matriz.length;
        double[][] L = new double[tamanho][tamanho];


        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j <= i; j++) {
                double soma = 0;
                if (j == i) {
                    for (int k = 0; k < j; k++) {
                        soma += Math.pow(L[j][k], 2);
                    }
                    L[j][i] = Math.sqrt(matriz[j][j] - soma);
                } else {
                    for (int k = 0; k < j; k++) {
                        soma += (L[i][k] * L[j][k]);
                    }
                    L[i][j] = (matriz[i][j] - soma) / L[j][j];
                }
            }
        }
        return L;
    }
}

