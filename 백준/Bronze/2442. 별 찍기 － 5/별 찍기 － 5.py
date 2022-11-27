n = int(input())

for i in range(n,0,-1):
    for k in range(i-1):
        print(" ",end="")
    for j in range((n-i+1)*2-1):
        print("*",end="")
    print()