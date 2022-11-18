import sys
n = int(input())

A = []
for _ in range(n):
    A.append(int(sys.stdin.readline()))

for i in sorted(A):
    sys.stdout.write(str(i)+ '\n')