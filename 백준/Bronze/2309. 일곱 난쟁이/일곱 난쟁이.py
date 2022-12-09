import sys
input = sys.stdin.readline

# n = int(input())
# A = list(map(int, input().split()))
# B = list(map(int, input().split()))

A = []
for i in range(9):
    A.append(int(input()))

A.sort()

for i in range(8):
    for j in range(i+1,9):
        temp1 = A[i]
        temp2 = A[j]
        A[i] = 0
        A[j] = 0
        if sum(A) == 100:
            for k in range(9):
                if A[k] != 0:
                    print(A[k])
            break
        A[i] = temp1
        A[j] = temp2 
        

