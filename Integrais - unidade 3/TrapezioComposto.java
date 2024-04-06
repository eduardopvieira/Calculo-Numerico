import java.util.Scanner;

public class TrapezioComposto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;
        System.out.println("Digite o valor de a: ");
        a = sc.nextDouble();
        System.out.println("Digite o valor de b: ");
        b = sc.nextDouble();
        sc.close();

        double n = b - a;
        double h = (b - a) / n;

        double soma = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            soma += 2 * f(a + i * h);
        }

        System.out.println("A área aproximada é: " + (h / 2) * soma);

    }

    public static double f(double x) {
        return -(x * x) + (3 * x);
    }
}
