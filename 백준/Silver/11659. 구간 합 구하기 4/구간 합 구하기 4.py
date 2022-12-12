import sys
input = sys.stdin.readline

n,m = map(int,input().split())
nArr = list(map(int,input().split()))
nArr = [0] + nArr


# 시간초과
# for i in range(m):
#     a,b = list(map(int,input().split()))
#     print(sum(nArr[a:b+1]))


dp = [0]*(n+1)

for nIdx in range(1,n+1):
    dp[nIdx] += nArr[nIdx]+dp[nIdx-1]

for _ in range(m):
    a,b = list(map(int,input().split()))
    result = dp[b] - dp[a-1]
    print(result)