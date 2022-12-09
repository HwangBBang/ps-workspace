from collections import Counter
import sys
input = sys.stdin.readline


n = int(input())
nArr = Counter(map(int, input().split()))

m = int(input())
mArr = list(map(int, input().split()))
for elem in mArr:
    print(nArr[elem], end=" ")
        

