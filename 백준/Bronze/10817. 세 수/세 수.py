
import sys
input = sys.stdin.readline


# n = int(input())
A = list(map(int, input().split()))

A.sort()

print(A[1])