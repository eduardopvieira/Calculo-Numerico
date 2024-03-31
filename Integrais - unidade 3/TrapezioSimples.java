import java.util.Scanner;

class TrapezioSimples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a, b;
        System.out.println("Digite o valor de a: ");
        a = sc.nextDouble();
        System.out.println("Digite o valor de b: ");
        b = sc.nextDouble();
        double h = b - a;
        double formula = (h / 2) * (f(a) + f(b));
        System.out.println("A área aproximada é: " + formula);
        sc.close();

    }

    public static double f(double x) {
        return (x * x) + (3 * x) + 2;
    }
}