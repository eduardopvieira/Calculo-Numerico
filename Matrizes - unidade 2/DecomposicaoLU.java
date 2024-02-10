import java.util.Scanner;
import java.util.Random;

class DecomposicaoLU {

    public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();
        double[][] matriz = new double [tamanho][tamanho];
        double[][] matrizX = definirMatrizX(tamanho);


        System.out.println("1 - Digitar matriz manualmente");
        System.out.println("2 - Gerar matriz aleatoriamente");
        escolha = sc.nextInt();
        if (escolha == 1) {
            matriz = digitarMatriz(tamanho, sc);
        } else {
            matriz = gerarMatriz(tamanho);
        }

        
        System.out.println("========== Matriz Original: ==========");
        printarMatriz(matriz);
        
        double[][] matrizLower = gerarLower(matriz, tamanho);
        System.out.println("========== Matriz Triangular Inferior: ==========");
        printarMatriz(matrizLower);

        double[][] matrizUpper = gerarUpper(matriz, tamanho);
        System.out.println("========== Matriz Triangular Superior: ==========");
        printarMatriz(matrizUpper);
        
        System.out.println("========== Matriz Multiplicada: ========== ");
        double[][] LxU = multiplicarMatrizes(matrizLower, matrizUpper);
        printarMatriz(LxU);

        double[] b = acharMatrizNx1(matrizUpper, matrizX);
        System.out.println("========== b (a partir da LxU): ========== ");
        printarMatriz(b);

        //Resolvendo L * Y = b (ja sei quem são L e b, mas nao sei quem é Y)
        double[] Y = solucionarSistemaLinear(matrizLower, b);
        System.out.println("========== Y: ========== ");
        printarMatriz(Y);

        //Resolvendo U * X = Y (ja sei quem são U e Y, mas nao sei quem é X)
        double[] X = solucionarSistemaLinear(matrizUpper, Y);
        System.out.println("========== X: ========== ");
        printarMatriz(X);

        sc.close();
    }

//======================================MÉTODOS================================================


    public static double[][] digitarMatriz(int tamanho, Scanner ler) {
        double[][] matriz = new double[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("[%d][%d]: ", i, j);
                matriz[i][j] =  ler.nextInt();
            }
        }
        return matriz;
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

    public static double[][] definirMatrizX(int tamanho) {
        
        double[][] matriz = new double[tamanho][1];
        double valor = 10;

        for (int i = 0; i < tamanho; i++) {           
                matriz[i][0] = valor;
                valor += 10;     
        }
        return matriz;
    }

    public static double[][] gerarLower(double[][] matrizOriginal, int tamanho) {
        double[][] matrizNova = new double[tamanho][tamanho];
        
        for (int linhas = 0; linhas < tamanho; linhas++) {
            for (int colunas = 0; colunas < tamanho; colunas++) {
                if (linhas > colunas) {
                    matrizNova[linhas][colunas] = matrizOriginal[linhas][colunas];
                } else if (linhas == colunas) {
                    matrizNova[linhas][colunas] = 1;
                } else {
                    matrizNova[linhas][colunas] = 0;
                }
            }
        }

        return matrizNova;
    }

    public static double[][] gerarUpper(double[][] matrizOriginal, int tamanho) {
        double[][] matrizNova = new double[tamanho][tamanho];
        
        for (int linhas = 0; linhas < tamanho; linhas++) {
            for (int colunas = 0; colunas < tamanho; colunas++) {
                if (linhas <= colunas) {
                    matrizNova[linhas][colunas] = matrizOriginal[linhas][colunas];
                } else {
                    matrizNova[linhas][colunas] = 0;
                }
            }
        }
        return matrizNova;
    }



    public static double[][] multiplicarMatrizes(double[][] matrizA, double[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int colunasB = matrizB[0].length;
        
        double matrizRetorno[][] = new double[linhasA][colunasB];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    matrizRetorno[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return matrizRetorno;
    }

    public static double[] acharMatrizNx1(double[][] matrizA, double[][] matrizB) {
        int linhasA = matrizA.length;
        int colunasA = matrizA[0].length;
        int colunasB = matrizB[0].length;
        
        double matrizRetorno[] = new double[linhasA];

        for (int i = 0; i < linhasA; i++) {
            for (int j = 0; j < colunasB; j++) {
                for (int k = 0; k < colunasA; k++) {
                    matrizRetorno[i] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return matrizRetorno;
    }

    public static double[] solucionarSistemaLinear(double[][] A, double[] b) {
        
        int tamanho = A.length;
        double[] Y = new double[tamanho];

        // Eliminação de Gauss
        for (int i = 0; i < tamanho; i++) {
            // Encontre o pivô
            double pivo = A[i][i];

            // Faça a linha do pivô ter o valor 1
            for (int j = i; j < tamanho; j++) {
                A[i][j] /= pivo;
            }
            b[i] /= pivo;

            // Zere os elementos abaixo do pivô
            for (int k = i + 1; k < tamanho; k++) {
                double fator = A[k][i];
                for (int j = i; j < tamanho; j++) {
                    A[k][j] -= fator * A[i][j];
                }
                b[k] -= fator * b[i];
            }
        }

        // Substituição retroativa para encontrar Y
        for (int i = tamanho - 1; i >= 0; i--) {
            Y[i] = b[i];
            for (int j = i + 1; j < tamanho; j++) {
                Y[i] -= A[i][j] * Y[j];
            }
        }

        return Y;
    }
}