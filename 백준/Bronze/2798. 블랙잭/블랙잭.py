
n,m = map(int,input().split())

cards = list(map(int,input().split()))

MAX = 0
for i in range(n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            pre = cards[i] + cards[j] + cards[k]
            if pre <= m and MAX < pre:
                MAX = cards[i] + cards[j] + cards[k]

print(MAX)