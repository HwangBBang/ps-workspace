import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
arr = list(set(arr))
arr.sort()

for ele in arr:
    print(ele,end=" ")

