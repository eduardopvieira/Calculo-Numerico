import java.util.Scanner;
import java.util.Random;

class EscalonamentoMatriz {

    public static void main(String[] args) {
        int tamanho, escolha;
        Scanner sc = new Scanner(System.in);
        

        System.out.println("Digite o tamanho da matriz: ");
        tamanho = sc.nextInt();
        int matriz[][] = new int [tamanho][tamanho];

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
        int matrizEscalonada[][] = escalonar(matriz);
        System.out.println("Matriz original escalonada: ");
        printarMatriz(matrizEscalonada);

        sc.close();
    }

//======================================MÉTODOS================================================


    public static int[][] digitarMatriz(int tamanho, Scanner ler) {
        int[][] matriz = new int[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf("[%d][%d]: ", i, j);
                matriz[i][j] =  ler.nextInt();
            }
        }
        ler.close();
        return matriz;
    }


    public static void printarMatriz(int matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf(matriz[i][j] + " ");
            } System.out.println("");
        }
    }


    public static int[][] gerarMatriz(int tamanho) {
        
        int[][] matriz = new int[tamanho][tamanho];
        Random rand = new Random();
        
        //Gerando valores aleatorios pra matriz:
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {                
                matriz[i][j] = rand.nextInt(10)+1;
            }
        }
        return matriz;
    }


    public static int[][] escalonar(int matriz[][]) {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        for (int i = 0; i < linhas; i++) {
            // Procurando o primeiro elemento não nulo abaixo de (i, i)
            for (int j = i + 1; j < linhas; j++) {
                // Se o elemento é zero, não precisa fzr nada pq ja ta zerado
                if (matriz[i][i] == 0)
                    continue;

                // Calculando o fator para escalonamento
                double fator = matriz[j][i] / matriz[i][i];

                // Reduzindo a linha j
                for (int k = i; k < colunas; k++) {
                    matriz[j][k] -= fator * matriz[i][k];
                }
            }
        }
        return matriz;
    }   
}