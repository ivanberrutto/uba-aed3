import numpy as np


def check_feasibility(A, b, inequalities, epsilon=1e-9):
    A = np.array(A)
    b = np.array(b)
    """
    A: matriz de coeficientes (cada fila representa una inecuación)
    b: vector de términos independientes
    inequalities: lista de cadenas '<' o '>' indicando el tipo de inecuación
    epsilon: pequeño valor para convertir inecuaciones estrictas en no estrictas
    """
    from scipy.optimize import linprog

    # Ajustar desigualdades estrictas para que se manejen como no estrictas
    for i in range(len(inequalities)):
        if inequalities[i] == '<':
            b[i] -= epsilon
        elif inequalities[i] == '>':
            A[i] = -A[i]
            b[i] = -b[i] - epsilon

    # Intentar resolver el problema con el método del simplexo
    num_vars = A.shape[1]
    c = np.zeros(num_vars)

    result = linprog(c, A_ub=A, b_ub=b, method='highs')

    return result.success



while True:
    try:
        n, m = input().split()
    except ValueError:
        break
    n , m = int(n),int(m)
    matriz = [[0] * n for _ in range(m)]
    constraints = [None] * m
    res = [0] * m
    for i in range(m):
        si, ni, oi, ki = input().split()
        si, ni, ki = int(si), int(ni), int(ki)
        for j in range(si, min(si + ni + 1, n)):
            matriz[i][j] = 1
        if oi == "lt":
            constraints[i] = '<'
        elif oi == "gt":
            constraints[i] = '>'
        res[i] = ki
    if check_feasibility(matriz, res, constraints):
        print("lamentable kingdom")
    else:
        print("successful conspiracy")