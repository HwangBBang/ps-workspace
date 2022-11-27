n = int(input())


for i in range(1,n+1):
    for j in range(i):
        print("*",end = "")
    for k in range(2*(n-i)):
        print(" ", end = "")
    for l in range(i):
        print("*", end="")
    print()

for i1 in range(1, n):
    for j1 in range(n-i1):
        print("*", end="")
    for k1 in range(2*(i1)):
        print(" ", end="")
    for l1 in range(n-i1):
        print("*", end="")
    print()
