import java.util.Scanner;
import java.util.Random;

class DecomposicaoLU {

    public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();
        double[][] matrizA = new double [tamanho][tamanho];
        double[] matrizB = new double[tamanho];

        System.out.println("1 - Digitar matriz manualmente");
        System.out.println("2 - Gerar matriz aleatoriamente");
        escolha = sc.nextInt();
        if (escolha == 1) {
            matrizA = digitarMatriz(tamanho, sc);
        } else {
            matrizA = gerarMatriz(tamanho);
        }

        System.out.println("1 - Digitar matriz B manualmente");
        System.out.println("2 - Gerar matriz B aleatoriamente");
        escolha = sc.nextInt();
        if (escolha == 1) {
            matrizB = digitarMatrizB(tamanho, sc);
        } else {
            matrizB = gerarMatrizB(tamanho);
        }

        
        System.out.println("========== Matriz Original: ==========");
        printarMatriz(matrizA);

        //Criando as Matrizes L e U a partir da matriz original
        double [][][]vetorMatrizes = dooLittle(matrizA);
        double [][]L = vetorMatrizes[0];
        double [][]U = vetorMatrizes[1];


        System.out.println("==================== L ==================");
        printarMatriz(L);

        System.out.println("==================== U ==================");
        printarMatriz(U);

        //Resolvendo L * Y = B, para descobrir o Y. A substituição direta eh parecida com a retroativa, a diferença eh que ela eh
        //própria para matrizes L (triangulares inferiores)
        double[] Y = substituicaoDireta(L, matrizB);

        System.out.println("==================== Y ==================");
        printarMatriz(Y);

        //Resolvendo U * X = Y, para descobrir o X. Aqui é usada a substituição retroativa pq eh igual a direta, mas propria para
        //matrizes triangulares superiores
        double[] X = substituicaoRetroativa(U, Y);

        System.out.println("==================== X ==================");
        printarMatriz(X);

        
        sc.close();
    }

//======================================MÉTODOS================================================


    public static double[][] digitarMatriz(int tamanho, Scanner ler) {
        double[][] matriz = new double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("[%d][%d]: ", (i+1), (j+1));
                matriz[i][j] =  ler.nextInt();
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
                System.out.printf(matriz[i][j] + " ");
            } System.out.println("");
        }
    }

    public static void printarMatriz(double[] matriz) {
        
        int tamLinhas = matriz.length;

        for (int i = 0; i < tamLinhas; i++) {
            System.out.println(matriz[i] + " ");
        }
    }


    public static double[][] gerarMatriz(int tamanho) {
        
        double[][] matriz = new double[tamanho][tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {                
                matriz[i][j] = rand.nextInt(10)+1;
                
            }
        }
        return matriz;
    }

    public static double[] gerarMatrizB(int tamanho) {
        
        double[] matriz = new double[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {              
            matriz[i] = rand.nextInt(10)+1;
        }

        return matriz;
    }    

    public static double[][][] dooLittle(double[][] matriz) {
        int n = matriz.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            // Calculando a matriz U
            for (int k = i; k < n; k++) {
                double soma = 0.0;
                for (int j = 0; j < i; j++) {
                    soma += L[i][j] * U[j][k];
                }
                U[i][k] = matriz[i][k] - soma;
            }

            // Calculando a matriz L
            for (int k = i; k < n; k++) {
                if (i == k) {
                    L[i][i] = 1; // Diagonal principal de L é 1
                } else {
                    double soma = 0.0;
                    for (int j = 0; j < i; j++) {
                        soma += L[k][j] * U[j][i];
                    }
                    L[k][i] = (matriz[k][i] - soma) / U[i][i];
                }
            }
        }
        return new double[][][]{L, U};
    }

    public static double[] substituicaoDireta(double[][] matrizL, double[] b) {
        int n = matrizL.length;
        double[] y = new double[n];
    
        y[0] = b[0] / matrizL[0][0];
    
        for (int i = 1; i < n; i++) {
            double soma = 0.0;
            for (int j = 0; j < i; j++) {
                soma += matrizL[i][j] * y[j];
            }
            y[i] = (b[i] - soma) / matrizL[i][i];
        }
    
        return y;
    }

    public static double[] substituicaoRetroativa(double[][] matrizU, double[] b) {
        int n = matrizU.length;
        double[] x = new double[n];

        x[n - 1] = b[n - 1] / matrizU[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            double soma = 0.0;
            for (int j = i + 1; j < n; j++) {
                soma += matrizU[i][j] * x[j];
            }
            x[i] = (b[i] - soma) / matrizU[i][i];
        }

        return x;
    }
}