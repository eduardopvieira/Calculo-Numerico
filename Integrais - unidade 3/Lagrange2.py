def lagrange_polynomial(points):

  def L(k, x):
    result = 1
    for i, point in enumerate(points):
      if i != k:
        result *= (x - points[i][0]) / (points[k][0] - points[i][0])
    return result

  def P(x):
    result = 0
    polynomial_string = ""
    for k, point in enumerate(points):
      coefficient = point[1] * L(k, x)
      if coefficient != 0:
        if coefficient > 0 and polynomial_string != "":
          polynomial_string += " + "
        elif coefficient < 0:
          polynomial_string += " - "
        polynomial_string += str(abs(coefficient))
        if points[k][0] != 0:  # Check for x^0 term
          polynomial_string += "x^{}".format(points[k][0])
      result += coefficient
    return result, polynomial_string

  return P

# Example usage
x = 1.5
pontos = [(0, 1), (1, 2), (2, 4), (3, 8)]
polynomial = lagrange_polynomial(pontos)

# Get both function value and polynomial string
function_value, polynomial_string = polynomial(x)

print("Valor da função em x =", function_value)
print("Polinômio de Lagrange:", polynomial_string)
