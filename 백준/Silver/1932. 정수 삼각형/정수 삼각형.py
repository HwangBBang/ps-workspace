import sys
input = sys.stdin.readline
n = int(input())

triangle = [[0]]

for _ in range(n):
    triangle.append([0]+list(map(int,input().split())))
dp = triangle

for i in range(2,n+1): # 행
    for j in range(1,i+1):
        if j == 1: # 삼각형 가장 왼쪽이라면?
            dp[i][j] = dp[i][j]+ triangle[i-1][j]
        elif i == j: # 삼각형 가장 오른쪽이라면?
            dp[i][j] = dp[i][j]+ triangle[i-1][j-1]
        else: # 삼각형 가운데 라면?
            dp[i][j] = dp[i][j]+ max(triangle[i-1][j-1],triangle[i-1][j])

print(max(dp[n]))