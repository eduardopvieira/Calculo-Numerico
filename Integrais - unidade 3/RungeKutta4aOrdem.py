import matplotlib.pyplot as plt

def runge_kutta_4(f, x0, y0, h, n):
    # Inicializa listas para armazenar os valores de x e y
    x_vals = [x0]
    y_vals = [y0]
    
    # Itera para calcular os pontos usando o método de Runge-Kutta de 4ª ordem
    for i in range(1, n + 1):
        k1 = h * f(x0, y0)
        k2 = h * f(x0 + h/2, y0 + k1/2)
        k3 = h * f(x0 + h/2, y0 + k2/2)
        k4 = h * f(x0 + h, y0 + k3)
        
        x = x0 + h
        y = y0 + (k1 + 2*k2 + 2*k3 + k4) / 6
        
        # Atualiza x0 e y0 para os próximos cálculos
        x0, y0 = x, y
        
        #Coloca na lista
        x_vals.append(x)
        y_vals.append(y)
    
    return x_vals, y_vals

# Define a função f(x, y)
def f(x, y):
    return 0.05*y - 0.0002*y**2

# Valores iniciais e parâmetros do método de Runge-Kutta
x0 = 0
y0 = 100
h = 0.1
n = 10

# Chama a função para resolver a EDO usando o método de Runge-Kutta de 4ª ordem
x_vals, y_vals = runge_kutta_4(f, x0, y0, h, n)

for i in range (len(x_vals)):
    print(f"Ponto {i+1}: {x_vals[i]}, {y_vals[i]}")

# Plota o gráfico
plt.plot(x_vals, y_vals, label="Solução RK4")
plt.xlabel("t")
plt.ylabel("y")
plt.title("Solução Numérica da EDO usando Runge-Kutta 4ª Ordem")
plt.legend()
plt.grid(True)
plt.show()
