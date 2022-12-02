n = int(input())

# n 개를 2,5 로 거슬러주는 경우 = (n-2 를 2,5로) + (n-5 를 2,5로)

dp = [-1 for _ in range(100001)]
dp[2] = 1
dp[4] = 2
dp[5] = 1


# 9 , 12
# 11
# 9 6
for i in range(6,n+1):
    if dp[i-2] == -1 and dp[i-5] == -1:
        continue
    if dp[i-2] == -1:
        dp[i] = dp[i-5] + 1
        continue
    if dp[i-5] == -1:
        dp[i] = dp[i-2] + 1
        continue
    dp[i] = min(dp[i-2], dp[i-5])+1


print(dp[n])