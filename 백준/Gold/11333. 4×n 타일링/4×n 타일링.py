import sys
input = sys.stdin.readline
T = int(input())

# 마지막 칸을 바라 보자, 
# 경우의 수는 (위에서 부터)

# A                B
# ㅁ ㅁ             ㅁ
# ㅁ ㅁ             ㅁ
# ㅁ ㅁ             ㅁ
# ㅁ ㅁ ㅁ           ㅁ ㅁ ㅁ

# 점화식
# dp(n) = A(n)*2 + dp(n-3)
# A ,B는 x 축 대칭이라 사실상 동치 = > dp(n) = A(n-1) * 2 

# A(n) = dp(n-3) + A(n-3) + B(n-3)
# B(n) = dp(n-3) + B(n-3)
#
# 초기화
dp = [0]*(10001)
A = [0]*(10001)
B = [0]*(10001)

dp[1] = 0
dp[2] = 0

A[3] = 1
B[3] = 1

dp[3] = A[3]*2 + 1

# 초기화 (기본 값)/ 바텀업 방식
for i in range(4,10000+1):
    B[i] = dp[i-3] + B[i-3]
    A[i] = dp[i-3] +A[i-3] + B[i-3]
    dp[i] = A[i]*2 +dp[i-3]



for _ in range(T):
    n = int(input())
    print(dp[n]%1000000007)