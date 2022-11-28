A = list(map(int, input().split()))

sumA = 0
for i in range(len(A)):
    sumA += A[i]**2

print(sumA%10)