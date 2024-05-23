


casos: list[list[int]] = []
while True:
    n = input()
    if n == "0":
        break
    botellas = 0
    work = 0
    listadetransacciones = list(map(int, input().split(" ")))
    casos.append(listadetransacciones)
for lista in casos:
    botellas = 0
    work = 0
    for v in lista:
        botellas += v
        work += abs(botellas)

    print(work)