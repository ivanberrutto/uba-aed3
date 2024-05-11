
# T(n) = a T(n/c) + f(n)

#Ejercicio 1:
def IzquierdaDominante(A):
	if len(A) == 1:
		return True

	if(sum(A[:len(A)//2])> sum(A[len(A)//2:]) && IzquierdaDominante(A[:len(A)//2]) ):
		return True
	else:
		return False

# complejidad o(n log n)?

# a = 1
# c = 1
# f(n) = n/2 

# por tm 2° complejidad: n**(log1 1) log n = n * log n