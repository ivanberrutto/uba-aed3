
# T(n) = a T(n/c) + f(n)
#PD: Estos ejercicios no estan testeados para compilar, son puramente de uso practico - pseudocodigo.

#Ejercicio 1:
def IzquierdaDominante(A):
	if len(A) == 1:
		return True

	return ( sum(A[:len(A)//2]) > sum(A[len(A)//2:]) ) and IzquierdaDominante(A[:len(A)//2])

		

# a = 1
# c = 1
# f(n) = on

# por tm 3° complejidad= n

#Ejercicio 2:

def IndiceEspejo(A,p=0,f=None):
	#print("p es ",p," f es ",f)
	if f is None:
		f = len(A) - 1
	m = (p+f) //2
	if A[m] == m:
		return True
	if p==f:
		return False
	if m>A[m]:
		return IndiceEspejo(A,m+1,f)
	else:
		return IndiceEspejo(A,p,m-1)

print(IndiceEspejo([0, -1, 5, 10, 7]))

# a = 1
# c = 1
# f(n) = o1
# por tm 2° complejidad: n**( log1 1 = 0 ) log n =  log n