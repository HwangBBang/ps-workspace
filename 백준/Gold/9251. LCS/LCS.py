import sys
input = sys.stdin.readline

dp = [[0 for _ in range(1001)]for _ in range(1001)]
# dp = [[0 for _ in range(9)]for _ in range(9)]
ori = input().rstrip()



com = input().rstrip()
oL = len(ori)
cL = len(com)
for i in range(oL):
    for j in range(cL):
        if ori[i] == com[j]:
            dp[i+1][j+1] = dp[i][j] + 1
        else:
            dp[i+1][j+1] = max(dp[i+1][j], dp[i][j+1])
# ori len = i
# com len = j

# LCS(i,j) = ? 

# 마지막 문자 두개가 같다면?
# LCS(i,j) = LCS(i-1,j-1) + 1

# 마지막 문자 두개가 다르다면?
# LCS(i,j) = max(LCS(i-1,j) ,LCS(i,j-1))
print(dp[len(ori)][len(com)])
