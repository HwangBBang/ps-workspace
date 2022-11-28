n,k = map(int,input().split())

dp  = [[0 for _ in range(i+1)] for i in range(30)]

dp[0][0] = 1

for s in range(30):
    dp[s][0],dp[s][s] = 1,1

for i in range(2,30):
    for j in range(1,i):
        dp[i][j] = dp[i-1][j]+dp[i-1][j-1]

print(dp[n-1][k-1])