# 5
# 50 10 100 20 40
# 30 50 70 10 60

for _ in range(int(input())):
    A = [0,0]
    n = int(input())

    A[0] = list(map(int, input().split()))
    A[1] = list(map(int, input().split()))

    dp = [[0]*n,[0]*n]

    # 면을 공유하는 스티커는 선택할 수 없다. 

    # 대각선 선택하기 or 대각선 왼쪽거(전전) 선택하기 
    # 점화식 구하기 
    
    # 영향아예안받은 기초 값
    dp[1][0] = A[1][0]
    dp[0][0] = A[0][0]
    
    if n >= 2:
        # 직전꺼 밖에 안된다 
        dp[0][1] = dp[1][0] + A[0][1] 
        dp[1][1] = dp[0][0] + A[1][1] 
    
        for i in range(2,n):
            dp[0][i] = max(dp[1][i-1], dp[1][i-2])+A[0][i]
            dp[1][i] = max(dp[0][i-1], dp[0][i-2])+A[1][i]

    print(max(dp[0][n-1],dp[1][n-1]))



