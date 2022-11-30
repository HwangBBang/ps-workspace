n = int(input())

A = [[None,None]for _ in range(n)]
for k in range(n):
    age,name = input().split()
    age = int(age)
    A[k][0] = age
    A[k][1] = name

B = sorted(A,key= lambda x:x[0])

for j in range(n):
    print(B[j][0],B[j][1])
