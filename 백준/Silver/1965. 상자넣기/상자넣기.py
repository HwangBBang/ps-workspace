import sys
input = sys.stdin.readline

n = int(input())

dp = [1]*(n+1)

arr = list(map(int,input().split()))
#dp[k] = dp[k-1] 보다 크다면 활용 아니면 걍 세
# 1 6 2 5 7 3 5 6 # arr
# 1 2 2 3 4 3 4 5 # dp


for i in range(1,n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[j]+1,dp[i])

print(max(dp))

