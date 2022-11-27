n = int(input())

for i1 in range(1,n+1):
    for j in range(i1):
        print("*", end="")
    print()
for i in range(1, n):
    for j in range(n-i):
        print("*", end="")
    print()
