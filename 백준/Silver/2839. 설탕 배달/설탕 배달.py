n = int(input())

dp = [-1 for _ in range(5001)]


# n = 3 / 1 # dp[3]
# n = 5 / 1 # dp[5]
# n = 6 / 2 # dp[3]+dp[3]
# n = 8 / 2 # dp[3]+dp[5]
# n = 9 / 3 # dp[3]+dp[6]
# n = 10 / 2 # dp[5]+dp[5]
# n = 11 / 3 # dp[5]+dp[6]
# n = 12 / 4 # dp[3]+dp[9]
# n = 13 / 3 # dp[3]+dp[10]
# n = 15 / 3 # min(dp[3]+dp[12], dp[5]+dp[10])
dp[3] = 1
dp[5] = 1

# dp 테이블 작성
for i in range(6, n + 1):
# a : 5키로 추가 전 무게의 봉투 최소값
# b : 3키로 추가 전 무게의 봉투 최소값
    a, b = dp[i], dp[i] 

# 5키로 추가 전 메모라값 할당
    if dp[i - 5] != -1:
        a = dp[i - 5]
# 3키로 추가 전 메모리값 할당
    if dp[i - 3] != -1:
        b = dp[i - 3]

# 3, 5키로 둘 다 가능하다면 둘 중 작은 값 선택
    if a > 0 and b > 0:
        dp[i] = min(a + 1, b + 1)
# 5키로 추가만 가능하다면 5키로 전 dp값에 1추가
    elif a > 0 and b < 0:
        dp[i] = a + 1
# 3키로 추가만 가능하다면 3키로 전 dp값에 1 추가
    elif a < 0 and b > 0:
        dp[i] = b + 1
# 둘 다 불가능하다면 연산 불가 (-1) 할당
    else:
        dp[i] = -1

print(dp[n])