import java.util.Scanner;
import java.util.Random;

class DecomposicaoLU {

    public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();
        Double[][] matrizA = new Double[tamanho][tamanho];
        Double[] matrizB = new Double[tamanho];

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
        Double [][][]vetorMatrizes = dooLittle(matrizA);
        Double [][]L = vetorMatrizes[0];
        Double [][]U = vetorMatrizes[1];


        System.out.println("==================== L ==================");
        printarMatriz(L);

        System.out.println("==================== U ==================");
        printarMatriz(U);

        //Resolvendo L * Y = B, para descobrir o Y. A substituição direta eh parecida com a retroativa, a diferença eh que ela eh
        //própria para matrizes L (triangulares inferiores)
        Double[] Y = substituicaoDireta(L, matrizB);

        System.out.println("==================== Y ==================");
        printarMatriz(Y);

        //Resolvendo U * X = Y, para descobrir o X. Aqui é usada a substituição retroativa pq eh igual a direta, mas propria para
        //matrizes triangulares superiores
        Double[] X = substituicaoRetroativa(U, Y);

        System.out.println("==================== X ==================");
        printarMatriz(X);

        
        sc.close();
    }

//======================================MÉTODOS================================================


    public static Double[][] digitarMatriz(int tamanho, Scanner ler) {
        Double[][] matriz = new Double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("[%d][%d]: ", (i+1), (j+1));
                matriz[i][j] =  ler.nextDouble();
            }
        }
        return matriz;
    }

    public static Double[] digitarMatrizB(int tamanho, Scanner ler) {
        Double[] matrizB = new Double[tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            System.out.printf("[%d][1]: ", (i+1) );
            matrizB[i] = ler.nextDouble();
        }
        return matrizB;
    }


    public static void printarMatriz(Double[][] matriz) {

        
        int tamLinhas = matriz.length;
        int tamColunas = matriz[0].length;

        for (int i = 0; i < tamLinhas; i++) {
            for (int j = 0; j < tamColunas; j++) {
                System.out.printf(matriz[i][j] + " ");
            } System.out.println("");
        }
    }

    public static void printarMatriz(Double[] matriz) {
        
        int tamLinhas = matriz.length;

        for (int i = 0; i < tamLinhas; i++) {
            System.out.println(matriz[i] + " ");
        }
    }


    public static Double[][] gerarMatriz(int tamanho) {
        
        Double[][] matriz = new Double[tamanho][tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {                
                matriz[i][j] = rand.nextDouble(10)+1;
                
            }
        }
        return matriz;
    }

    public static Double[] gerarMatrizB(int tamanho) {
        
        Double[] matriz = new Double[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {              
            matriz[i] = rand.nextDouble(10)+1;
        }

        return matriz;
    }

    public static Double[][][] dooLittle(Double[][] matriz) {
        int n = matriz.length;
        Double[][] L = new Double[n][n];
        Double[][] U = new Double[n][n];

        for (int i = 0; i < n; i++) {
            // Calculando a matriz U
            for (int k = i; k < n; k++) {
                Double soma = 0.0;
                for (int j = 0; j < i; j++) {
                    soma += L[i][j] * U[j][k];
                }
                U[i][k] = matriz[i][k] - soma;
            }

            // Calculando a matriz L
            for (int k = i; k < n; k++) {
                if (i == k) {
                    L[i][i] = 1.0; // Diagonal principal de L é 1
                } else {
                    Double soma = 0.0;
                    for (int j = 0; j < i; j++) {
                        soma += L[k][j] * U[j][i];
                    }
                    L[k][i] = (matriz[k][i] - soma) / U[i][i];
                }
            }
        }
        return new Double[][][]{L, U};
    }

    public static Double[] substituicaoDireta(Double[][] matrizL, Double[] b) {
        int n = matrizL.length;
        Double[] y = new Double[n];
    
        y[0] = b[0] / matrizL[0][0];
    
        for (int i = 1; i < n; i++) {
            Double soma = 0.0;
            for (int j = 0; j < i; j++) {
                soma += matrizL[i][j] * y[j];
            }
            y[i] = (b[i] - soma) / matrizL[i][i];
        }
    
        return y;
    }
//Substituicao retroativa adaptado para matrizes regulares inferiores. Testar.
    public static Double[] substituicaoRetroativa(Double[][] matrizU, Double[] b) {
        int n = matrizU.length;
        Double[] x = new Double[n];

        x[n - 1] = b[n - 1] / matrizU[n - 1][n - 1];

        for (int i = n - 2; i >= 0; i--) {
            Double soma = 0.0;
            for (int j = i + 1; j < n; j++) {
                soma += matrizU[i][j] * x[j];
            }
            x[i] = (b[i] - soma) / matrizU[i][i];
        }

        return x;
    }

    public static Double[] substituicaoRetroativaLower(Double[][] matrizL, Double[] b) {
        int n = matrizL.length;
        Double[] x = new Double[n];

        x[0] = b[0] / matrizL[0][0];

        for (int i = 1; i < n; i++) {
            Double soma = 0.0;
            for (int j = 0; j < i; j++) {
                soma += matrizL[i][j] * x[j];
            }
            x[i] = (b[i] - soma) / matrizL[i][i];
        }
        return x;
    }


}