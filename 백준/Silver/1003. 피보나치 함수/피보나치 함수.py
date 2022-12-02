
# dp(n) 
# / 마지막이 1인 경우: dp(n-1)
# / 마지막이 00인 경우: dp(n-2)
# dp(n) = dp(n-1) + dp(n-2) = 2dp(n-2) +dp(n-3)

# dp(3) = dp(1)+ dp(2)
# 001
# 100
# 111

dp = [[0 for _ in range(2)]for _ in range(41)]

dp[0] = [1, 0]
dp[1] = [0, 1]
for i in range(2, 41):
    dp[i][0] = dp[i-1][0] + dp[i-2][0]
    dp[i][1] = dp[i-1][1] + dp[i-2][1]

n = int(input())

for _ in range(n):
    a = int(input())
    print(dp[a][0],dp[a][1])


