
# import sys
# input = sys.stdin.readline

a, b = map(int, input().split())
aSet = set()
bSet = set()


for _ in range(a):
    aSet.add(input())


for _ in range(b):
    bSet.add(input())

result = list(aSet & bSet)
result.sort()



print(len(result))
for elem in result:
    print(elem)

