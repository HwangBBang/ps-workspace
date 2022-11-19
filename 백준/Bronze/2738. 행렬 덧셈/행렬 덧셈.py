n,m = map(int,input().split())

A = [None for x in range(n)]
B = [None for x in range(n)]
# C = [[None for x in range(n)]for x in range(m)]

for i in range(n):
    A[i] = list(map(int, input().split()))

for i in range(n):
    B[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(m):
        print(A[i][j]+ B[i][j],end=" ")
    print()

