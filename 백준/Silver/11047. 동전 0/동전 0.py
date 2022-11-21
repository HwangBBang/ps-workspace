import sys
input = sys.stdin.readline

n,k = map(int, input().split())

A = [0]*(n)
cnt = 0

for i in range(n):
    A[i] = int(input())

for j in range(n-1,-1,-1):
    cnt += k//A[j]
    k = k%A[j]


print(cnt)