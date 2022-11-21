n,k = map(int,input().split())

A =list(map(int,input().split()))

A.sort(reverse=True)
print(A[k-1])


