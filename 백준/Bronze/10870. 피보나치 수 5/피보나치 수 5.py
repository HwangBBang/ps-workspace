
import sys
input = sys.stdin.readline

n = int(input())

dp = [0]*21
dp[1], dp[2] = 1, 1

for i in range(3,21):
    dp[i] = dp[i-1]+dp[i-2]

print(dp[n])
