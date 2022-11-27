n = int(input())

for i in range(n,0,-1):
    for k in range(n-i):
        print(" ",end="")
    for j in range(i):
        print("*",end="")
    print()