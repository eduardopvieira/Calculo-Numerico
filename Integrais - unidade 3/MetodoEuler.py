import matplotlib.pyplot as plt

def euler_metodo(f, x0, y0, h, n):
  
    # Inicializa listas para armazenar os valores de x e y
    x_vals = [x0]
    y_vals = [y0]
    
    # Itera para calcular os pontos usando o método de Euler
    for i in range(1, n + 1):
        x = x0 + i * h # Calcula o próximo valor de x
        y = y0 + h * f(x0, y0) # Calcula o próximo valor de y        
        x0, y0 = x, y # Atualiza x0 e y0 para os próximos cálculos
        
        #Coloca na lista
        x_vals.append(x)
        y_vals.append(y)
    
    return x_vals, y_vals

#função y' = f(x, y) que queremos resolver usando o método de Euler
def f(x, y):
    return (x*x)+(y*y)

# Valores iniciais e parâmetros do método de Euler
x0 = 0
y0 = 1
h = 0.1  # Tamanho do passo
n = 10   # Número de passos

# Chamada da função para resolver a EDO usando o método de Euler
x_vals, y_vals = euler_metodo(f, x0, y0, h, n)

# Imprime os resultados se quiser
for i in range(len(x_vals)):
    print(f"({x_vals[i]}, {y_vals[i]})")



# Plotar os pontos calculados
plt.plot(x_vals, y_vals, marker='o', linestyle='-', color='b')
plt.title('Método de Euler')
plt.xlabel('x')
plt.ylabel('y')
plt.grid(True)
plt.show()

"""    
    Parâmetros:
        - f: função que define a EDO dy/dx = f(x, y)
        - x0: valor inicial de x
        - y0: valor inicial de y (y(x0))
        - h: tamanho do passo (incremento de x)
        - n: número de passos (quantidade de iterações)
        
"""