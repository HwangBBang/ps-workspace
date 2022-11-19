A = [None for _ in range(9)]
arrmax = 0

for i in range(9):
    A[i] = list(map(int, input().split()))
    if arrmax <= max(A[i]):
        arrmax = max(A[i])
        maxI = i

print(arrmax)
print(maxI+1,A[maxI].index(arrmax)+1)
