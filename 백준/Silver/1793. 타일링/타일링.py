# dp(n) / x가 n인 경우 : 
# + (22)로 할 때  dp(n-2) 
# + (21)로 할 때  dp(n-2)
# + (12)로 할 때  dp(n-1)

dp = [0 for _ in range (251)]

dp[0] = 1
dp[1] = 1
dp[2] = 3

for i in range(3,251):
    dp[i] = (dp[i-1])+2*(dp[i-2])

I = []
while True:
    try:
        I = int(input())
        print(dp[I])
    except:
        break


