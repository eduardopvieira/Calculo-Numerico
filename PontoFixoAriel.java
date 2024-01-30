import java.util.Scanner;

public class PontoFixoAriel {

    public static double funcao(double x) {
        return Math.pow(x, 3) + 12 * Math.pow(x, 2) - 9;
    }

    public static double g(double x) {
        return Math.cbrt(-12 * Math.pow(x, 2) + 9);
    }

    public static void pontoFixo(double xInicial, double erro, int maxIter) {
        double xIterativo, xTemporario;
        boolean temResultado = false;

        for (int i = 1; i <= maxIter; ++i) {
            xIterativo = g(xInicial);
            xTemporario = xInicial;

            if (Math.abs(funcao(xIterativo)) < erro || Math.abs(xIterativo - xTemporario) < erro) {
                System.out.println("O resultado é " + xIterativo + " e foi encontrado com " + i + " iterações");
                temResultado = true;
                break;
            } else {
                xInicial = xIterativo;
            }
        }

        if (!temResultado)
            System.out.println("O programa não encontrou raízes em até " + maxIter + " iterações");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double erro, xInicial;

        System.out.print("Digite a precisão E: ");
        erro = scanner.nextDouble();
        System.out.print("Digite o chute inicial: ");
        xInicial = scanner.nextDouble();

        scanner.close();

        pontoFixo(xInicial, erro, 1000); // 1000 iterações como exemplo, ajuste conforme necessário
    }
}
