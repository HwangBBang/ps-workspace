import sys
input = sys.stdin.readline

dp = [0 for _ in range(301)]
n = int(input())

value = [0]*(301)

for i in range(1,n+1):
    value[i] = int(input())

# 첫 번째 계단은 무조건 밟음
dp[1] = value[1]
# 한칸 올라감
dp[2] = value[1]  + value[2]


# 마지막 칸 에 도달하는 방법 
# 마지막 전 (n-1)칸에 오고 (n-3)칸에서 오는경우 
# 마지막 전전(n-2)칸에서 오는경우
# 다시말해 도착전 2칸1칸 이동 / 2칸이동이있음
if n < 2:
    print(value[1])
else:
    
    for i in range(3,n+1):
        dp[i] = max(
            dp[i-3]+value[i-1]+value[i],  # 2칸 이동 -> 1칸 이동 -> n도달
            dp[i-2]+value[i]   # 2칸 이동 -> n도달
            )

    print(dp[n])