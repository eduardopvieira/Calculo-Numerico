import numpy as np
from scipy.linalg import lu, cholesky
from fractions import Fraction

def retornar_fracao(double):
    return Fraction(double).limit_denominator()

def ler_matriz():
    linhas = int(input("Digite a ordem da matriz: "))
    matriz = []

    print("Digite os elementos da matriz, linha por linha:")

    for i in range(linhas):
        linha = input(f"Digite os elementos da coordenada {i + 1} separados por espaço: ")
        elementos = linha.split()
        elementos = [float(elemento) for elemento in elementos]
        matriz.append(elementos)

    return matriz

def is_simetrica(matriz):
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if matriz[i][j] != matriz[j][i]:
                return False
    return True

matriz = ler_matriz()

det = np.linalg.det(matriz)

P, L, U = lu(matriz)

print("________________________________________")
print("SUA MATRIZ: ")
for linha in matriz:
    print([retornar_fracao(elemento) for elemento in linha])

print("________________________________________")
print("DETERMINANTE: ")
print(retornar_fracao(det))

print("________________________________________")
i = np.linalg.inv(matriz)
print("INVERSA FRACIONADA: ")
for linha in i:
    print([retornar_fracao(elemento) for elemento in linha])

print("________________________________________")
i = np.linalg.inv(matriz)
print("INVERSA NORMAL: ")
for linha in i:
    print(linha)

print("________________________________________")
print("MATRIZ DE PERMUTACAO: ")
for linha in P:
    print([retornar_fracao(elemento) for elemento in linha])

print("________________________________________")
print("MATRIZ TRIANGULAR INFERIOR (L): ")
for linha in L:
    print([retornar_fracao(elemento) for elemento in linha])

print("________________________________________")
print("MATRIZ TRIANGULAR SUPERIOR (U): ")
for linha in U:
    print([retornar_fracao(elemento) for elemento in linha])

print("_________________________________________")
cond = np.linalg.cond(matriz)
print("NUMERO DE CONDICIONAMENTO:")
print(retornar_fracao(cond))
print("NUMERO DE CONDICIONAMENTO NORMAL:")
print (cond)

print("________________________________________")
eh_simetrica = is_simetrica(matriz)
if (eh_simetrica == False):
    print("A MATRIZ NÃO É SIMÉTRICA, PORTANTO, NÃO DÁ PRA FAZER A DECOMPOSIÇÃO DE CHOLESKY")
else:
    print("Matriz U por metodo de cholesky (fracionado): ")
    ch = cholesky(matriz)
    for linha in ch:
        print([retornar_fracao(elemento) for elemento in linha])
    
    print("Matriz U por metodo de cholesky (normal): ")
    ch = cholesky(matriz)
    for linha in ch:
        print(linha)
    


