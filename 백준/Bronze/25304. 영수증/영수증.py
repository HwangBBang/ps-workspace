x = int(input())
n = int(input())

A=[None]*n

for i in range (n):
    a,b = map(int,input().split())
    A[i] = a*b

if x == sum(A):
    print("Yes")
else:
    print("No")