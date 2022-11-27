t = int(input())


dp = [[0 for _ in range(14)]for b in range(15)]
dp[0] = [a for a in range(1, 15)]
# a층 b호 
# a-1층 1호 ~ b호
# 1, 3
# 0층 1 2 3
# 1층 1(1) 2(3) 3(6) 

# for y in range(14):
#     dp[y][0] = 1

for i in range(1,15):
    for j in range(0,14):
        for k in range(j+1):
            dp[i][j] += dp[i-1][k]


for _ in range(t):
    k1 = int(input())
    n1 = int(input())
    
    print(dp[k1][n1-1])