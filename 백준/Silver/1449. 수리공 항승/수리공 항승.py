import sys
input = sys.stdin.readline

n,l = map(int,input().split())

spot = list(map(int,input().split()))

spot.sort()

# 한 개는 반드시 붙여야해
count = 1
limt = (spot[0] - 0.5) + l

for i in range(1, n):
    if limt >= spot[i] + 0.5:
        continue
    else:
        count += 1
        limt = (spot[i] - 0.5) + l

print(count)
