n, k = map(int, input().split())

idx = k-1
A = [i for i in range(1,n+1)]
B = []
while len(A)>0:
    B.append(A.pop(idx))
    idx+=k-1
    if len(A)!=0 and idx >= len(A):
        idx = idx%len(A)


print("<",end="")
for j in range(n-1):
    print(B[j],end=", ")
print(B[n-1],end="")
print(">",end="")