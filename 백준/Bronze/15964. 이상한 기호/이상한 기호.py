import sys
input = sys.stdin.readline

def cal(a,b):
    re = (a+b) * (a-b)
    return re


a,b = map(int,input().split())


print(cal(a,b))
