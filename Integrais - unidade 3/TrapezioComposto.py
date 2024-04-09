def f(x):
    return -(2*x) - 3

def trapezio_composto(a, b, n):
    h = (b - a) / n
    soma = f(a) + f(b)
    for i in range(1, n):
        soma += 2 * f(a + i * h)
    return (h / 2) * soma

def main():
    a = float(input("Digite o valor de a: "))
    b = float(input("Digite o valor de b: "))
    n = int(input("Digite o valor de n: "))

    area_aproximada = trapezio_composto(a, b, n)
    print("A área aproximada é:", area_aproximada)

if __name__ == "__main__":
    main()
