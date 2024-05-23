#ejercicio 8
def cortesEconomicos(i, j, memo = None):
    if memo is None:
        memo = [[None] * (j + 1) for _ in range(j + 1)]
        memo[0][0] = 0
        
    if i == j:
        return 0
    
    if memo[i][j] is not None:
        return memo[i][j]

    min_ =j-i
    for c in C:
        if i < c and c < j:
            if memo[i][c] is None:
                memo[i][c] = cortesEconomicos(i, c, memo)
            if memo[c][j] is None:
                memo[c][j] = cortesEconomicos(c, j, memo)
            
            min_  = min((min_, memo[i][c] + memo[c][j]))
    
    return j - i + min_

C = [4, 2, 7]

print(cortesEconomicos(0, 10))

#ejericcio 11:

# f(i,r) =
# true si i=n y r=w
# false si i = n y r!=w 
# f(i+1,r+v(i+1)) o f(i+1, r x v(i+1)) o f(i+1, r**vi+1) cc

w = 100
memo = [][]
#memo:
# fila suma
# fila x
# fila pote
v = []

def operacionesSeq(i,r ):


	if(i == len(v)):
		if (r==w):
			return True
		else:
			return False
	if r > w:
		return False

	return operacionesSeq(i+1,r+v[i+1] ) || operacionesSeq(i+1, r * v[i+1] ) || operacionesSeq(i+1, r ** v[i+1] )

