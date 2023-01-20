import sys
input = sys.stdin.readline

n,k = map(int,input().split())

coins = []

dp = [0]*(k+1)

for _ in range(n):
    coins.append(int(input()))

coins.sort()


# dp[k] ? k을 구성하는 경우의 수
# 주어진 (1,2,5)로 10 만드는 경우 찾기 
# dp[1] = 1 / 1
# dp[2] = 2 / 11,2
# dp[3] = 2 / 111,12
# dp[4] = 2 / 1111,112,22
# dp[5] = 2 / 11111,1112,122,5
dp[0] = 1

# coin 마다 확인
for coin in coins:
    # i 를 이루는 갯수를 더해나감
    for i in range(coins[0],k+1):
        if i - coin >= 0 :
            dp[i] += dp[i-coin]

print(dp[k])