n = int(input())

A = []
B = [1]*n
for i in range(n):
    A.append(list(map(int,input().split())))

for k in range(n):
    for j in range(n):
        if k == j:
            pass
        else:
            if A[k][0] < A[j][0]and A[k][1] < A[j][1]:
                B[k] += 1

for o in range(len(B)):
    print(B[o],end=" ")
