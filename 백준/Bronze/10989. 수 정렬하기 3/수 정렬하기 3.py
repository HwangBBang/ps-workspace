import sys
input = sys.stdin.readline
n = int(input())

# 1~10000 숫자의 갯수 를 세자 

A = [0]*10001
for _ in range(n):
    idx = int(input())
    A[idx] += 1


for i in range(10001):
    if A[i] != 0:
        for j in range (A[i]):
            print(i)