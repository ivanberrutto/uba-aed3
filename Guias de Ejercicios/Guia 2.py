
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

#print(IndiceEspejo([0, -1, 5, 10, 7]))

# a = 1
# c = 1
# f(n) = o1
# por tm 2° complejidad: n**( log1 1 = 0 ) log n =  log n


#Ejercicio 3:

#forma sin D&Q 
def PotenciaLogaritmicaSinDQ(a,b,aActual = 0 , n=1):
	if(aActual==0 and a!=0):
		aActual=a
	if(b==0):
		return 1
	if(b==1):
		return a 
	if(n>=b):
		return  PotenciaLogaritmica(a, b)

	return aActual * PotenciaLogaritmica(a , b - n , aActual*aActual , n * 2)  



# Forma D&Q
def PotenciaLogaritmica(a, b):
    if b == 0:
        return 1
    if b == 1:
        return a
    mitad = PotenciaLogaritmica(a, b // 2)
    
    # Si b es par
    if b % 2 == 0:
        return mitad * mitad
    else:
        # Si b es impar, tenemos que multiplicar una vez más por a
        return mitad * mitad * a

#print(PotenciaLogaritmica(5,4))

# a = 1
# c = 2
# f(n) = o1
# por tm 2° complejidad: n**( log1 1 = 0 ) log n =  log n


#Ejercicio 4:


#Ejercicio 5:

def PotenciaSum(A):
    return potencia(A) if len(A) <= 4 else (PotenciaSum([row[:len(A[0])//2] for row in A[:len(A)//2]]) +
                                            PotenciaSum([row[len(A[0])//2:] for row in A[:len(A)//2]]) +
                                            PotenciaSum([row[:len(A[0])//2] for row in A[len(A)//2:]]) +
                                            PotenciaSum([row[len(A[0])//2:] for row in A[len(A)//2:]]))

# No es posible comprobar si esta bien

#Ejercicio 6

#...

#Ejercicio 7

def DesordenSort(A):
	if len(A) <= 1:
		return A,0
	izq , contarizq =  DesordenSort(A[:len(A)//2])
	der , contarder = DesordenSort(A[len(A)//2:])
	resultado,contar = merge_y_contar(izq,der)
	return resultado,contar

def merge_y_contar(izq, der): 
	resultado = [] 
	i = 0
	j = 0 
	contar = 0
	# Mientras haya elementos en ambos subarreglos
	while i < len(izq) and j < len(der):
	    if izq[i] <= der[j]:
	        resultado.append(izq[i])
	        i += 1
	    else:
	        resultado.append(der[j])
	        contar += len(izq) - i  # Todos los elementos restantes en izq están desordenados respecto a der[j]
	        j += 1

	# Añadir los elementos restantes de cada subarreglo
	resultado += izq[i:]
	resultado += der[j:]

	return resultado, contar

print(DesordenSort([2,4,3,6,8]))