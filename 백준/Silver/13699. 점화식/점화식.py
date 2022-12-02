
n = int(input())

dp = [0 for _ in range(36)]

dp[0] = 1
dp[1] = 1
dp[2] = 2


for i in range(3, n+1):
    for j in range(i):
        dp[i] += dp[j]*dp[i-1-j]
print(dp[n])