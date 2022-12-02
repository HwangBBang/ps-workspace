n = int(input())
# dp(n) 
# / 마지막이 1인 경우: dp(n-1)
# / 마지막이 00인 경우: dp(n-2)
# dp(n) = dp(n-1) + dp(n-2) = 2dp(n-2) +dp(n-3)

# dp(3) = dp(1)+ dp(2)
# 001
# 100
# 111

dp = [0 for _ in range (1000001)]

dp[1] = 1
dp[2] = 2


for i in range(3,n+1):
    dp[i] = (dp[i-1] + dp[i-2]) % 15746

print(dp[n])
