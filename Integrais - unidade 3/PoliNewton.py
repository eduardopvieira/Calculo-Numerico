def divided_differences(points):
    
    n = len(points)
    f = [[0] * n for _ in range(n)]

    # Copy y values to the first column of the table
    for i in range(n):
        f[i][0] = points[i][1]

    # Calculate divided differences
    for j in range(1, n):
        for i in range(n - j):
            f[i][j] = (f[i + 1][j - 1] - f[i][j - 1]) / (points[i + j][0] - points[i][0])

    return [f[0][i] for i in range(n)]

def newton_polynomial(points):
    differences = divided_differences(points)

    def P(x):
        result = differences[0]
        n = len(points)
        for i in range(1, n):
            term = differences[i]
            for j in range(i):
                term *= (x - points[j][0])
            result += term
        return result

    return P

points = [(0.2, 80), (0.3, 88), (0.5, 92)]  # Pontos a serem calculados
polynomial = newton_polynomial(points)

# Testando o polinômio em alguns valores de x
print("P(0.2) =", polynomial(0.2))

