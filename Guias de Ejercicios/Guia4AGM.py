# Ejercicio 10

# Creamos un grafo donde cada vertice representa una secuencia

# Creamos sus aristas donde cada arista es el costo ( list x, list y) = sum(x) - sum(y)

# Corremos prim sobre el grafo completo y obtenemos el AGM

# Crear el grafo completo cuesta O ( k * n ^ 2) 
# k es porque es calcular cuanto vale el costo de cada arista y n^2 porque hay que crear el grafo completo
# sabemos que realizar prim va a costar debajo de la cota de O ( k * n ^ 2) , por lo tanto esa es mi complejidad.

