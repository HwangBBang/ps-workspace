n = int(input())

dp = [[0 for _ in range(2)] for _ in range(52)]

dp[1][0] ,dp[1][1] = 1 , 1
dp[2][0], dp[2][1] = 1 , 1
dp[3][0], dp[3][1] = 2 , 3

# 몇번 호출 되는지??

for i in range(4, 52):
    dp[i][0] = (dp[i-1][0] + dp[i-2][0])
    dp[i][1] = (dp[i-1][1] + dp[i-2][1]+1)%1000000007


print(dp[n+1][1])