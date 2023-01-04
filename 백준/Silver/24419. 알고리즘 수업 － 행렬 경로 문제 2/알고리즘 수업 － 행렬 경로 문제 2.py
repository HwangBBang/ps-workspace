
n = int(input())
matrix = []

dp = [[1 for _ in range(n+1)]for _ in range(n+1)]
# dp = [0 for _ in range(n+1)]
global time1
global time2
time1,time2 = 0,0
for i in range(0,n):

    matrix.append(list(map(int,input().split())))

# def matrix_path1(matrix,n): # (1, 1)에서 (n, n)에 이르는 최고 점수를 구한다.
#     global time1
#     return matrix_path_rec(matrix, n, n)

# def matrix_path_rec(matrix, i, j):   # (1, 1)에서 (i, j)에 이르는 최고 점수를 구한다.
#     global time1
#     if (i == 0 or j == 0) :
#         time1 += 1
#         return 0 # 코드1
#     else:
#         return (matrix[i][j] + (max(matrix_path_rec(matrix, i-1, j), matrix_path_rec(matrix, i, j-1))))

# 시간 초과로인한..
# def matrix_path2(matrix, n):  # (1, 1)에서 (n, n)에 이르는 최고 점수를 구한다.
#     global time2
#     for i in range(1,n+1):
#         for j in range(1,n+1):
#             dp[i][j] = matrix[i][j] + max(dp[i-1][j], dp[i][j-1])  # 코드2
#             time2 += 1
            
#     return dp[n][n]
    

# matrix_path1(matrix, n)
# matrix_path2(matrix, n)

dp[1][1] = 2


for i in range(1,n+1):
    for j in range(1,n+1):
        dp[i][j] = dp[i][j-1]%1000000007 + dp[i-1][j]%1000000007

print(dp[n][n]%1000000007,pow(n,2)%1000000007)

