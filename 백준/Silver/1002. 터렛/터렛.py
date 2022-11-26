import math
import sys
input = sys.stdin.readline

t = int(input())
A = [None]*t
x1, y1, r1, x2, y2, r2 = 0, 0, 0, 0, 0, 0

for j in range(t):
    A[j] = list(map(int, input().split()))

for i in range(t):
    x1, y1, r1 = A[i][0], A[i][1], A[i][2]
    x2, y2, r2 = A[i][3], A[i][4], A[i][5]

    d = math.sqrt(((x1-x2)**2) + ((y1-y2)**2))

    #규현과 승환이가 같은 점에 있을떄
    if d == 0:
        # 무한개
        if r1 == r2:
            if r1 == 0:
                print(1)
            else:
                print(-1)
        # 0 개
        else:
            print(0)
    elif d > 0:
        if d > (r1+r2):
            print(0)
        elif d == (r1+r2):
            print(1)
        else:  # d < (r1+r2)
            
            if d+r1 == r2 or d+r2 == r1:
                print(1)
            elif d+r1 < r2 or d+r2 < r1:
                print(0)
            else:
                print(2)
