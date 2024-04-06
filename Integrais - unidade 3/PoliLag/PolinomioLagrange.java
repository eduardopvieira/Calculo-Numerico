package PoliLag;
import java.util.Scanner;

public class PolinomioLagrange {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a ordem do polinomio?");
        int ordem = sc.nextInt();
        Coordenada[] valores = new Coordenada[ordem];
        for (int i = 0; i < ordem; i++) {
            System.out.println("Digite o X do " + (i + 1) + "° valor: ");
            double xProv = sc.nextDouble();
            System.out.println("Digite o Y do " + (i + 1) + "° valor: ");
            double yProv = sc.nextDouble();
            valores[i] = new Coordenada(xProv, yProv);
        }

        System.out.print("Digite o valor de x para interpolação: ");
        double xInterpolacao = sc.nextDouble();

        // Cálculo do polinômio interpolador de Lagrange
        double polinomioInterpolador = 0;
        for (int i = 0; i < ordem; i++) {
            double produto = 1;
            for (int j = 0; j < ordem; j++) {
                if (i != j) {
                    produto *= (xInterpolacao - valores[j].getX()) / (valores[i].getX() - valores[j].getX());
                }
            }
            polinomioInterpolador += produto * valores[i].getY();
        }

        // Impressão do resultado
        System.out.println("O valor interpolado para x = " + xInterpolacao + " é: " + polinomioInterpolador);
    }
}

