import java.util.Random;
import java.util.Scanner;

public class Cholesky {
     public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
       
        // System.out.println("Digite o tamanho da matriz: ");
        // tamanho = sc.nextInt();
        double[][] matriz = {{1,2,3}, {4,5,6},{7,8,9}};
        printarMatriz(matrizTransposta(matriz));
        
        // double[][] matrizA = new double [tamanho][tamanho];
        // double[] matrizB = new double[tamanho];

        // System.out.println("1 - Digitar matriz manualmente");
        // System.out.println("2 - Gerar matriz aleatoriamente");
        // escolha = sc.nextInt();
        // if (escolha == 1) {
        //     matrizA = digitarMatrizSimetrica(tamanho, sc);
        // } else {
        //     matrizA = gerarMatrizSimetrica(tamanho);
        // }

        // System.out.println("1 - Digitar matriz B manualmente");
        // System.out.println("2 - Gerar matriz B aleatoriamente");

        // escolha = sc.nextInt();
        // if (escolha == 1) {
        //     matrizB = digitarMatrizB(tamanho, sc);
        // } else {
        //     matrizB = gerarMatrizB(tamanho);
        // }




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

    public static double[] gerarMatrizB(int tamanho) {
        
        double[] matriz = new double[tamanho];
        Random rand = new Random();

        for (int i = 0; i < tamanho; i++) {              
            matriz[i] = rand.nextInt(10)+1;
        }

        return matriz;
    }

    public static double[][] multiplicarMatrizes(int tamanho, double[][] matrizA, double[][] matrizB) {
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
}

