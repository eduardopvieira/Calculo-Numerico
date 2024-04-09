import matplotlib.pyplot as plt

def runge_kutta_4(f, y0, t_span, h):
    """
    Resolve uma equação diferencial ordinária de primeira ordem usando o método de Runge-Kutta de 4ª ordem.

    Argumentos:
        f: A função que define a equação diferencial.
        y0: O valor inicial da solução.
        t_span: O intervalo de tempo.
        h: O passo de integração.

    Retorno:
        t_values: Uma lista com os valores de tempo.
        y_values: Uma lista com os valores da solução em cada ponto do intervalo de tempo.
    """
    # Define o tempo inicial
    t = t_span[0]

    # Cria listas para armazenar os valores do tempo e da solução
    t_values = [t]
    y_values = [y0]

    # Itera sobre o intervalo de tempo
    while t < t_span[1]:
        # Calcula os coeficientes de Runge-Kutta
        k1 = h * f(t, y_values[-1])
        k2 = h * f(t + h/2, y_values[-1] + k1/2)
        k3 = h * f(t + h/2, y_values[-1] + k2/2)
        k4 = h * f(t + h, y_values[-1] + k3)

        # Atualiza o valor da solução
        y_next = y_values[-1] + (k1 + 2*k2 + 2*k3 + k4) / 6

        # Atualiza o tempo
        t += h

        # Armazena os novos valores
        t_values.append(t)
        y_values.append(y_next)

        # Imprime os resultados de cada ponto
        print(f"t = {t}, y = {y_next}")

    return t_values, y_values

# Função da EDO.
def f(x, y):
    return ((x*x) + (2*y))/x

# Condições iniciais
y0 = 2
t_span = [1, 4]
n = 10
h = (t_span[1] - t_span[0]) / n

# Solução da EDO usando o método de Runge-Kutta de 4ª ordem
t_values, y_values = runge_kutta_4(f, y0, t_span, h)

# Plota o gráfico
plt.plot(t_values, y_values, label="Solução RK4")
plt.xlabel("t")
plt.ylabel("y")
plt.title("Solução Numérica da EDO usando Runge-Kutta 4ª Ordem")
plt.legend()
plt.grid(True)
plt.show()
