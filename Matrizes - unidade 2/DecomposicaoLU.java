import java.util.Scanner;
import java.util.Random;

class DecomposicaoLU {

    public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();
        double matriz[][] = new double [tamanho][tamanho];

        System.out.println("1 - Digitar matriz manualmente");
        System.out.println("2 - Gerar matriz aleatoriamente");
        escolha = sc.nextInt();
        if (escolha == 1) {
            matriz = digitarMatriz(tamanho, sc);
        } else {
            matriz = gerarMatriz(tamanho);
        }

        
        System.out.println("Matriz original: ");
        printarMatriz(matriz);
        double[][] matrizLower = gerarLower(matriz, tamanho);
        double[][] matrizUpper = gerarUpper(matriz, tamanho);
        System.out.println("Matriz Triangular Inferior: ");
        printarMatriz(matrizLower);
        System.out.println("Matriz Triangular Superior: ");
        printarMatriz(matrizUpper);

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
        ler.close();
        return matriz;
    }


    public static void printarMatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf(matriz[i][j] + " ");
            } System.out.println("");
        }
    }


    public static double[][] gerarMatriz(int tamanho) {
        
        double[][] matriz = new double[tamanho][tamanho];
        Random rand = new Random();
        
        //Gerando valores aleatorios pra matriz:
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {                
                matriz[i][j] = rand.nextInt(10)+1;
            }
        }
        return matriz;
    }

    public static double[][] gerarLower(double matrizOriginal[][], int tamanho) {
        double[][] matrizNova = new double[tamanho][tamanho];
        
        for (int linhas = 0; linhas < tamanho; linhas++) {
            for (int colunas = 0; colunas < tamanho; colunas++) {
                if (linhas >= colunas) {
                    matrizNova[linhas][colunas] = matrizOriginal[linhas][colunas];
                } else {
                    matrizNova[linhas][colunas] = 0;
                }
            }
        }

        return matrizNova;
    }

    public static double[][] gerarUpper(double matrizOriginal[][], int tamanho) {
        double[][] matrizNova = new double[tamanho][tamanho];
        
        for (int linhas = 0; linhas < tamanho; linhas++) {
            for (int colunas = 0; colunas < tamanho; colunas++) {
                if (linhas < colunas) {
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
}