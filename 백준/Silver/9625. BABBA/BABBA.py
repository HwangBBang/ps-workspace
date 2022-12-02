n = int(input())

# 초기화면
# A

# A -> B

# B -> BA

#A
#B
#B A
#BA B

dp = [[0 for _ in range(2)]for _ in range(46)]

dp[0] = [1,0]
dp[1] = [0,1]

for i in range(2,n+1):
    dp[i][0] = dp[i-1][1]
    dp[i][1] = dp[i-1][1]+ dp[i-1][0]

print(dp[n][0],dp[n][1])
