n = int(input())

A = [[None,None]for _ in range(n)]
for k in range(n):
    x,y = map(int,input().split())
    A[k][0] = x
    A[k][1] = y
# 
A.sort(key=lambda x:(x[1],x[0]))

for j in range(n):
    print(A[j][0],A[j][1])

