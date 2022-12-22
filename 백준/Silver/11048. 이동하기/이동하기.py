# 행열의 사이즈 를 입력 받음 
n,m = map(int,input().split())

# 초기 배열 입력 및 세팅
A = [0]*(n+1)
A[0] = [0]*(m+1)
for i in range(1,n+1):
    A[i] = [0]+list(map(int,input().split()))
dp = A
# 기존인덱스의 (-1,0),(-1,-1),(0,-1)을 해주고 
# 그것들의 벨류들의 멕스를 새로 추가 
# Why??
# 임의점은 다음과 같은 점화식으로 표현된다. 
# dp(i,j) = max(dp(i-1,j),dp(i-1,j-1),dp(i,j-1))

for i in range(1,n+1):
    for j in range(1,m+1):
        dp[i][j] = max(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + A[i][j]


print(dp[n][m])