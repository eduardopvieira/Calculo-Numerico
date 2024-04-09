def simpson38(f, a, b, n):
  
  h = (b - a) / n
  sum_even = 0
  sum_odd = 0
  for i in range(1, n, 2):
    sum_even += f(a + i * h)
  for i in range(2, n, 2):
    sum_odd += f(a + i * h)
  return (3 * h / 8) * (f(a) + f(b) + 2 * sum_even + 3 * sum_odd)

# Função a ser integrada
def f(x):
  return x**2

# Intervalo de integração
a = 0
b = 1

# Número de subintervalos (quanto maior, mais preciso). Não pode ser ímpar.
n = 4 

# Cálculo da integral definida
resultado = simpson38(f, a, b, n)

# Imprime o resultado
print(f"Resultado: {resultado}")


"""
  Calcula a integral definida da função f no intervalo [a, b] usando o método de Simpson 3/8.

  Argumentos:
    f: A função a ser integrada.
    a: O limite inferior do intervalo de integração.
    b: O limite superior do intervalo de integração.
    n: O número de subintervalos.

  Retorno:
    A estimativa da integral definida.
  """