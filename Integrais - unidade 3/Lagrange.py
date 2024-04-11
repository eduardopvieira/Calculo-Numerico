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
x = 1000 #esse x nao faz diferença mudar, apenas o passado como parametro
pontos = [(0, 1), (1, 2), (2, 4), (3, 8)]
polynomial = lagrange_polynomial(pontos)

# Valor da função em dado valor de X.
print("Ponto =", polynomial(1.5))



"""
    Calculates the Lagrange polynomial given a set of points.

    Parameters:
    points (list of tuples): List of (x, y) points.

    Returns:
    function: The Lagrange polynomial as a function of x.
"""