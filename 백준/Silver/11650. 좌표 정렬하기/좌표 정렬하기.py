n = int(input())

A = [[None,None]for _ in range(n)]
for k in range(n):
    x,y = map(int,input().split())
    A[k][0] = x
    A[k][1] = y
# , key = lambda x: x[0]
B = sorted(A)

for j in range(n):
    print(B[j][0],B[j][1])
