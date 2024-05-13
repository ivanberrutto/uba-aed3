mejorTiempoLogrado = 9999

porDondePase = [[]]

t = "es la tabla donde esta cada tiempo donde fila es el nivel y p es vidas para gastar"
v = " es un vector que me dice cuantas vidas me da pasar este nivel"

"""
def GastaVidas2(tiempoActual,vidasRestantes , nivelActual):
	if(nivelActual ==  len(t)):
		if tiempoActual < mejorTiempoLogrado:
			mejorTiempoLogrado = tiempoActual
	if(vidasRestantes== 0):
		GastaVidas2(tiempoActual + t[nivelActual][0] , vidasRestantes + v[nivelActual] , nivelActual + 1)

	for i in range(min(100,vidasRestantes)):
		return GastaVidas2(tiempoActual + t[nivelActual][1] , vidasRestantes - i + v[nivelActual] , nivelActual + 1)
"""


# me copie :
#M tamaño n+1 x 100n + 1 
# osea guardo cada nivel el tiempo que lo resuelve teniendo x cantidad de vidas
n = 50
m = [[None for _ in range(100 * n + 1)] for _ in range(n+1)]
def g(i,v):
	if i == n+1 : 
		return 0
	if v > (100*n) + 1
		return g(i, 100 * n + 1)

	if m[i][v] == None:
		m[i][v] = float('inf')
		for  p in range(min(100,v-1)):
			m[i][v] = min(m[i][v] , t[i][p] + g(i+1,v-p+V[I]))

