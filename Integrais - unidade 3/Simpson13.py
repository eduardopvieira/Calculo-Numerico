import math #biblioteca nao ta sendo usada, importei so por acaso

def f(x): 
    return (x ** 3) + 2 * (x ** 2) - 4*x + 1

def simps13(h, fx0, fx1, fx2):
    return h/3 * (fx0 + (4 * fx1) + fx2)

x0, x1, x2 = 1, 2, 3 #os 3 valores a serem calculados
a, b = 1, 4          #intervalo
n = 4                #subintervalos, pode ser impar ou par. geralmente, a precisao da aproximação é melhor quando o numero é par
h = (b-a)/n

fx0 = f(x0)
fx1 = f(x1)
fx2 = f(x2)

print (simps13(h, fx0, fx1, fx2))
