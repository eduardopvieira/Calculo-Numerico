import math

def f(x):
  return math.sin(x) + math.exp(1)

def soma_riemann(a, b, n):

  delta_x = (b - a) / n
  soma = 0

  for i in range(n):
    xi = a + i * delta_x
    soma += f(xi) * delta_x

  return soma


a = 0 #intervalo inicial
b = 3 #intervalo final
n = 100000  # numero de retangulo

# Calculate and print the approximate integral value
resultado = soma_riemann(a, b, n)
print("Area total:", resultado)
