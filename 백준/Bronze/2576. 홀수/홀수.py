
import sys
input = sys.stdin.readline

arr = []

for i in range(7):
    a = int(input())
    if a%2==1:
        arr.append(a)

if len(arr) == 0:
    print(-1)
else:
    print(sum(arr))
    print(min(arr))
