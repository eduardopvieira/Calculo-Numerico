def lagrange_polynomial(points):

    def L(k, x):
        result = 1
        for i, point in enumerate(points):
            if i != k:
                result *= (x - points[i][0]) / (points[k][0] - points[i][0])
        return result

    def P(x):
        result = 0
        for k, point in enumerate(points):
            result += point[1] * L(k, x)
        return result

    return P

# Exemplo de uso:
x = 0.4
pontos = [(0.2, 80), (0.3, 88), (0.5, 92)]
polynomial = lagrange_polynomial(pontos)

# Testando o polinômio em alguns valores de x
print("P(0.4) =", polynomial(0.4))



"""
    Calculates the Lagrange polynomial given a set of points.

    Parameters:
    points (list of tuples): List of (x, y) points.

    Returns:
    function: The Lagrange polynomial as a function of x.
"""