import sys
input = sys.stdin.readline
T = int(input())



# 마지막 칸을 바라 보자, 
# 경우의 수는 (위에서 부터)

# 경우 A / # 경우 B  / 경우 C 
# 21        # 21       # 12
# 21        # 12       # 21
# 12        # 21       # 21

# 점화식
# dp(n) = dp(n-1) + dp(n-2) + A(n-1) + B(n-1) +C(n-1)

# A(n-1) = dp(n-2) + C(n-2)
# C(n-1) = dp(n-2) + A(n-2)
# B(n-1) = dp(n-2) + B(n-3)



# 초기화 (기본 값)/ 바텀업 방식

for _ in range(T):
    n = int(input())
    dp = [0]*(n+1)
    A = [0]*(n+1)
    B = [0]*(n+1)
    C = [0]*(n+1)
    
    A[1] = 1
    C[1] = 1
    B[1] = 1
    dp[1] = 1
    if n == 1:
        print(dp[1])
    else:
        dp[2] = A[1] + B[1] + C[1] + dp[1] +1
        
        for i in range(3,n+1):
            A[i-1] = dp[i-2] +C[i-2]
            C[i-1] = dp[i-2] +A[i-2]
            B[i-1] = dp[i-2] +B[i-3]
            dp[i] = dp[i-1] + dp[i-2] + A[i-1] + B[i-1] +C[i-1]

        print(dp[n])