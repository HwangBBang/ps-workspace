import sys
input = sys.stdin.readline

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
A.sort(reverse=True)
sortedB = sorted(B)
sum = 0
for i in range(n):
    sum+= A[i]*sortedB[i]
    

print(sum)
