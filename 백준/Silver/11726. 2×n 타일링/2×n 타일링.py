n = int(input())

# dp(n) / x가 n인 경우 : 
# + (12)로 할 때  dp(n-1) 
# + (21)로 할 때  dp(n-2)

dp = [0 for _ in range (1001)]

dp[1] = 1
dp[2] = 2

for i in range(3,n+1):
    dp[i] = (dp[i-1])+(dp[i-2])

print(dp[n]%10007)