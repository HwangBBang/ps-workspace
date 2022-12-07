import sys
input = sys.stdin.readline

n = int(input())
pList = list(map(int,input().split()))

pList.sort(reverse=True)

dp = [0]*(n+1)
dp[1] = pList.pop()

for i in range(2,n+1):
    dp[i] = min(pList) + dp[i-1]
    pList.pop()


print(sum(dp))
