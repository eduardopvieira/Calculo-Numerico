def f(x):
  return 2*x

def trapezoidal_rule(a, b):
  h = b - a
  return (h / 2) * (f(a) + f(b))

# intervalo
a = 0
b = 2

area_aproximada = trapezoidal_rule(a, b)
print("A área aproximada é:", area_aproximada)
