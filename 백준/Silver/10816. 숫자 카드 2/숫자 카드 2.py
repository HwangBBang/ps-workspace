from collections import Counter

n = int(input())
nArr = Counter(map(int,input().split()))

m = int(input())
mArr = list(map(int, input().split()))
for elem in mArr:
    print(nArr[elem],end=" ")