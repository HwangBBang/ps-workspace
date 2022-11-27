n = int(input())

dp = [None]*91

dp[0] ,dp[1] ,dp[2] = 0,1,1


for i in range(2,n):
    dp[i+1] = dp[i] + dp[i-1]

print(dp[n])