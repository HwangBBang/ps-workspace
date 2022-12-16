import sys
input = sys.stdin.readline


n = int(input())

A = list(map(int,input().split()))
A = [0]+A
dp = [0]*(n+1)

dp[1] = A[1]

# 1

# 1 100

# 1 2

# 1 2 50

# 1 2 50 60

# 1 2 3 

# 1 2 3 5 

# 1 2 3 5 6

# 1 2 3 5 6 7

# 1 2 3 5 6 7 8

for i in range(2,n+1):
    for j in range(i):
        
        # 이전 항(j)가 피벗 항(i)보다 작으면 
        if A[j] < A[i]:
            dp[i] = max(dp[i], dp[j]+A[i])
        # 이전 항(j)가 피벗 항(i)보다 크먄
        else:
            dp[i] = max(dp[i], A[i])

print(max(dp))



