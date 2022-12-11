
import sys
input = sys.stdin.readline


n = int(input())
dp = [0]*(1000000+1)

#1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
#2. X가 2로 나누어 떨어지면, 2로 나눈다.
#3. 1을 뺀다.
# 그냥 1
dp[1] = 0
# (빼기 1) or (나누기2)
dp[2] = 1
# (나누기3)
dp[3] = 1
# # (빼기 1)(나누기3) or (나누기2)*2
# dp[4] = 2
# # (빼기 1)*2 (나누기3) or (빼기 1)(나누기2)*2
# dp[5] = 3
# # (나누기3)*(나누기2)
# dp[6] = 2
# # (빼기 1)*(나누기3)*(나누기2)
# dp[7] = 3
# # (나누기2)(나누기2)(나누기2)
# dp[8] = 3
if n>3:
    for i in range(4,n+1):
        if i%2 == 0 and i%3 == 0:
            dp[i] = min(dp[i-1],dp[i//2],dp[i//3])+1
        elif i%2 == 0:
            dp[i] = min(dp[i-1],dp[i//2])+1
        elif i%3 == 0:
            dp[i] = min(dp[i-1],dp[i//3])+1
        else:
            dp[i] = dp[i-1] + 1

print(dp[n])