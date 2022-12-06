
import sys
input = sys.stdin.readline

n = int(input())


def func2(a, b):
    addA, addB = a, b
    while True:
        if a == b:
            return a
        else:
            if a > b:
                b += addB
            if a < b:
                a += addA

for _ in range(n):
    a,b = map(int,input().split())
    print(func2(a,b))