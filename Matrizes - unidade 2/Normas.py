import numpy as np
from scipy.linalg import lu

#Versão feita com python pra poder conferir algumas coisas

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
    #NAO PRECISA DE VERIFICAÇAO SE FOR QUADRADA PQ ELA É OBRIGATORIAMENTE QUADRADA
    
    for i in range(len(matriz)):
        for j in range(len(matriz[0])):
            if matriz[i][j] != matriz[j][i]:
                return False
    return True

    
    
    

#-----------------------------------------------------------------------------------------------------


matriz = ler_matriz()

det = np.linalg.det(matriz)

P, L, U = lu(matriz)


print("________________________________________")
print("SUA MATRIZ: ")
for linha in matriz:
    print(linha)


print("________________________________________")
print("DETERMINANTE: " + str(det))


print("________________________________________")
print ("MATRIZ DE PERMUTACAO: ")
for linha in P:
    print(linha)


print("________________________________________")
print ("MATRIZ TRIANGULAR INFERIOR (L): ")
for linha in L:
    print(linha)


print("________________________________________")
print("MATRIZ TRIANGULAR SUPERIOR (U): ")
for linha in U:
    print(linha)
    

print("________________________________________")
eh_simetrica = is_simetrica(matriz)
if (eh_simetrica == False):
    print("A MATRIZ NÃO É SIMÉTRICA, PROTANTO, NÃO DÁ PRA FAZER A DECOMPOSIÇÃO DE CHOLESKY")
else:
    print("Matriz de Permutacao (Decomposicao LU): ")
    ch = np.linalg.cholesky(matriz)

























