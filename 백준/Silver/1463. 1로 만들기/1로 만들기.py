import sys
input = sys.stdin.readline

n = int(input())

# 최대한 적은 횟수 로 1을 만들자
# 1순위 / X가 3으로 나누어 떨어지면, 3으로 나눈다.
# 2순위 / X가 2로 나누어 떨어지면, 2로 나눈다.
# 3순위 / 1을 뺀다.

# cnt = 0
# while 1:
#     if n == 1:
#         print(cnt)
#         break
#     cnt += 1
#     if not n % 3:
#         n //= 3
#         print(n)
#         continue
#     elif not n % 2:
#         n //= 2
#         print(n)
#         continue
#     else:
#         n -= 1
#         print(n)
#         continue

# dp 활용

# 점화식이 뭘까 ?
# 초항부터 알아보자

# dp(2) = 1개 (2번) / 1개 (3번)
# dp(3) = 1개 (1번) / dp(2) + 1개 (3번)
# dp(4) = dp(2) + 1개 (2번) / dp(3) (3번) + 1개


dp = [0]*(1000000+1)


dp[1] = 0
dp[2] = 1

if n > 2:
    for i in range(3, n+1):
        if i % 3 == 0 and i % 2 == 0:
            dp[i] = min(dp[i-1], dp[i//2], dp[i//3])+1
        elif i % 3 == 0:
            dp[i] = min(dp[i-1], dp[i//3])+1
        elif i % 2 == 0:
            dp[i] = min(dp[i-1], dp[i//2])+1
        else:
            dp[i] = dp[i-1]+1

print(dp[n])
